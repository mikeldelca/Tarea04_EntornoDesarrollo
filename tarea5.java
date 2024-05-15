import java.util.Scanner;

public class tarea5 {

	public static void main(String[] args) {
		System.out.println("Matriculados en Programacion");
			Scanner programacion = new Scanner(System.in);
				int matProg = programacion.nextInt();
		System.out.println("Matriculados en Entornos de Desarrollo");
			Scanner entornoDesarrollo = new Scanner(System.in);
				int matDesarrollo = entornoDesarrollo.nextInt();
		System.out.println("Matriculados en Base de Datos");
			Scanner baseDatos = new Scanner(System.in);
				int matBasedatos = baseDatos.nextInt();
			float todosMatriculados = matProg+matDesarrollo+matBasedatos;
			
			
		System.out.println("Alumnos matriculados en programacion:"+String.format("%.2f",matProg*100/todosMatriculados )+"%");
		System.out.println("Alumnos matriculados en Entorno de Desarrollo:"+String.format("%.2f",matDesarrollo*100/todosMatriculados)+"%");
		System.out.println("Alumnos matriculados en Base de Datos:"+String.format("%.2f",matBasedatos*100/todosMatriculados)+"%");
		// TODO Auto-generated method stub

	}

}
