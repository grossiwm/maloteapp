package com.gabrielrossilopes.appmalote.controller;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.model.dominio.*;
import com.gabrielrossilopes.appmalote.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
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
	private PagamentoService pagamentoService;

	@Autowired
	private MaloteService maloteService;

	@Autowired
	private TransferenciaService transferenciaService;

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
		usuarios = usuarios.stream().filter(u -> !u.isAdmin()).sorted(Comparator.comparing(Usuario::getNome)).toList();
		model.addAttribute("usuarios", usuarios);
		return "admin/listarUsuarios";
	}

	@GetMapping("/listar-depositos")
	public String listarDepositos(Model model) {
		List<Deposito> depositos = depositoService.getAllDepositos().stream().sorted(Comparator.comparing(Deposito::getNomeBeneficiario)).toList();
		model.addAttribute("depositos", depositos);
		return "listarDepositos";
	}

	@GetMapping("/alterar-deposito/{id}")
	public String alterarDeposito(Model model, @PathVariable Long id) {
		Deposito deposito = depositoService.buscaPorId(id);
		model.addAttribute("deposito", deposito);
		return "alterarDeposito";
	}

	@PostMapping("/alterar-deposito")
	public String alterarDeposito(Deposito deposito) {
		depositoService.salvaDeposito(deposito);
		return "redirect:/usuario/listar-depositos";
	}

	@GetMapping("/novo-deposito")
	public String novoDeposito(Model model) {
		Deposito deposito = new Deposito();
		model.addAttribute("deposito", deposito);
		return "alterarDeposito";
	}

	@PostMapping("/novo-deposito")
	public String novoDeposito(Deposito deposito) {
		depositoService.salvaDeposito(deposito);
		return "redirect:/usuario/listar-depositos";
	}

	@GetMapping("/remove-deposito/{id}")
	public String removeDeposito(@PathVariable Long id) {
		Deposito deposito = depositoService.buscaPorId(id);
		depositoService.removeDeposito(deposito);
		return "redirect:/usuario/listar-depositos";
	}

	@GetMapping("/listar-pagamentos")
	public String listarPagamentos(Model model) {
		List<Pagamento> pagamentos = pagamentoService.getAllPagamentos().stream().sorted(Comparator.comparing(Pagamento::getCnpjRecebedor)).toList();
		model.addAttribute("pagamentos", pagamentos);
		return "listarPagamentos";
	}

	@GetMapping("/alterar-pagamento/{id}")
	public String alterarPagamento(@PathVariable Long id, Model model) {
		Pagamento pagamento = pagamentoService.buscarPorId(id);
		model.addAttribute("pagamento", pagamento);
		return "alterarPagamento";
	}

	@PostMapping("/alterar-pagamento")
	public String alterarPagamento(Pagamento pagamento) {
		pagamentoService.salvarPagamento(pagamento);
		return "redirect:/usuario/listar-pagamentos";
	}

	@GetMapping("/novo-pagamento")
	public String novoPagamento(Model model) {
		Pagamento pagamento = new Pagamento();
		model.addAttribute("pagamento", pagamento);
		return "alterarPagamento";
	}

	@PostMapping("/novo-pagamento")
	public String novoPagamento(Pagamento pagamento) {
		pagamentoService.salvarPagamento(pagamento);
		return "redirect:/usuario/listar-pagamentos";
	}

	@GetMapping("/remove-pagamento/{id}")
	public String removePagamento(@PathVariable Long id) {
		Pagamento pagamento = pagamentoService.buscarPorId(id);
		pagamentoService.removerPagamento(pagamento);
		return "redirect:/usuario/listar-pagamentos";
	}

	@GetMapping("/listar-transferencias")
	public String listarTransferencias(Model model) {
		List<Transferencia> transferencias = transferenciaService.getAllTransferencia();
		model.addAttribute("transferencias", transferencias);
		return "listarTransferencias";
	}

	@GetMapping("/alterar-transferencia/{id}")
	public String alterarTransferencia(@PathVariable Long id, Model model) {
		Transferencia transferencia = transferenciaService.buscaPorId(id);
		model.addAttribute("transferencia", transferencia);
		return "alterarTransferencia";
	}

	@PostMapping("/alterar-transferencia")
	public String alterarTransferencia(Transferencia transferencia) {
		transferenciaService.salvaTransferencia(transferencia);
		return "redirect:/usuario/listar-transferencias";
	}

	@GetMapping("/nova-transferencia")
	public String novaTransferencia(Model model) {
		Transferencia transferencia = new Transferencia();
		model.addAttribute("transferencia", transferencia);
		return "alterarTransferencia";
	}

	@PostMapping("/nova-transferencia")
	public String novaTransferencia(Transferencia transferencia) {
		transferenciaService.salvaTransferencia(transferencia);
		return "redirect:/usuario/listar-transferencias";
	}

	@GetMapping("/remove-transferencia/{id}")
	public String removeTransferencia(@PathVariable Long id) {
		Transferencia transferencia = transferenciaService.buscaPorId(id);
		transferenciaService.removeTransferencia(transferencia);
		return "redirect:/usuario/listar-transferencias";
	}

	@GetMapping("/novo-malote")
	public String novoMalote() {
		Usuario usuario = usuarioService.getUsuarioById(usuarioLogado.getId()).get();
		Malote malote = new Malote();
		malote.setEmpresa(usuario.getEmpresa());
		malote.setUsuario(usuario);
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
