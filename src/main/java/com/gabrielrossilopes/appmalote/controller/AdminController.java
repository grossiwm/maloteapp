package com.gabrielrossilopes.appmalote.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		model.addAttribute("empresas", empresaService.buscaTodas());
		return "admin/cadastrarUsuario";
	}

	@PostMapping("/cadastrar-usuario")
	public String recebeUsuario(UsuarioDTO usuarioDTO) {
		Optional<Empresa> empresaOp = empresaService.buscaPorId(usuarioDTO.getEmpresa());
		
		Usuario usuario = new Usuario();
		usuario.setEmpresa(empresaOp.get());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		
		usuarioService.cadastrarUsuario(usuario);
		
		return "redirect:/admin/listarUsuarios";
	}
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.busucaTodos();
		usuarios = usuarios.stream().filter(u -> !u.isAdmin()).toList();
		model.addAttribute("usuarios", usuarios);
		
		return "admin/listarUsuarios";
	}
	
	@GetMapping("/listarEmpresas")
	public String listarEmpresas(Model model) {
		List<Empresa> empresas = empresaService.buscaTodas();
		model.addAttribute("empresas", empresas);
		
		return "admin/listarEmpresas";
	}
	
}
