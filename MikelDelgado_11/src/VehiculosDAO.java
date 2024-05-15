import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VehiculosDAO {
	private Statement nuevo;
	private PreparedStatement into;
	private int coche_id;
	private String marca;
	private String modelo;
	private String matricula;
	private int año_matricula;
	private int potencia;

	/* Metodo con el cual podremos sacar todos los datos de los vehiculos insertados en la base de datos
	 * 
	 */
	public void obtenerValores() {
		ConnectionBD conectar = new ConnectionBD();
		Connection con = conectar.openConnection();
		try {
			//Creamos el statement y el resultSet con la consulta que queremos hacer
			nuevo = con.createStatement();
			ResultSet resultado = nuevo.executeQuery("select * from coches");
			//Con el bulce while vamos sacando los datos de las filas que nos da la consulta
			while (resultado.next()) {
				System.out.println("-Cod_Identificador: "+resultado.getInt("coche_id")+" "+"-MARCA: " + resultado.getString("marca") +
						" " + "-MODELO: "+ resultado.getString("modelo") + " " +"-Matricula: "+ resultado.getString("matricula")+" " 
						+"-Año de matriculacion: "+resultado.getInt("anio_matriculacion")+"-POTENCIA: " + resultado.getString("potencia") + "Cv");
			}
			resultado.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}
		conectar.closeConnection();
	}
	//Metodo con el cual insertaremos vehiculos en la base de datos
	public void insertarNuevoVehiculo() {
		Scanner opcion = new Scanner(System.in);
		//Con en esta parte capturamos los datos y los guardamos en variables
		System.out.println("Introduzca el codigo del vehiculo");
		coche_id = opcion.nextInt();
		System.out.println("Introduzca la marca");
		marca = opcion.next();
		System.out.println("Introduzca el modelo");
		modelo = opcion.next();
		System.out.println("Introduce la matricula");
		matricula = opcion.next();
		System.out.println("Introduce el año de matriculacion");
		año_matricula = opcion.nextInt();
		System.out.println("Introduce la potencia");
		potencia = opcion.nextInt();
		//Realizamos la connexion
		ConnectionBD conectar = new ConnectionBD();
		Connection con = conectar.openConnection();
		try {
			/*Creamos un statement preparado, luego con su metodo set agregamos las variables capturadas
				y luego ejecutamos el update*/
			into = con.prepareStatement("insert into coches values(?,?,?,?,?,?)");
			into.setInt(1, coche_id);
			into.setString(2, marca);
			into.setString(3, modelo);
			into.setString(4, matricula);
			into.setInt(5, año_matricula);
			into.setInt(6, potencia);
			into.executeUpdate();
			into.close();
		} catch (SQLException e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		conectar.closeConnection();
	}
	/*Metodo con el cual podremos cambiar el parametro de potencia en la base de datos,
	 * introduciendo la matricula del vehiculo a modificar
	 */
	public void actualizarPotencia() {
		Scanner opcion = new Scanner(System.in);
		System.out.println("Introduzca la matricula del vehiculo que quieres modificar");
		matricula=opcion.next();
		System.out.println("Introduzca la nueva potencia");
		potencia=opcion.nextInt();
		//Realizamos la connexion
		ConnectionBD conectar = new ConnectionBD();
		Connection con = conectar.openConnection();
		/*Creamos un statement con la sentencia a ejecutar, en la cual añadiremos con su metodos set
		 * los datos pedidos al usuario
		 */
		try {
			into = con.prepareStatement("update coches set potencia =? where matricula=?");
			into.setInt(1, potencia);
			into.setString(2, matricula);
			into.executeUpdate();
			into.close();
		}catch(SQLException e) {
			System.out.println("SQL Excepcion: "+e.getMessage());
		}
		conectar.closeConnection();
	}
	/* Metodo con el cual pediremos al usuario la matricula del vehiculo que desea borrar 
	 * de la base de datos
	 */
	public void borrarVehiculo() {
		Scanner opcion = new Scanner(System.in);
		System.out.println("Introduzca la matricula del vehiculo que quieres eliminar");
		matricula=opcion.next();
		//Realizamos la connexion
				ConnectionBD conectar = new ConnectionBD();
				Connection con = conectar.openConnection();
				/*Creamos un statement con la sentencia a ejecutar, en la cual añadiremos con su metodos set
				 * los datos pedidos al usuario, en este caso la matricula del vehiculo a eliminar
				 */
				try {
					into = con.prepareStatement("delete from coches where matricula=?");
					into.setString(1, matricula);
					into.executeUpdate();
					into.close();
				}catch(SQLException e) {
					System.out.println("SQL Excepcion: "+e.getMessage());
				}
				conectar.closeConnection();
	}
	public void obtenerValoresMarca() {
		Scanner opcion = new Scanner(System.in);
		System.out.println("Introduzca la marca de los vehiculos que quieres visualizar");
		marca=opcion.next();
		//Realizamos la connexion
				ConnectionBD conectar = new ConnectionBD();
				Connection con = conectar.openConnection();
				/*Creamos un statement con la sentencia a ejecutar, en la cual añadiremos con su metodos set
				 * los datos pedidos al usuario, en este caso la marca de los vehiculos que queremos ver,
				 * ademas de un ResulSet para guardar los datos de la busqueda
				 */
				try {
					into = con.prepareStatement("select * from coches where marca =?");
					into.setString(1, marca);
					ResultSet resultado = into.executeQuery();
					while(resultado.next()) {
						System.out.println("-Cod_Identificador: "+resultado.getInt("coche_id")+" "+"-MARCA: " + resultado.getString("marca") +
						" " + "-MODELO: "+ resultado.getString("modelo") + " " +"-Matricula: "+ resultado.getString("matricula")+" " 
						+"-Año de matriculacion: "+resultado.getInt("anio_matriculacion")+"-POTENCIA: " + resultado.getString("potencia") + "Cv");
					}
					resultado.close();
					into.close();
				}catch(SQLException e) {
					System.out.println("SQL Excepcion: "+e.getMessage());
				}
				conectar.closeConnection();
		
	}

}
