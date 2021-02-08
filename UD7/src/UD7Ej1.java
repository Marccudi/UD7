import java.util.Hashtable;
import java.util.Scanner;

public class UD7Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);	
		Hashtable<String, Integer> notaMedia=new Hashtable<String, Integer>();
		
		notaMedia.put("Alejandro", 5);
		notaMedia.put("Bonifacio", 9);
		notaMedia.put("Oriol",2);
		notaMedia.put("Aurora", 7);


		
		System.out.println("1-Nuevo alumno");
		System.out.println("2-Cambiar nota media");
		System.out.println("3-Mostrar notas");
		System.out.println("4-Salir");
		int elej=scn.nextInt();
		//menú
		while (elej!=4) {

			
			
			switch (elej) {
			case 0:
				System.out.println("1-Nuevo alumno");
				System.out.println("2-Cambiar nota media");
				System.out.println("3-Mostrar notas");
				System.out.println("4-Salir");
				int eleccion=scn.nextInt();
				elej=eleccion;
				break;
			case 1:
				System.out.println("Escribe el nombre del nuevo alumno");
				String newName=scn.next();
				if (!notaMedia.containsKey(newName)) {
					System.out.println("Escribe el La nota media del nuevo alumno");
					int newNot=scn.nextInt();
					
					notaMedia.put(newName, newNot);

				}else {
					System.out.println("El alumno ya existe");
				}
				elej=0;
				break;
				
			case 2:
				System.out.println("Escribe el nombre del alumno");
				String nom=scn.next();
				if (notaMedia.containsKey(nom)) {
					System.out.println("La nota media actual de "+nom+" es: "+notaMedia.get(nom));
					System.out.println("Escribe la nueva nota media del alumno");
					int med=scn.nextInt();
					notaMedia.put(nom, med);
					System.out.println("Nota cambiada");
				}else {
					System.out.println("Alumno no encontrado");
				}
				elej=0;

				break;
			case 3:
				
				notaMedia.forEach((k, v) -> System.out.println(k + " --> " + v)); 
				elej=0;

				break;
			case 4:
				
				System.out.println("Gracias por tu cooperación");
				
				break;

			default:
				System.out.println("Numero equivocado, vuelve a intentarlo");
				elej=0;
				break;
			}			
		}

		scn.close();
	}

}
