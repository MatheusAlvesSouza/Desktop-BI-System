package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.models.Estado;
import br.unip.utils.ConnectionFactory;

public class EstadoDAO {
	
	public ArrayList<Estado> listarEstados(int idPais){
		
		ArrayList<Estado> estados = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_estado WHERE idPais = ?";
		
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			stm.setInt(1, idPais);
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				Estado estado = new Estado();
				estado.setId( rs.getInt("id") );
				estado.setNome( rs.getString("nome") );
				estado.setIdPais( rs.getInt("idPais") );
				estados.add(estado);
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return estados;
	}

}
