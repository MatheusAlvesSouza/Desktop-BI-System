package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.models.DenunciaDesmatamento;
import br.unip.utils.ConnectionFactory;

public class DenunciaDesmatamentoDAO {
	
	//ADD Denuncia
	public boolean adicionar(DenunciaDesmatamento denunciaDesmatamento){
			
		String sql = "INSERT INTO tbl_denuncia_desmatamento(idCidade, nome, descricao, data, ativo) VALUES(?,?,?,NOW(),1)";
			
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
			
		try {
				
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setInt(1, denunciaDesmatamento.getIdCidade());
			stm.setString(2, denunciaDesmatamento.getNome());
			stm.setString(3, denunciaDesmatamento.getDescricao());
				
			stm.execute();
				
			fab.fecharConexao();
				
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	public ArrayList<DenunciaDesmatamento> listarDenuncias(int idEstado){
		
		ArrayList<DenunciaDesmatamento> denuncias = new ArrayList<>();
		String sql = "SELECT * FROM tbl_denuncia_desmatamento ";
		
		if ( idEstado > 0) {
			sql = sql + " AS r WHERE ativo = 1 \r\n" + 
					"INNER JOIN tbl_cidade AS c\r\n" + 
					"ON r.idCidade = c.id\r\n" + 
					"INNER JOIN tbl_estado AS e\r\n" + 
					"ON c.id = \r\n" + 
					" " + idEstado;			
		}
		
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				DenunciaDesmatamento denuncia = new DenunciaDesmatamento();
				denuncia.setId( rs.getInt("id") );
				denuncia.setIdCidade( rs.getInt("idCidade") );
				denuncia.setNome( rs.getString("nome") );
				denuncia.setDescricao(rs.getString("descricao"));
				denuncias.add(denuncia);
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return denuncias;
	}
	
	public DenunciaDesmatamento getDenuncia(int id){	

		DenunciaDesmatamento denuncia = new DenunciaDesmatamento();
		String sql = "SELECT * FROM tbl_denuncia_desmatamento WHERE id = ?";

		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			stm.setInt(1, id);
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				denuncia.setId( rs.getInt("id") );
				denuncia.setIdCidade( rs.getInt("idCidade") );
				denuncia.setNome( rs.getString("nome") );
				denuncia.setDescricao(rs.getString("descricao"));
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return denuncia;
	}

}
