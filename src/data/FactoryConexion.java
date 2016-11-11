package data;
import util.*;
import com.mysql.jdbc.Driver;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class FactoryConexion {
	//Capturo datos de config.properties
	private String dbDriver="com.mysql.jdbc.Driver";
	private String host;
	private String port="3306";
	private String user;
	private String pass;
	private String db="luchagh";
	private String dbType="mysql";
	
	private Connection conn;
	private int cantConn=0;
	
	private FactoryConexion() throws DriverNoEncontradoException{
		try {
			Class.forName(dbDriver);
			
			Properties propiedades = new Properties();
		    InputStream entrada = null;
		    
		    //entrada = new FileInputStream("configs/config.properties");
		    //propiedades.load(entrada);
			
		    //host = propiedades.getProperty("host");
		    //user = propiedades.getProperty("user");
		    //pass = propiedades.getProperty("pass");
		    
		    host = "85.10.205.173";
		    user = "usergh";
    		pass = "rootgh";
		    
			
		} catch (ClassNotFoundException e) {
			throw new DriverNoEncontradoException("Error del Driver JDBC", e);
		} catch (Exception ex) {
			throw new DriverNoEncontradoException("Error en rchivo de configuracion.", ex);
		}
	}
	
	private static FactoryConexion instancia;
	
	public static FactoryConexion getInstancia() throws DriverNoEncontradoException{
		if (instancia==null){
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn() throws ErrorConexionException{
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass+"&useSSL=false");
				cantConn++;
			}
		} catch (SQLException e) {
			throw new ErrorConexionException("Error al conectar a la DB", e);

		}
		return conn;
	}
	
	public void releaseConn() throws ErrorConexionException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ErrorConexionException("Error al cerrar conexión", e);
		}
		
	}
}
