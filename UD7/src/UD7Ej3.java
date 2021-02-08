import java.util.Hashtable;
import java.util.Scanner;

public class UD7Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);	
		Hashtable<String, Integer> stock = new Hashtable<String, Integer>();
		
		//10 productos como ejemplo
		stock.put("Zanahoria", 1);
		stock.put("Remolacha", 2);
		stock.put("Alachofa", 3);
		stock.put("Apio", 4);
		stock.put("Patata", 5);
		stock.put("Berenjena", 6);
		stock.put("Brocoli", 7);
		stock.put("Calabacín", 8);
		stock.put("Cebolla", 9);
		stock.put("Coliflor", 10);

		System.out.println("Introduce la acción que quieras realizar:");
		System.out.println("(1)Buscar  (2)Añadir  (3)Modificar  (4)Listar (5)Salir");
		int elecc=scn.nextInt();
		
		while (elecc != 5) {
			switch (elecc) {
			case 0://menu
				System.out.println("Introduce la acción que quieras realizar:");
				System.out.println("(1)Buscar  (2)Añadir  (3)Modificar  (4)Listar (5)Salir");
				elecc=scn.nextInt();
				break;
			case 1://Buscar
				System.out.println("Nombre del articulo: ");
				String nom=scn.next();
				if (stock.containsKey(nom)) {
					System.out.println("Producto: "+nom+" Cantidad:"+stock.get(nom));
				}else {
					System.out.println("Articulo no encontrado");
				}
				elecc=0;
				break;
			case 2://Añadir
				System.out.println("Nombre del articulo a añadir: ");
				nom=scn.next();
				System.out.println("Cantidad: ");
				int cant =scn.nextInt();
				if (stock.containsKey(nom)) {
					System.out.println("Producto ya existe, sobreescribir? (1)si (2)no");
					int sobrees=scn.nextInt();
					if (sobrees==1) {
						stock.put(nom, cant);
						System.out.println("Producto sobreescrito");
					}else if (sobrees==2) {
						System.out.println("Volviendo al menú...");
					}
				}else {
					System.out.println("Articulo no encontrado");
				}
				elecc=0;
				break;
			case 3://Modificar
				System.out.println("Nombre del articulo: ");
				nom=scn.next();
				
				if (stock.containsKey(nom)) {
					System.out.println("Articulo " + nom + " encontrado");
					System.out.println("Cantidad actual: "+stock.get(nom));
					
					System.out.println("Nueva cantidad: ");
					cant =scn.nextInt();
					
					stock.put(nom, cant);
					System.out.println("Articulo sobreescrito");

				}else {
					System.out.println("Articulo no encontrado");
				}
				elecc=0;
				break;
			case 4://Listar
				stock.forEach((k, v) -> System.out.println(k + ": " + v)); 

				elecc=0;
				break;
			default:
				System.out.println("Numero incorrecto.");
				elecc=0;
				break;
			}
		}
		if (elecc==5) {
			System.out.println("FIN.");
		}
		scn.close();
	}
 
}
