package sistemaPago;

import java.util.*;

/*
Crea un peque�o programa que sirva para validar el pago dentro de un restaurante. Un cliente puede pagar en efectivo o con tarjeta. 
El programa debe hacer los siguiente en cada caso:

Preguntar el tipo de pago.

Si se paga en efectivo, comprobar si la cantidad es exacta, en caso contrario devolver el m�nimo dinero posible.

ANOTACI�N

Si seleccionamos la forma de pago en efectivo, el programa nos pedir� que introduzcamos la cantidad que vamos a entregar para realizar el pago. 
El programa nos devolver� el dinero sobrante en billetes de 50�, 20�, 10� y 5�, y tambi�n devolver� monedas de euro y c�ntimos. Las cantidades 
devueltas ser� en base a la premisa de devolver la menor cantidad de billetes posibles, es decir, debe devolver siempre todos los billetes de 
mayor importe que se pueda.
Por ejemplo, vamos a suponer que tiene que cobrar 123'45 �, una posible devoluci�n podr�a ser 10 billetes de 10 euros, 1 billete de 20, 3 euros 
y 45 c�ntimos. Pero estar�a incorrecto, ya que estamos devolviendo muchos billetes. Lo correcto ser�a devolver 2 billetes de 50, un billete de 20,
y 3 euros y 45 c�ntimos.

Si se paga con tarjeta realizar las siguientes comprobaciones:

S�lo debe aceptar n�meros y espacios en blanco.
Acepta tarjetas VISA, MasterCard y American Express.
16 d�gitos Para VISA y Mastercard separados de 4 en 4 d�gitos.
Para American Express debe aceptar 15 d�gitos y estar separados por 4, 6 y 5 d�gitos.
ANOTACI�N

El primer d�gito indica el tipo de tarjeta:
- si es un 3 la tarjeta es American Express
- si es un 4 la tarjeta es Visa
- si es un 5 la tarjeta es MasterCard
*/




public class Principal {
	/* Variables */
	// Variable para el scanner
	static Scanner sc = new Scanner(System.in); // Variable para crear el escaner
	// Variable para la opci�n selecionada
	static String op;
	// Variable que almacena el importe a pagar y a devolver
	static double cuentaCliente,devolucion,efectivoCliente,cantidadADevolver;
	// Valores de los billetes disponible
	static int[] valoresBilletes = {50, 20, 10, 5, 1}; 
	
	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		System.out.println(""
				+ "__________ M�todo de pago __________"
				+ "\nSelecciona el m�todo de pago"
				+ "\n1. Efectivo"
				+ "\n2. Tarjeta"
				+ "\n0. Salir");
		op = sc.nextLine();
		
		if (op.equals("1") || op.equals("2") || op.equals("0")) {
			switch (op) {
			case "1":
				efectivo();
				menu();
				break;
			case "2":
				tarjeta();
				menu();
			case "0":
				System.out.println("Saliendo...");
				break;
			default:
				break;
			}
		} else {
			System.err.println("Error en la selecci�n");
			menu();
		}		
	}
		
		
		private static void efectivo() {

			while (true) {
				System.out.println("Efectivo");
	            System.out.print("Introduce la cantidad a pagar\nCantidad: ");
	            String inputPagar = sc.nextLine();
	            System.out.print("Ahora introduce el efectivo\nEfectivo: ");
	            String inputEfectivo = sc.nextLine();
	            try {
	                cuentaCliente = Double.parseDouble(inputPagar);
	                efectivoCliente = Double.parseDouble(inputEfectivo);
	                cantidadADevolver = efectivoCliente - cuentaCliente;
	                break;
	            } catch (NumberFormatException e) {
	                System.err.println("No es un n�mero v�lido. Int�ntalo de nuevo.");
	            }
	        }

			 double[] valores = {500,200,100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
			 	System.out.println("Devoluci�n: " + cantidadADevolver + "\n");
		        System.out.println("La devoluci�n con la cantidad m�nima de billetes y monedas es:\n");

		        for (double valor : valores) {
		            int cantidad = (int)(cantidadADevolver / valor);
		            if (cantidad > 0) {
		                System.out.println(cantidad + " " + (valor >= 1 ? "billetes" : "monedas") + " de " + valor + " euros");
		                cantidadADevolver -= cantidad * valor;
		            }  
		        }
			
		}

		private static void tarjeta() {
			System.out.println("Tarjeta");
//			menu();
		}

	
	

}
