package main.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Prompt {
	
	// Método para imprimir uma mensagem no console
		public static void print(String message) {
			System.out.println(message); // imprime a mensagem no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Sobrecarga do método imprimir para receber um objeto e imprimir sua representação String
		public static void print(Object object) {
			System.out.println(object); // imprime a representação String do objeto no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Método para imprimir um separador no console
		public static void separator() {
			print("---------------------------------------------------"); // imprime o separador no console
		}

		// Método para imprimir uma linha em branco no console
		public static void blankLine() {
			System.out.println(); // imprime uma linha em branco no console
			System.out.flush(); // limpa o buffer de saída
		}

		// Método para ler uma linha de texto do console, exibindo uma mensagem opcional
		public static String lineReader(String message) {
			print(message); // imprime a mensagem no console
			return lineReader(); // chama o método lerLinha() sem mensagem para ler a linha de texto do console
		}

		// Método para ler uma linha de texto do console
		public static String lineReader() {
			while (true) { // laço infinito
				try {
					InputStreamReader isr = new InputStreamReader(System.in); // cria um InputStreamReader para ler do console
					BufferedReader br = new BufferedReader(isr); // cria um BufferedReader para ler do InputStreamReader
					return br.readLine(); // lê uma linha de texto do BufferedReader e retorna como String
				} catch (IOException e) {
					System.out.println("Texto inválido, digite novamente..."); // imprime mensagem de erro no console
				}
			}
		}

		// Método para ler um número inteiro do console, exibindo uma mensagem opcional
		public static int intReader(String message) {
			print(message); // imprime a mensagem no console
			return intReader(); // chama o método lerInteiro() sem mensagem para ler o número inteiro do console
		}

		// Método para ler um número inteiro do console
		public static int intReader() {
			while (true) { // laço infinito
				try {
					String line = lineReader(); // lê uma linha de texto do console
					if (line.isEmpty()) { // se a linha for vazia
						return 0; // retorna zero
					}
					return Integer.parseInt(line); // converte a linha em um número inteiro e retorna
				} catch (NumberFormatException tExcept) {
					System.out.println("Inteiro inválido, digite novamente..."); // imprime mensagem de erro no console
				}
			}
		}
		/**
	 * Lê um número decimal digitado pelo usuário a partir da entrada padrão.
	 * Se o usuário digitar um valor inválido, exibe uma mensagem de erro e solicita
	 * que o usuário tente novamente.
	 * @param message a mensagem a ser exibida antes da entrada do usuário
	 * @return o número decimal digitado pelo usuário
	 */
	public static double decimalReader(String message) {
		// exibe a mensagem fornecida antes da entrada do usuário
		print(message);
		// lê a entrada do usuário e retorna o número decimal correspondente
		return decimalReader();
	}

	/**
	 * Lê um número decimal digitado pelo usuário a partir da entrada padrão.
	 * Se o usuário digitar um valor inválido, exibe uma mensagem de erro e solicita
	 * que o usuário tente novamente.
	 * @return o número decimal digitado pelo usuário
	 */
	public static double decimalReader() {
		while (true) {
			try {
				// lê uma linha de texto da entrada padrão
				String line = lineReader();
				// se a linha estiver vazia, retorna 0
				if (line.isEmpty()) {
					return 0;
				}
				// converte a linha em um número decimal e retorna o valor correspondente
				return Double.parseDouble(line);
			} catch (NumberFormatException e) {
				// exibe uma mensagem de erro e solicita que o usuário tente novamente
				print("Decimal inválido, digite novamente...");
			}
		}
	}

	//ler uma data digitada pelo usuário
	public static LocalDate dateReader(String message) {
		LocalDate date = null;
		while (date == null) {
			try {
				Prompt.print(message);
				String input = lineReader();
				date = LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida. Digite novamente.");
			}
		}
		return date;
	}

	//ler a hora digitada pelo usuário 
	public static LocalTime hourReader(String message) {
		System.out.println(message);
		while (true) {
			try {
				String hourStr = lineReader();
				// Formato de hora esperado
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				return LocalTime.parse(hourStr, formatter);
			} catch (Exception e) {
				System.out.println("Hora inválida, digite novamente...");
			}
		}
	}

	/**
	 * Exibe uma mensagem pedindo que o usuário pressione a tecla ENTER para continuar.
	 * Aguarda até que o usuário pressione a tecla ENTER antes de retornar.
	 */
	public static void pressEnter() {
		// exibe a mensagem pedindo que o usuário pressione ENTER
		System.out.print("Pressione ENTER para continuar...");
		// aguarda até que o usuário pressione ENTER
		lineReader();
	}

}
