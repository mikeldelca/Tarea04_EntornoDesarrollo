import java.util.Scanner;

public class MenuConcesionario {

	/* Metodo por el cual hacemos un menu con las opciones disponibles para utilizar
	 * en la base de datos
	 */
	public void menuPrincipal(VehiculosDAO vehiculos,MenuConcesionario concesionario) {
		System.out.println("***Inventario del concesionario***");
		System.out.println("***Opciones de gestion del inventario***");
		System.out.println("-1 Añadir vehiculo al inventario");
		System.out.println("-2 Actualizar la potencia de un vehiculo");
		System.out.println("-3 Eliminar un vehiculo");
		System.out.println("-4 Visualizar vehiculos segun la marca");
		System.out.println("-5 Visualizar todos los vehiculos del inventario");
		System.out.println("-6 Salir del programa");
		Scanner opcion = new Scanner(System.in);
		int cod = opcion.nextInt();
		// En esta parte creamos las sentencias para cada opcion establecida
		switch (cod) {
		case 1:
			vehiculos.insertarNuevoVehiculo();
			concesionario.menuPrincipal(vehiculos, concesionario);
			break;
		case 2:
			vehiculos.actualizarPotencia();
			concesionario.menuPrincipal(vehiculos, concesionario);
			break;
		case 3:
			vehiculos.borrarVehiculo();
			concesionario.menuPrincipal(vehiculos, concesionario);
			break;
		case 4:
			vehiculos.obtenerValoresMarca();
			concesionario.menuPrincipal(vehiculos, concesionario);
			break;
		case 5:
			vehiculos.obtenerValores();
			concesionario.menuPrincipal(vehiculos, concesionario);
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Opcion incorrecta, vuelva a probar");
			concesionario.menuPrincipal(vehiculos, concesionario);
				
		}
		
	}
}
