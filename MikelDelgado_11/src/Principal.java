
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	VehiculosDAO prueba = new VehiculosDAO();
	MenuConcesionario concesionario = new MenuConcesionario();
	concesionario.menuPrincipal(prueba, concesionario);
	
	//prueba.obtenerValores();
	//prueba.insertarNuevoVehiculo();
	//prueba.actualizarPotencia();
	//prueba.borrarVehiculo();
	//prueba.obtenerValoresMarca();
	}

}
