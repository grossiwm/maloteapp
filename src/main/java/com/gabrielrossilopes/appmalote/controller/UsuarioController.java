package com.gabrielrossilopes.appmalote.controller;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.repository.EmpresaRepository;
import com.gabrielrossilopes.appmalote.service.EmpresaService;
import com.gabrielrossilopes.appmalote.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		model.addAttribute("usuario", usuarioLogado);
		return "perfil";
	}

	@GetMapping("/403")
	@ResponseBody
	public String forbidden() {
		return "<html><body><h1> 403 - Forbidden </h2></body></html>";
	}

	@GetMapping("/solicitar-acesso")
	public String solcicitarAcesso(Model model	) {
		model.addAttribute("empresas", empresaService.buscaTodas());
		return "solicitarAcesso";
	}

	@PostMapping("/solicitar-acesso")
	public String processaSolicitacao(UsuarioDTO usuarioDTO) {
		Optional<Empresa> empresaOp = empresaService.buscaPorId(usuarioDTO.getEmpresa());

		Usuario usuario = new Usuario();
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
	
}
