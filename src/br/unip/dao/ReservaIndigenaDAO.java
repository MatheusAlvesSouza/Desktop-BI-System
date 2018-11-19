package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.models.ReservaIndigena;
import br.unip.utils.ConnectionFactory;

public class ReservaIndigenaDAO {
	
	//ADD Reserva
	public boolean adicionar(ReservaIndigena reservaIndigena){
			
		String sql = "INSERT INTO tbl_reserva_indigena(idCidade, nome, populacao) VALUES(?,?, 0)";
			
		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
			
		try {
				
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			stm.setInt(1, reservaIndigena.getIdCidade());
			stm.setString(2, reservaIndigena.getNome());
				
			stm.execute();
				
			fab.fecharConexao();
				
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	public ArrayList<ReservaIndigena> listarReservas(int idEstado){
		
		ArrayList<ReservaIndigena> reservas = new ArrayList<>();
		String sql = "SELECT * FROM tbl_reserva_indigena ";
		
		if ( idEstado > 0) {
			sql = sql + " AS r\r\n" + 
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
				ReservaIndigena reserva = new ReservaIndigena();
				reserva.setId( rs.getInt("id") );
				reserva.setIdCidade( rs.getInt("idCidade") );
				reserva.setNome( rs.getString("nome") );
				reserva.setPopulacao(rs.getInt("populacao"));
				reservas.add(reserva);
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return reservas;
	}
	
	public ReservaIndigena getReserva(int id){	

		ReservaIndigena reserva = new ReservaIndigena();
		String sql = "SELECT * FROM tbl_reserva_indigena WHERE id = ?";

		ConnectionFactory fab = new ConnectionFactory();
		Connection con = fab.abrirConexao();//Estancia a conexao usada no statement
		
		try {
			
			PreparedStatement stm = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs;
			
			stm.setInt(1, id);
			
			rs = stm.executeQuery();

			
			while( rs.next() ){
				reserva.setId( rs.getInt("id") );
				reserva.setIdCidade( rs.getInt("idCidade") );
				reserva.setNome( rs.getString("nome") );
				reserva.setPopulacao(rs.getInt("populacao"));
			}
			
			fab.fecharConexao();
			
		} catch (SQLException e) {}
		
		return reserva;
	}

}
