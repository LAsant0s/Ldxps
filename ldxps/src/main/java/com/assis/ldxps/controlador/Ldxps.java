package com.assis.ldxps.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assis.ldxps.dao.ClienteDAO;
import com.assis.ldxps.dao.VendedorDAO;
import com.assis.ldxps.dominio.Cliente;
import com.assis.ldxps.dominio.Vendedor;

@Controller
public class Ldxps {
 
	@RequestMapping("/home")
	public String cadastrar(@RequestParam(value="cdVend", required = false)String cdVend, Model modelo) {
		List<Cliente> listaCliente = null; 
		VendedorDAO vDao = new VendedorDAO();
		ClienteDAO cDao = new ClienteDAO(); 
		List<Vendedor> lista = vDao.listagem();
		modelo.addAttribute("lista", lista);
		modelo.addAttribute("vendedor", new Vendedor());
		if(cdVend != null) {
			if(cdVend.length() > 1) {				
				listaCliente = cDao.listagem(cdVend); 
			} else {
				listaCliente = cDao.listagemTodos(); 
			}
		}
		modelo.addAttribute("listaCliente", listaCliente);
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("cdVendSelecionado", cdVend);
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
	public String atualizar(Vendedor v ,@RequestParam(value="cdVend", required = false)String cdVend, Model modelo) {
		VendedorDAO dao = new VendedorDAO(); 
		Vendedor vendedor = dao.buscarPorCdVend(cdVend); 
		modelo.addAttribute("vendedor", vendedor); 
		return "atualizar-vendedor";
	}
	
	@RequestMapping("/salvar-alteracoes")
	public String atualizar2(Vendedor vendedor) {
		VendedorDAO dao = new VendedorDAO();
		dao.atualizar(vendedor);
		return "mensagem";
	}
	
	@RequestMapping("/excluir-vendedor")
	public String excluir(@RequestParam(value="cdVend", required = false)String cdVend) {
		VendedorDAO dao = new VendedorDAO();
		dao.excluir(cdVend);
		return "mensagem"; 
	}
	
	@RequestMapping("/cadastro-cliente")
	public String cadastroCliente(Cliente cliente, @RequestParam(value="cdVend")String cdVend, Model modelo) {	
		cliente = new Cliente(); 
		cliente.setCdVend(cdVend);
		modelo.addAttribute("cdVendedor", cdVend); 
		return "cadastro-cliente"; 
	}
	
	@RequestMapping("/salvar-cliente") 
	public String salvarCliente(Cliente cliente) {
		ClienteDAO dao = new ClienteDAO(); 
		dao.inserir(cliente);
		return "mensagem";
	}
}
