package mastermind;

import java.util.Scanner;

public class MastermindMain {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in); /*
												 * Viene istanziato un solo oggetto Scanner per l'intero programma e
												 * viene passato come parametro ai metodi chiamati successivamente.
												 */
		Menu.principale(read); /*
								 * Chiama il metodo statico principale() della classe Menu, per portare l'utente
								 * al menù principale del gioco.
								 */
		termina(read); /*
						 * Quando l'utente decide di terminare il programma viene chiamato il metodo
						 * 'termina'.
						 */

	}

	public static void termina(Scanner read) { /*
												 * Il metodo per terminare il gioco può essere chiamato in varie fasi
												 * del programma.
												 */

		System.out.println(Testi.getFine()); // Stampa un messaggio che ringrazia il giocatore per aver giocato.
		read.nextLine(); // Attende un input qualsiasi prima di terminare il programma.
		read.close(); // Chiude lo Scanner inizializzato nel metodo 'main'.
		System.exit(0); // Termina il programma.
	}

}
