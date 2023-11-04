package sistemaPago;

import java.util.*;

/*
Crea un pequeño programa que sirva para validar el pago dentro de un restaurante. Un cliente puede pagar en efectivo o con tarjeta. 
El programa debe hacer los siguiente en cada caso:

Preguntar el tipo de pago.

Si se paga en efectivo, comprobar si la cantidad es exacta, en caso contrario devolver el mínimo dinero posible.

ANOTACIÓN

Si seleccionamos la forma de pago en efectivo, el programa nos pedirá que introduzcamos la cantidad que vamos a entregar para realizar el pago. 
El programa nos devolverá el dinero sobrante en billetes de 50€, 20€, 10€ y 5€, y también devolverá monedas de euro y céntimos. Las cantidades 
devueltas será en base a la premisa de devolver la menor cantidad de billetes posibles, es decir, debe devolver siempre todos los billetes de 
mayor importe que se pueda.
Por ejemplo, vamos a suponer que tiene que cobrar 123'45 €, una posible devolución podría ser 10 billetes de 10 euros, 1 billete de 20, 3 euros 
y 45 céntimos. Pero estaría incorrecto, ya que estamos devolviendo muchos billetes. Lo correcto sería devolver 2 billetes de 50, un billete de 20,
y 3 euros y 45 céntimos.

Si se paga con tarjeta realizar las siguientes comprobaciones:

Sólo debe aceptar números y espacios en blanco.
Acepta tarjetas VISA, MasterCard y American Express.
16 dígitos Para VISA y Mastercard separados de 4 en 4 dígitos.
Para American Express debe aceptar 15 dígitos y estar separados por 4, 6 y 5 dígitos.
ANOTACIÓN

El primer dígito indica el tipo de tarjeta:
- si es un 3 la tarjeta es American Express
- si es un 4 la tarjeta es Visa
- si es un 5 la tarjeta es MasterCard
*/




public class Principal {
	/* Variables */
	// Variable para el scanner
	static Scanner sc = new Scanner(System.in); // Variable para crear el escaner
	// Variable para la opción selecionada
	static String op;
	
	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		System.out.println(""
				+ "__________ Método de pago __________"
				+ "\nSelecciona el método de pago"
				+ "\n1. Efectivo"
				+ "\n2. Tarjeta"
				+ "\n0. Salir");
		op = sc.nextLine();
		
		if (op.equals("1") || op.equals("2")) {
			switch (op) {
			case "1":
				efectivo();
				break;
			case "2":
				tarjeta();
			case "0":
				System.out.println("Saliendo........");
				break;
			default:
				break;
			}
		} else {
			System.err.println("Error en la selección");
			menu();
		}
				
		
	}
		
		
		private static void efectivo() {
			System.out.println("Efectivo");
			menu();
		}
		private static void tarjeta() {
			System.out.println("Tarjeta");
			menu();
		}

	
	

}
