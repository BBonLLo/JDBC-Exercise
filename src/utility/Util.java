package utility;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

	public static String fechaToString(LocalDate fecha) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String wfecha;

		wfecha = fecha.format(formateador);

		return wfecha;
	}

	public static LocalDate leerFechaAMD(String message) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = null;
		String dateString;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			dateString = introducirCadena();
			try {
				date = LocalDate.parse(dateString, formateador);
			} catch (DateTimeException e) {
				System.out.print("Error, introduce fecha con formato aaaa/mm/dd: ");
				error = true;
			}
		} while (error);

		return date;
	}

	public static LocalDate leerFechaAMD() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = null;
		String dateString;
		boolean error;

		do {
			error = false;
			dateString = introducirCadena();
			try {
				date = LocalDate.parse(dateString, formateador);
			} catch (DateTimeException e) {
				System.out.print("Error, introduce fecha con formato aaaa/mm/dd: ");
				error = true;
			}
		} while (error);

		return date;
	}

	public static LocalDate leerFechaDMA(String message) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		String dateString;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			dateString = introducirCadena();
			try {
				date = LocalDate.parse(dateString, formateador);
			} catch (DateTimeException e) {
				System.out.print("Error, introduce fecha con formato dd/mm/aaaa: ");
				error = true;
			}
		} while (error);

		return date;
	}

	public static LocalDate leerFechaDMA() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		String dateString;
		boolean error;

		do {
			error = false;
			dateString = introducirCadena();
			try {
				date = LocalDate.parse(dateString, formateador);
			} catch (DateTimeException e) {
				System.out.print("Error, introduce fecha con formato dd/mm/aaaa: ");
				error = true;
			}
		} while (error);

		return date;
	}

	public static char leerChar(char opt1, char opt2) {
		char letra = ' ';
		String cadena;
		boolean error;

		do {
			error = false;
			cadena = introducirCadena();

			if (cadena.length() != 1) {
				System.out.print("Error, introduce un unico caracter: ");
				error = true;
			} else {
				letra = cadena.charAt(0);
				letra = Character.toUpperCase(letra);
				if (letra != opt1 && letra != opt2) {
					System.out.print(
							"Error, la opcion introducida no es correcta, introduce " + opt1 + " o " + opt2 + ": ");
					error = true;
				}
			}
		} while (error);

		return letra;
	}

	public static char leerChar(String message, char opt1, char opt2) {
		char letra = ' ';
		String cadena;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			cadena = introducirCadena();

			if (cadena.length() != 1) {
				System.out.print("Error, introduce un unico caracter: ");
				error = true;
			} else {
				letra = cadena.charAt(0);
				letra = Character.toUpperCase(letra);
				if (letra != opt1 && letra != opt2) {
					System.out.print(
							"Error, la opcion introducida no es correcta, introduce " + opt1 + " o " + opt2 + ": ");
					error = true;
				}
			}
		} while (error);

		return letra;
	}

	public static char leerChar(char opt1, char opt2, char opt3) {
		char letra = ' ';
		String cadena;
		boolean error;

		do {
			error = false;
			cadena = introducirCadena();

			if (cadena.length() != 1) {
				System.out.print("Error, introduce un unico caracter: ");
				error = true;
			} else {
				letra = cadena.charAt(0);
				letra = Character.toUpperCase(letra);
				if (letra != opt1 && letra != opt2 && letra != opt3) {
					System.out.print("Error, la opcion introducida no es correcta, introduce " + opt1 + " o " + opt2
							+ " o " + opt3 + ": ");
					error = true;
				}
			}
		} while (error);

		return letra;
	}

	public static char leerChar(String message, char opt1, char opt2, char opt3) {
		char letra = ' ';
		String cadena;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			cadena = introducirCadena();

			if (cadena.length() != 1) {
				System.out.print("Error, introduce un unico caracter: ");
				error = true;
			} else {
				letra = cadena.charAt(0);
				letra = Character.toUpperCase(letra);
				if (letra != opt1 && letra != opt2 && letra != opt3) {
					System.out.print("Error, la opcion introducida no es correcta, introduce " + opt1 + " o " + opt2
							+ " o " + opt3 + ": ");
					error = true;
				}
			}
		} while (error);

		return letra;
	}

	public static char leerChar() {
		char letra = ' ';
		String cadena;
		boolean error;

		do {
			error = false;
			cadena = introducirCadena();

			if (cadena.length() != 1) {
				System.out.print("Error, introduce un unico caracter: ");
				error = true;
			}
		} while (error);
		letra = cadena.charAt(0);
		return letra;
	}

	public static float leerFloat() {
		float num = 0;
		boolean error;

		do {
			error = false;
			try {
				num = Float.parseFloat(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
			}
		} while (error);

		return num;
	}
        	

	public static float leetFloat(String message, float min, float max) {
		float num = 0;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			try {
				num = Float.parseFloat(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static float leerFloat(float min, float max) {
		float num = 0;
		boolean error;

		do {
			error = false;
			try {
				num = Float.parseFloat(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static float leerFloat(String message) {
		float num = 0;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			try {
				num = Float.parseFloat(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
			}
		} while (error);

		return num;
	}
        public static Double leerDouble() {
                        Double num = 0.00;
                        boolean error;

                        do {
                                error = false;
                                try {
                                        num = Double.parseDouble(introducirCadena());
                                } catch (NumberFormatException e) {
                                        System.out.print("Valor no numerico. Introduce de nuevo: ");
                                        error = true;
                                }
                        } while (error);

                        return num;
                }
        public static Double leerDouble(String message) {
                        Double num = 0.00;
                        boolean error;
                        System.out.print(message);
                        do {
                                error = false;
                                try {
                                        num = Double.parseDouble(introducirCadena());
                                } catch (NumberFormatException e) {
                                        System.out.print("Valor no numerico. Introduce de nuevo: ");
                                        error = true;
                                }
                        } while (error);

                        return num;
                }
        public static Double leerDouble(Double min, Double max) {
                        Double num = 0.00;
                        boolean error;

                        do {
                                error = false;
                                try {
                                        num = Double.parseDouble(introducirCadena());
                                } catch (NumberFormatException e) {
                                        System.out.print("Valor no numerico. Introduce de nuevo: ");
                                        error = true;
                                        num = min;
                                }
                                if (num < min || num > max) {
                                        System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
                                        error = true;
                                }
                        } while (error);

                        return num;
                }
        public static Double leerDouble(String message, Double min, Double max) {
		Double num = 0.00;
		boolean error;
                System.out.print(message);
		do {
			error = false;
			try {
				num = Double.parseDouble(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static int leetInt(String message, int min, int max) {
		int num = 0;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static int leerInt(int min, int max) {
		int num = 0;
		boolean error;

		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static int leerInt(String message, int min, int max) {
		int num = 0;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if (num < min || num > max) {
				System.out.print("Numero fuera de rango, introduce un numero entre " + min + " y " + max + ": ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static int leerInt(String message) {
		int num = 0;
		boolean error;

		System.out.print(message);
		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static int leerInt() {
		int num = 0;
		boolean error;

		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena());
			} catch (NumberFormatException e) {
				System.out.print("Valor no numerico. Introduce de nuevo: ");
				error = true;
			}
		} while (error);

		return num;
	}

	public static String introducirCadena(String message) {
		String cadena = "";
		boolean error;

		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);

		System.out.print(message);
		do {
			error = false;
			try {
				cadena = teclado.readLine();
			} catch (IOException e) {
				System.out.println("Error en la entrada de datos");
				error = true;
			}
		} while (error);

		return cadena;
	}

	public static String introducirCadena() {
		String cadena = "";
		boolean error;

		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);

		do {
			error = false;
			try {
				cadena = teclado.readLine();
			} catch (IOException e) {
				System.out.println("Error en la entrada de datos");
				error = true;
			}
		} while (error);

		return cadena;
	}

	public static int calculoFichero(File fich) {
		int cont = 0;
		if (fich.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(fich);
				ois = new ObjectInputStream(fis);

				Object aux = ois.readObject();

				while (aux != null) {
					cont++;
					aux = ois.readObject();
				}

			} catch (EOFException e1) {

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los flujos");

			}
		}
		return cont;
	}

}
