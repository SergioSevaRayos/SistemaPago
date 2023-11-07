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
	// Variable que almacena el importe a pagar y a devolver
	static double cuentaCliente,devolucion,efectivoCliente,cantidadADevolver;
	// Valores de los billetes disponible
	static int[] valoresBilletes = {50, 20, 10, 5, 1}; 
	// Variable que almacena la cantidad a pagar por el cliente
	static String inputPagar;
	// Variable que almacena el número de tarjeta
	static String entradaTarj;
	// Variables para indicar el tipo de tarjeta
	static boolean americanExpress	= false;
	static boolean visa				= false;
	static boolean masterCard		= false;		
	// Variable para mostrar el tipo de tarjeta
	static String vis;
	
	public static void main(String[] args) {
		menu();
	}
	
	/* Métodos */
	private static void menu() {
		System.out.println(""
				+ "__________ Método de pago __________"
				+ "\nSelecciona el método de pago"
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
			System.err.println("Error en la selección");
			menu();
		}		
	}
		
		
		private static void efectivo() {

			while (true) {
				System.out.print("Efectivo\nIntroduce la cantidad a pagar\nCantidad: ");
	            inputPagar = sc.nextLine();
	            System.out.print("Ahora introduce el efectivo\nEfectivo: ");
	            String inputEfectivo = sc.nextLine();
	            try {
	                cuentaCliente = Double.parseDouble(inputPagar);
	                efectivoCliente = Double.parseDouble(inputEfectivo);
	                cantidadADevolver = efectivoCliente - cuentaCliente;
	                break;
	            } catch (NumberFormatException e) {
	                System.err.println("No es un número válido. Inténtalo de nuevo.");
	            }
	        }

			 double[] valores = {500,200,100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
			 	System.out.println("-----------------------------------------------------"
			 			+ "\nRESUMEN"
			 			+ "\nDevolución: " + cantidadADevolver + " €"
			 			+ "\nLa cantidad mínima de billetes y monedas es:");
		        for (double valor : valores) {
		            int cantidad = (int)(cantidadADevolver / valor);
		            if (cantidad > 0) {
		                System.out.println(cantidad + " " + (valor >= 1 ? "billetes" : "monedas") + " de " + valor + " euros");
		                cantidadADevolver -= cantidad * valor;
		            }
		        }
		        System.out.println("-----------------------------------------------------");
	            System.out.println("");
		}

		private static void tarjeta() {
			System.out.println("");
			System.out.println("Forma de pago mediante tarjeta seleccionado"
							 + "\nFormatos de numeración de las tarjetas\n"
							 + "0000 0000 0000 0000 --> Visa\n"
							 + "0000 0000 0000 0000 --> MasterCard\n"
							 + "0000 000000 00000   --> American Expres\n");

			System.out.print("Introduce el número de tarjeta \nNúmero: ");
			entradaTarj = sc.nextLine();

			int americanOk	= entradaTarj.indexOf("3");
			int visaOk		= entradaTarj.indexOf("4");
			int masterOk 	= entradaTarj.indexOf("5");
			
			String formatoVisMasOk 		= "\\d{4} \\d{4} \\d{4} \\d{4}";
			String formatoAmericanOk 	= "\\d{4} \\d{6} \\d{5}";


			if (americanOk == 0) {
				System.out.println("Tipo 	--> American Express\n"
						+ "Número 	--> " + entradaTarj);
				americanExpress = true;
				if (entradaTarj.matches(formatoVisMasOk)) {
					System.out.println("Formato adecuado");
					while (true) {
			            System.out.print("Introduce la cantidad a pagar\nCantidad: ");
			            inputPagar = sc.nextLine();
			            try {
			                cuentaCliente = Double.parseDouble(inputPagar);
			                break;
			            } catch (NumberFormatException e) {
			                System.err.println("No es un número válido. Inténtalo de nuevo.");
			            }
			        }
					resumen();
				}else {
					System.err.println("ERROR: Formato incorrecto");
				}

			}else if (visaOk == 0) {
				System.out.println("Tipo 	--> Visa\n"
						+ "Número 	--> " + entradaTarj);
				visa = true;
				if (entradaTarj.matches(formatoVisMasOk)) {
					System.out.println("Formato adecuado");
					while (true) {
			            System.out.print("Introduce la cantidad a pagar\nCantidad: ");
			            inputPagar = sc.nextLine();
			            try {
			                cuentaCliente = Double.parseDouble(inputPagar);
			                break;
			            } catch (NumberFormatException e) {
			                System.err.println("No es un número válido. Inténtalo de nuevo.");
			            }
			        }
					resumen();
				}else {
					System.err.println("ERROR: Formato incorrecto");
				}
			}else if (masterOk == 0) {
				System.out.println("Tipo 	--> Master Card\n"
						+ "Número 	--> " + entradaTarj);
				masterCard = true;
				if (entradaTarj.matches(formatoAmericanOk)) {
					System.out.println("Formato adecuado");
					while (true) {
			            System.out.print("Introduce la cantidad a pagar\nCantidad: ");
			            inputPagar = sc.nextLine();
			            try {
			                cuentaCliente = Double.parseDouble(inputPagar);
			                break;
			            } catch (NumberFormatException e) {
			                System.err.println("No es un número válido. Inténtalo de nuevo.");
			            }
			        }
					resumen();
				}else {
					System.err.println("ERROR: Formato incorrecto");
				}
			}


		}
		private static void resumen() {
			if (visa) {
				vis = "Visa";
			}else if (americanExpress) {
				vis = "American Express";
			}else if (masterCard) {
				vis = "MasterCard";
			}
			System.out.println("\n-------------------------------------------------\n"
					+ "Resumen de la operación\n"
					+ "Tipo --> " + vis + "\n"
					+ "Cantidad a abonar: "  + inputPagar + " €" + "\n"
					+ "Número de tarjeta: " + entradaTarj + "\n"
					+ "Estado --> PAGO REALIZADO\n"
					+ "-------------------------------------------------");
		}
}
