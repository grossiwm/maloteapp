package com.gabrielrossilopes.appmalote.controller;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Deposito;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Malote;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.service.DepositoService;
import com.gabrielrossilopes.appmalote.service.EmpresaService;
import com.gabrielrossilopes.appmalote.service.MaloteService;
import com.gabrielrossilopes.appmalote.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioLogadoSession usuarioLogado;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DepositoService depositoService;

	@Autowired
	private MaloteService maloteService;

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = usuarioService.getUsuarioById(usuarioLogado.getId()).get();
		model.addAttribute("usuario", usuario);
		return "perfil";
	}

	@GetMapping("/403")
	@ResponseBody
	public String forbidden() {
		return "<html><body><h1> 403 - Forbidden </h2></body></html>";
	}

	@GetMapping("/solicitar-acesso")
	public String solcicitarAcesso(Model model	) {
		model.addAttribute("empresas", empresaService.buscaTodasOrdenado());
		return "solicitarAcesso";
	}

	@PostMapping("/solicitar-acesso")
	public String processaSolicitacao(UsuarioDTO usuarioDTO) {
		Optional<Empresa> empresaOp = empresaService.buscaPorId(usuarioDTO.getEmpresa());

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmpresa(empresaOp.get());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setAdmin(false);
		usuario.setAceito(false);

		usuarioService.cadastrarUsuario(usuario);

		return "redirect:/usuario/perfil";
	}

	@GetMapping("/aguardando-aceite")
	public String aguardando(Model model) {
		String username = usuarioLogado.getEmail().split("@")[0];
		model.addAttribute("username",username);
		if (usuarioLogado.isAceito())
			return "redirect:/usuario/perfil";
		return "aguardandoAceite";
	}

	@GetMapping("/listar-usuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.busucaTodos();
		usuarios = usuarios.stream().filter(u -> !u.isAdmin()).toList();
		model.addAttribute("usuarios", usuarios);
		return "admin/listarUsuarios";
	}

	@GetMapping("novo-malote")
	public String novoMalote() {
		Usuario usuario = usuarioService.getUsuarioById(usuarioLogado.getId()).get();
		Malote malote = new Malote();
		malote.setEmpresa(usuario.getEmpresa());
		maloteService.salvaMalote(malote);

		return "redirect:/usuario/alterar-malote/" + malote.getId();
	}

	@GetMapping("/alterar-malote/{id}")
	public String alterarMalote(Model model, @PathVariable Long id) {
		Malote malote = maloteService.getById(id);
		model.addAttribute("malote", malote);
		List<Deposito> depositos = depositoService.getAllDepositos();
		model.addAttribute("depositos", depositos);
		return "alterarMalote";
	}

	@PostMapping("/alterar-malote/{id}")
	public String salvaMalote(HttpServletRequest req, @PathVariable Long id) {
		List<String> depositoIds = List.of(req.getParameterMap().get("deposito-id"));
		Malote malote = maloteService.getById(id);
		depositoIds.stream().map(Long::valueOf).forEach(i -> {
			Deposito deposito = depositoService.buscaPorId(i);
			deposito.setMalote(malote);
			depositoService.salvaDeposito(deposito);
		});

		return "redirect:/usuario/alterar-malote/" + id;
	}

	@GetMapping("/malote/{maloteId}/remover-deposito/{depositoId}")
	public String removerDepositoDeMalote(@PathVariable Long maloteId, @PathVariable Long depositoId) {
		depositoService.removeDeMalote(depositoId);
		return "redirect:/usuario/alterar-malote/" + maloteId;

	}

}
