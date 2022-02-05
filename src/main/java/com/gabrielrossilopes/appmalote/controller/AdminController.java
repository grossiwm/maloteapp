package com.gabrielrossilopes.appmalote.controller;

import java.util.List;
import java.util.Optional;

import com.gabrielrossilopes.appmalote.dto.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.service.EmpresaService;
import com.gabrielrossilopes.appmalote.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/cadastrar-usuario")
	public String cadastrarUsuario(Model model) {
		model.addAttribute("empresas", empresaService.buscaTodasOrdenado());
		return "admin/cadastrarUsuario";
	}

	@PostMapping("/cadastrar-usuario")
	public String recebeUsuario(UsuarioDTO usuarioDTO, Model model) {
		try {
			Optional<Empresa> empresaOp = empresaService.buscaPorId(usuarioDTO.getEmpresa());
			Usuario usuario = new Usuario();
			usuario.setEmpresa(empresaOp.get());
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setSenha(usuarioDTO.getSenha());
			usuario.setNome(usuarioDTO.getNome());
			usuarioService.cadastrarUsuario(usuario);
			return "redirect:/admin/listar-usuarios";
		} catch (Exception e) {
			model.addAttribute("empresas", empresaService.buscaTodasOrdenado());
			model.addAttribute("usuario", usuarioDTO);
			model.addAttribute("error", true);
			return "admin/cadastrarUsuario";
		}

	}
	
	@GetMapping("/listar-usuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.busucaTodos();
		usuarios = usuarios.stream().filter(u -> !u.isAdmin()).toList();
		model.addAttribute("usuarios", usuarios);
		return "admin/listarUsuarios";
	}

	@GetMapping("/editar-usuario/{id}")
	public String alteraUsuario(Model model, @PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id).get();
		UsuarioDTO usuarioDTO = UsuarioDTO.getUsuarioDTOdeUsuario(usuario);
		model.addAttribute("usuario", usuarioDTO);
		model.addAttribute("empresas", empresaService.buscaTodasOrdenado());
		return "admin/editarUsuario";
	}

	@PostMapping("/editar-usuario")
	public String alteraUsuario(UsuarioDTO usuarioDTO, Model model) {
		try {
			Optional<Empresa> empresaOp = empresaService.buscaPorId(usuarioDTO.getEmpresa());
			Usuario usuario = usuarioService.getUsuarioById(usuarioDTO.getId()).get();
			usuario.setEmpresa(empresaOp.get());
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setSenha(usuarioDTO.getSenha());
			usuarioService.cadastrarUsuario(usuario);
			return "redirect:/admin/listar-usuarios";
		} catch (Exception e) {
			model.addAttribute("empresas", empresaService.buscaTodasOrdenado());
			model.addAttribute("usuario", usuarioDTO);
			model.addAttribute("error", true);
			return "admin/editarUsuario";
		}

	}

	@GetMapping("/remove-usuario/{id}")
	public String excluirUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id).get();
		usuarioService.removeUsuario(usuario);
		return "redirect:/admin/listar-usuarios";
	}

	@GetMapping("/listar-solicitacoes")
	public String listarSolicitacoes(Model model) {
		List<Usuario> usuarios = usuarioService.busucaTodos();
		usuarios = usuarios.stream().filter(u -> !u.isAdmin() && !u.isAceito()).toList();
		model.addAttribute("usuarios", usuarios);
		return "admin/listarSolicitacoes";
	}

	@GetMapping("/aceitar-usuario/{id}")
	public String aceitarUsuario(@PathVariable Long id) {
		usuarioService.aceitarUsuario(id);
		return "redirect:/admin/listar-solicitacoes";
	}
	
	@GetMapping("/listar-empresas")
	public String listarEmpresas(Model model) {
		List<Empresa> empresas = empresaService.buscaTodasOrdenado();
		model.addAttribute("empresas", empresas);
		return "admin/listarEmpresas";
	}

	@GetMapping("/cadastrar-empresa")
	public String cadastrarEmpresa() {
		return "admin/cadastrarEmpresa";
	}

	@PostMapping("/cadastrar-empresa")
	public String processaCadastroEmpresa(EmpresaDTO empresaDTO, Model model) {
		try {
			empresaService.criaEmpresa(empresaDTO);
			return "redirect:/admin/listar-empresas";
		} catch (Exception e) {
			model.addAttribute("empresa", empresaDTO);
			model.addAttribute("error", true);
			return "admin/cadastrarEmpresa";
		}

	}

	@GetMapping("/editar-empresa/{id}")
	public String editarEmpresa(Model model, @PathVariable Long id) {
		Empresa empresa = empresaService.buscaPorId(id).get();
		EmpresaDTO empresaDTO = EmpresaDTO.getEmpresaDTOdeEmpresa(empresa);
		model.addAttribute("empresa", empresaDTO);
		return "admin/editarEmpresa";
	}

	@PostMapping("/editar-empresa")
	public String processaEditarEmpresa(EmpresaDTO empresaDTO, Model model) {
		try {
			empresaService.alterarEmpresa(empresaDTO);
			return "redirect:/admin/listar-empresas";
		} catch (Exception e) {
			model.addAttribute("empresa", empresaDTO);
			model.addAttribute("error", true);
			return "admin/editarEmpresa";
		}
	}

	@GetMapping("/remove-empresa/{id}")
	public String excluirEmpresa(@PathVariable Long id) {
		Empresa empresa = empresaService.buscaPorId(id).get();
		empresaService.removeEmpresa(empresa);
		return "redirect:/admin/listar-empresas";
	}
	
}
