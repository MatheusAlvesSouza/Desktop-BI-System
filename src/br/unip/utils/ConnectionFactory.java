package br.unip.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	Connection con;
	
	public Connection abrirConexao(){
		
		con = null;
		
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/native_human", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void fecharConexao(){
		
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
