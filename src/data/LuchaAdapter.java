package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Personaje;
import util.ErrorConexionException;

public class LuchaAdapter {
	public void guardar(Personaje pjGan, Personaje pjPer) throws Exception, ErrorConexionException
		{
			ResultSet rs=null;
			PreparedStatement stmt=null;
			
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into partida(id_personaje_ganador, id_personaje_perdedor)"+
						" values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
				// by the autoincrement column. Otherwise don't use it
							
				stmt.setInt(1, pjGan.getId());
				stmt.setInt(2, pjPer.getId());
				stmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ErrorConexionException("Error al guardar partida", e);
			} catch (ErrorConexionException e) {
				throw e;
			}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null)stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				} catch (ErrorConexionException e) {
					throw e;
				} catch (SQLException e) {
					throw new ErrorConexionException("Error al cerrar conexion",e);
				}
			}
	}
}
