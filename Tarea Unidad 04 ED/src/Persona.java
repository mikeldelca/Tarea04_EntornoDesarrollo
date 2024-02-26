import java.util.Scanner;

/** Esta clase determinara los años que le quedan a una persona para jubilarse
 * @author Mikel
 * @version 1.0
 * 
 * 
 */
 
public class Persona {

	int edadActual;

/** Metodo get que devuelve el valor del atributo edadActua
 * 	
 * @return edad de la persona
 */
	public int getEdadActual() {
		return edadActual;
	}
/**Metodo set para modificar la variable edadActual
 * 
 * @param edadActual
 */
	public void setEdadActual(int edadActual) {
		this.edadActual = edadActual;
	}
/** Metodo por el cual se le pedira al usuario que ingrese una numero, 
 * ese numero sera asignado a la variable edadActual. Despues se le resta el valor de la variable a 67
 * y ese valor se mete en la variable diferenciaAnos.
 */
	public void CalcularAnosHastaJubilacion(){
		int diferenciaAnos;
		System.out.println("Intoduce tu edad actual en numero entero");
		Scanner numero =new Scanner(System.in);
		edadActual=numero.nextInt();
		diferenciaAnos=67 - edadActual;
		if (edadActual>67) 
			System.out.println("Tienes mas de 67 años, ya tendias que estar jubilado");	
		else if (diferenciaAnos<10) {
			System.out.println("Sólo te quedan "+diferenciaAnos+" años. ¡Vamos ya queda poco!");
		}
		else if(diferenciaAnos>20) {
			System.out.println("Te quedan "+diferenciaAnos+" años. ¡A seguir trabajando gandul!");
		}
	}
		
}
