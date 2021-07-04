package mastermind;

import java.util.Scanner;

public class Menu {

	public static void principale(Scanner read) { // Menù principale.

		boolean rigiocare = true; /*
									 * Flag che regola il ciclo while stabilendo se alla fine di una partita ne deve
									 * cominciare un'altra.
									 */
		boolean ripetizioni = false; /*
										 * Flag che stabilisce se consentire le ripetizioni di uno stesso numero
										 * all'interno della sequenza.
										 */
		int n; // Numero di cifre della sequenza da indovinare.

		sceltaSelezionaLingua(read); // Richiama il metodo per selezionare la lingua dei testi (italiano o inglese).

		while (rigiocare) {

			System.out.println(Testi.getIntro()); // Visualizza il messaggio introduttivo.
			System.out.println(Testi.getRegole()); // Visualizza le regole del gioco.
			n = selezionaLunghezza(read); // Seleziona il livello di difficoltà settando 'n'.
			ripetizioni = sceltaRipetizioni(read); // Setta l'opzione che permette o blocca le ripetizioni.
			new Partita(n, ripetizioni).giocaTurno(read);
			// Crea un oggetto Partita e avvia il gioco chiamando il metodo 'giocaTurno'.
			rigiocare = sceltaFinePartita(read); /*
													 * Permette al giocatore di scegliere se iniziare una nuova partita
													 * o terminare il gioco.
													 */
		}

	}

	public static int selezionaLunghezza(Scanner read) { /*
															 * Menù di selezione della difficoltà (scelta della
															 * lunghezza della sequenza e del numero di tentativi).
															 */

		boolean valido = false; // Flag di validità dell'input.
		String input; // Variabile dove viene salvato l'input.
		int n = 0; // Variabile in cui viene salvato il numero di cifre della sequenza.

		System.out.println(Testi.getLivDiff()); // Visualizza il messaggio di scelta della difficoltà.

		do {
			switch (input = read.nextLine().trim().toUpperCase()) {
			/*
			 * Prende l'input, ne rimuove gli spazi vuoti ai margini, rende i caratteri
			 * maiuscoli e passa la stringa modificata al parametro dello switch.
			 */
			case "4":
			case "6":
			case "8":
				n = Integer.parseInt(input); /*
												 * Nel caso in cui venga inserito un numero valido (4, 6 o 8) ne fa il
												 * parsing a int e lo assegna ad 'n'.
												 */
				valido = true; // Valida l'input per uscire dal while.
				break; // Esce dal blocco switch.
			case "STOP":
				MastermindMain.termina(read); /*
												 * Se l'utente digita "STOP" (case insensitive) viene chiamato il metodo
												 * per terminare il programma.
												 */
			default:
				System.out.println(Testi.getInputNV()); /*
														 * Se viene inserito un input non valido, visualizza un
														 * messaggio che avverte il giocatore di ciò.
														 */

			}
		} while (!valido); // Il ciclo viene ripetuto fin tanto che non viene inserito un input valido.

		return n; // Restituisce il numero di cifre che avrà la sequenza.
	}

	public static void sceltaSelezionaLingua(
			Scanner read) { /*
							 * Menù di selezione della lingua dei testi (italiano o inglese).
							 */

		boolean valido = false; // Flag di validità dell'input.
		String input; // Variabile dove viene salvato l'input.
		int l = -1; // Variabile in cui viene salvata la lingua selezionata.
		System.out.println(Testi.LANG); // Visualizza il messaggio di scelta della lingua.

		do {

			switch (input = read.nextLine().trim().toUpperCase()) {
			/*
			 * Prende l'input, ne rimuove gli spazi vuoti ai margini, rende i caratteri
			 * maiuscoli e passa la stringa modificata al parametro dello switch.
			 */
			case "ITA":
				l = 0; /*
						 * Se viene selezionata la lingua italiana (ITA), la variabile 'l' assume il
						 * valore 0.
						 */
				valido = true; // Valida l'input per uscire dal while.
				break; // Esce dal blocco switch.
			case "ENG":
				l = 1; /*
						 * Se viene selezionata la lingua inglese (ENG), la variabile 'l' assume il
						 * valore 1.
						 */
				valido = true; // Valida l'input per uscire dal while.
				break; // Esce dal blocco switch.
			default:
				System.out.println("\n	Input non valido - Invalid input");
				/*
				 * Se viene inserito un input non valido, visualizza un messaggio che avverte il
				 * giocatore di ciò.
				 */

			}
		} while (!valido); // Il ciclo viene ripetuto fin tanto che non viene inserito un input valido.

		Testi.setLingua(l); /*
							 * Viene settato 'l' come valore dell' attributo statico 'lingua' della classe
							 * Testi tramite il metodo 'setLingua'.
							 */

	}

	public static boolean sceltaFinePartita(Scanner read) { // Menù di scelta di fine partita.

		boolean valido = false; // Flag di validità dell'input.
		String input; // Variabile dove viene salvato l'input.

		System.out.println(Testi.getReplay()); /*
												 * Visualizza il messaggio di fine partita, che chiede al giocatore di
												 * scegliere se iniziare un'altra partita o terminare il gioco.
												 */

		do {

			switch (input = read.nextLine().trim().toUpperCase()) {
			/*
			 * Prende l'input, ne rimuove gli spazi vuoti ai margini, rende i caratteri
			 * maiuscoli e passa la stringa modificata al parametro dello switch.
			 */
			case "1":
			case "0":
			case "STOP":
				valido = true; // Se l'input equivale a "1", "0" o "STOP" (case insensitive) viene validato.
				break; // Esce dal blocco switch.
			default:
				System.out.println(Testi.getInputNV()); /*
														 * Se viene inserito un input non valido, visualizza un
														 * messaggio che avverte il giocatore di ciò.
														 */

			}
		} while (!valido); // Il ciclo viene ripetuto fin tanto che non viene inserito un input valido.

		return input.equals("1"); /*
									 * Ritorna true se il giocatore digita "1" (nuova partita) oppure false se
									 * inserisce "0" o "STOP" (fine del gioco).
									 */
	}

	public static boolean sceltaRipetizioni(Scanner read) { // Menù di scelta dell'opzione ripetizioni.

		boolean valido = false; // Flag di validità dell'input.
		String input; // Variabile dove viene salvato l'input.

		System.out.println(Testi.getRipeti());
		/*
		 * Visualizza il messaggio che chiede al giocatore se preferisce permettere
		 * ripetizioni di una stessa cifra all'interno della sequenza o meno.
		 */

		do {

			switch (input = read.nextLine().trim().toUpperCase()) {
			/*
			 * Prende l'input, ne rimuove gli spazi vuoti ai margini, rende i caratteri
			 * maiuscoli e passa la stringa modificata al parametro dello switch.
			 */
			case "STOP":
				MastermindMain.termina(read); /*
												 * Se l'utente digita "STOP" (case insensitive) viene chiamato il metodo
												 * per terminare il programma.
												 */
			case "1":
			case "0":
				valido = true; // Se l'input equivale a "1"o "0" viene validato.
				break; // Esce dal blocco switch.
			default:
				System.out.println(Testi.getInputNV()); /*
														 * Se viene inserito un input non valido, visualizza un
														 * messaggio che avverte il giocatore di ciò.
														 */

			}
		} while (!valido); // Il ciclo viene ripetuto fin tanto che non viene inserito un input valido.

		return input.equals("1"); /*
									 * Ritorna true se il giocatore digita "1" (ripetizioni consentite) oppure false
									 * se inserisce "0" (ripetizioni non ammesse).
									 */
	}

}
