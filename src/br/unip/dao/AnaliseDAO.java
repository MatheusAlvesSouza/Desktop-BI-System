package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.models.Analise;
import br.unip.models.ReservaIndigena;
import br.unip.utils.ConnectionFactory;

public class AnaliseDAO {
	
	public ArrayList<Analise> listar(){
		
		ArrayList<Analise> analises = new ArrayList<>();
		
		String sql = "SELECT \r\n" + 
				"	RESERVA.id AS idReserva,\r\n" + 
				"	RESERVA.nome,\r\n" + 
				"	CIDADE.nome AS cidade,\r\n" + 
				"	ESTADO.nome AS estado,\r\n" + 
				"	COUNT(INDIO.id) AS populacao,\r\n" + 
				"	COUNT(DENUNCIA.id) AS denuncias\r\n" + 
				"FROM tbl_reserva_indigena AS RESERVA\r\n" + 
				"INNER JOIN tbl_cidade AS CIDADE\r\n" + 
				"ON RESERVA.idCidade = CIDADE.id\r\n" + 
				"INNER JOIN tbl_estado AS ESTADO\r\n" + 
				"ON CIDADE.idEstado = ESTADO.id\r\n" + 
				"LEFT JOIN tbl_indio AS INDIO\r\n" + 
				"ON  RESERVA.id = INDIO.idReservaIndigena\r\n" + 
				"LEFT JOIN tbl_denuncia_desmatamento AS DENUNCIA\r\n" + 
				"ON RESERVA.idCidade = DENUNCIA.idCidade\r\n" + 
				"GROUP BY (RESERVA.id) ORDER BY RESERVA.nome, CIDADE.nome, ESTADO.nome ASC";
		
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				int idReserva = rs.getInt("idReserva");
				Analise analise = getTaxas(idReserva);
				analise.setReserva( rs.getString("nome") );
				analise.setCidade( rs.getString("cidade") );
				analise.setPopulacao(rs.getInt("populacao"));
				analise.setDenuncias( rs.getInt("denuncias"));
				analise.setEstado( rs.getString("estado"));
				analises.add(analise);
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return analises;
	}
	
	public Analise getTaxas(int id){
		
		Analise analise = new Analise();
		int natalidade = 0;
		int mortalidade = 0;
		
		String sql = "SELECT * FROM tbl_reserva_indigena_log WHERE YEAR(data) = YEAR(NOW()) AND idReservaIndigena = " + id;
		
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				if( rs.getString("tipo").equals("INCREASE")) {
					natalidade++;
				} else {
					mortalidade++;
				}
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}		
		analise.setNatalidade( (natalidade * 100 ) /  50);
		analise.setMortalidade( (mortalidade * 100 )/ 50);
		return analise;
	}
	

}

