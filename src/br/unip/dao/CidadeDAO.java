package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.models.Cidade;
import br.unip.utils.ConnectionFactory;

public class CidadeDAO {
	
	//ADD Cidade
	public boolean adicionar(Cidade cidade){
			
		String sql = "INSERT INTO tbl_cidade(idEstado, nome) VALUES(?,?)";
			
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
			
		try {
				
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setInt(1, cidade.getIdEstado());
			stm.setString(2, cidade.getNome());
				
			stm.execute();
				
			fab.fecharConexao();
				
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	public ArrayList<Cidade> listarCidades(int idEstado){
		
		ArrayList<Cidade> cidades = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_cidade WHERE idEstado = ?";
		
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			stm.setInt(1, idEstado);
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				Cidade cidade = new Cidade();
				cidade.setId( rs.getInt("id") );
				cidade.setNome( rs.getString("nome") );
				cidade.setIdEstado( rs.getInt("idEstado") );
				cidades.add(cidade);
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return cidades;
	}

}
