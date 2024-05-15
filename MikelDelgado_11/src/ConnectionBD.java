import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
		/*Atributos con los datos necesarios para conectarnos a la base de datos
		 * 
		 */
	private String conexionURL ="jdbc:mariadb://localhost:3306/concesionario?user=usuario&password=Password123";
	private Connection con;
	private String driver="org.mariadb.jdbc.Driver";
	
public ConnectionBD() {
}
	// Metodo para crear la connexion a la base de datos
public Connection openConnection() {
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(conexionURL);
	}catch(SQLException e) {
		System.out.println("SQL Exception: "+e.toString());
	}catch(ClassNotFoundException j) {
		System.out.println("Exception: "+j.toString());
	}
	return con;	
}
	//Metodo para cerrar la connexion a la base de datos
public Connection closeConnection() {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	
}

}
