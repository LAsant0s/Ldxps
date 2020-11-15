package com.assis.ldxps.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assis.ldxps.dao.VendedorDAO;
import com.assis.ldxps.dominio.Vendedor;

@Controller
public class Ldxps {
 
	@RequestMapping("/home")
	public String cadastrar(Model modelo) {
		VendedorDAO dao = new VendedorDAO();
		List<Vendedor> lista = dao.listagem();
		modelo.addAttribute("lista", lista);
		modelo.addAttribute("vendedor", new Vendedor());
		return "home";
	}
	
	@RequestMapping("/criar-v")
	public String cadastrarVendedor(Vendedor vendedor) {
		return "cadastro-vendedor";
	}
	
	@RequestMapping("/salvar-vendedor") 
	public String salvar(Vendedor vendedor) {
		VendedorDAO dao = new VendedorDAO(); 
		dao.inserir(vendedor);
		return "mensagem";
	}
	
	@RequestMapping("/atualizar-vendedor")
	public String atualizar(@RequestParam(value="cdVend", required = false)String cdVend, Model modelo) {
		
		return null;
	}
	
}
