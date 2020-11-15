package com.assis.ldxps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.assis.ldxps.config.FabricaDeConexao;
import com.assis.ldxps.dominio.Cliente;


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
	
}
