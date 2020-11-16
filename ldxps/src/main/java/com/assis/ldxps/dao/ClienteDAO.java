package com.assis.ldxps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.assis.ldxps.config.FabricaDeConexao;
import com.assis.ldxps.dominio.Cliente;
import com.assis.ldxps.dominio.Vendedor;


public class ClienteDAO {
	
	public void inserir(Cliente cliente) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "insert into clientes" + "(cdCL, cdVend, dsNome, idTipo, dsLim)" + " values (uuid(), ?, ?, ?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cliente.getCdVend());
			stmt.setString(2, cliente.getDsNome());
			stmt.setString(3, cliente.getIdTipo());
			stmt.setDouble(4, cliente.getDsLim());

			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception err) {
			System.out.println("Erro ao inserir vendedor: " + err.getMessage());
		}
	}
	
	public List<Cliente> listagem(String cdVend) {
		List<Cliente> lista = new ArrayList<>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from clientes where cdVend = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cdVend);
			ResultSet resultado = stmt.executeQuery(); // recebe resultado da query
			while(resultado.next()) {
				Cliente c = new Cliente(resultado.getString("cdCl"), 
										resultado.getString("dsNome"),
										resultado.getString("cdVend"), 
										resultado.getString("idTipo"), resultado.getDouble("dsLim"));
				lista.add(c); 
			}
		} catch (Exception err) {
			System.out.println("Erro na obtenção da lista de vendedores: " + err.getMessage());
		}
		return lista;
	}
	
	public List<Cliente> listagemTodos() {
		List<Cliente> lista = new ArrayList<>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from clientes";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); // recebe resultado da query
			while(resultado.next()) {
				Cliente c = new Cliente(resultado.getString("cdCl"), 
										resultado.getString("dsNome"),
										resultado.getString("cdVend"), 
										resultado.getString("idTipo"), resultado.getDouble("dsLim"));
				lista.add(c); 
			}
		} catch (Exception err) {
			System.out.println("Erro na obtenção da lista de vendedores: " + err.getMessage());
		}
		return lista;
	}
	public Cliente buscarPorCdCl(String cdCl) {
		Cliente c = null;
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from clientes where cdCl = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cdCl);
			ResultSet resultado = stmt.executeQuery();
			resultado.next();
			c = new Cliente(resultado.getString("cdCl"), 
							resultado.getString("dsNome"),
							resultado.getString("cdVend"), 
							resultado.getString("idTipo"), resultado.getDouble("dsLim"));
			resultado.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public void atualizar(Cliente c) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "update clientes set dsNome=?, idTipo=?, dsLim=?"
				+ " where cdCl = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getDsNome());
			stmt.setString(2, c.getIdTipo());
			stmt.setDouble(3, c.getDsLim());
			stmt.setString(4, c.getCdCl());
			System.out.println("----------------> \n" + stmt);
		
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void excluir(String cdCl) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "delete from clientes where cdCl = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cdCl);
			
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
