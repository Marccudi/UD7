import java.util.Hashtable;
import java.util.Scanner;

public class UD7Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		double totalBruto=0;

		int cantidadProductos=0;
		Hashtable<String, Integer> stock = new Hashtable<String, Integer>();
		
		//10 productos como ejemplo
		stock.put("Zanahoria", 53);
		stock.put("Remolacha", 26);
		stock.put("Alachofa", 32);
		stock.put("Apio", 48);
		stock.put("Patata", 55); 
		stock.put("Berenjena", 36);
		stock.put("Brocoli", 77);
		stock.put("Calabacín",58);
		stock.put("Cebolla", 49);
		stock.put("Coliflor", 50);
		
		boolean acabar=false;

		while (acabar==false) {
			System.out.println("MENU PRINCIPAL");
			System.out.println("(1)Stock (2)Venta (3)Salir de la aplicación");
			int val=scn.nextInt();
			switch (val) {
			case 1:
				System.out.println("MENU GESTION DE STOCK");
				System.out.println("(1)Buscar  (2)Añadir  (3)Modificar  (4)Listar (5)Menú principal");
				int elecc=scn.nextInt();
				
				
				while (elecc != 5) {
					switch (elecc) {
					case 0:
						System.out.println("MENU GESTION DE STOCK");
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
		
				break;
				
				
			case 2:
				System.out.println("MENÚ VENTA");
				System.out.println("(1)Añadir producto (2)Finalizar compra");
				elecc=scn.nextInt();
				while (elecc!=3) {
					
				
					switch (elecc) {
					case 0:
						System.out.println("MENÚ VENTA");
						System.out.println("(1)Añadir producto (2)Finalizar compra");
						elecc=scn.nextInt();
						
						break;
					case 1:
						System.out.println("Que articulo quieres comprar: ");
						String articulo=scn.next();
						
						if (stock.containsKey(articulo)) {
							System.out.println("Precio por unidad:");
							int precioU=scn.nextInt();
							System.out.println("Cantidad del producto:");
							int cant=scn.nextInt();
							int artStock=stock.get(articulo)-cant;
							stock.put(articulo, artStock);
							cantidadProductos+=cant;
							totalBruto+=cant*precioU;
							elecc=0;
							
						}else {
							System.out.println("Articulo no encontrado");
							elecc=0;
						}
						break;
					case 2:
						//Calculamos la compra
						System.out.println("Cantidad productos= "+cantidadProductos);
						System.out.println("IVA a aplicar (1)21% (2)4%");
						int elecIva=scn.nextInt();
						double iva=0;
						if (elecIva==1) {
							iva=0.24;
						} else {
							iva=0.04;
						}
						System.out.println("Precio bruto= "+totalBruto);
						
						double totalIva = totalBruto+(totalBruto*iva);
						System.out.println("Precio con iva= "+totalIva);
						System.out.println("Cantidad pagada por cliente:");
						double cliente=scn.nextDouble();
						double devolver=cliente-totalIva;
						System.out.println("Cantidad a devolver= "+devolver);
						
						elecc=3;
						
						break;
	
					default:
						break;
					}
				}

				
				break;
			case 3:
				//FINAL DEL PROGRAMA
				System.out.println("FINAL");
				acabar=true;
				break;

			default:
				System.out.println("Numero incorrecto");
				break;
			}
		}
		
		scn.close();
		
	}

}
