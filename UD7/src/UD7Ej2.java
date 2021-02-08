import java.util.ArrayList;
import java.util.Scanner;

public class UD7Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Cuantos productos quieres introducir?");
		int cant= scn.nextInt();

		ArrayList<Double> lista =new ArrayList<>();

		//rellenamos la lista con el valor de los productos
		for (int i = 0; i < cant; i++) {
			System.out.println("Cuanto vale el producto en la posición "+i);
			double precio=scn.nextDouble();
			lista.add(precio);	
		}
		
		//tipo de iva
		System.out.println("Tipo de iva (1)21% o (2)4%");
		int ivaType=scn.nextInt();
		//iva es una llave para que una vez cambiada ya tenga el valor que queremos
		double iva=3.0;
		while (iva == 3.0) {
			switch (ivaType) {
			case 1:
				iva=0.21;
				break;		
			case 2:
				iva=0.04;	
			break;

			default:
				System.out.println("Numero incorrecto, vuelve a ingresar el iva");
				break;
			}
		}
		
		//precio bruto y precio IVA
		double precioBruto=0;
		for (Double a : lista) {
			precioBruto += a;
		}
		double precioIva=precioBruto+(precioBruto*iva);
		
		
		//resultado
		System.out.println("Numero de productos: "+lista.size());	
		System.out.println("IVA del "+iva*100 + "%");
		System.out.println("Precio total (bruto) = "+ precioBruto + " €");
		System.out.println("Precio + IVA= " + precioIva + " €");
		System.out.println("Cantidad pagada: ");
		double venta=scn.nextDouble();
		double cambio=venta - (precioBruto+(precioBruto*iva));
		System.out.println("Cambio a devlover = "+ cambio + " €");
		
		

		scn.close();
		

		
		
	}

}
