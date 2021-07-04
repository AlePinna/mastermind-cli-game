package mastermind;

import java.util.Scanner;

public class Partita {

	final int cifre; // Lunghezza della sequenza generata per tale partita.
	final boolean ripetizioni; // Flag che setta l'opzione che permette o proibisce le ripetizioni.
	private final int maxTentativi; // Numero massimo di tentativi a disposizione del giocatore.
	private int tentativi; // Contatore dei tentativi utilizzati dal giocatore.
	private Sequenza sequ; // Sequenza generata casualmente.

	public Partita(int n, boolean ripetizioni) {
		/*
		 * Il costruttore della classe Partita prende come parametri la lunghezza 'n'
		 * della sequenza da generare ed il flag 'rip' che consente o meno la
		 * ripetizione di cifre.
		 */
		this.ripetizioni = ripetizioni; /*
										 * Viene inizializzato il booleano final 'ripetizioni' in base all'omonimo
										 * parametro del costruttore.
										 */
		cifre = n; // Viene inizializzata la variabile final 'cifre' con valore 'n'.
		maxTentativi = n * 3; // Il numero massimo di tentativi è calcolato come triplo del numero di cifre.
		tentativi = 0; // I tentativi effettuati vengono inizializzati a 0.
		sequ = Sequenza.generaSequenza(n, ripetizioni); /*
														 * Viene chiamato il metodo statico 'generaSequenza', assegnando
														 * a 'sequ' la sequenza generata casualmente.
														 */
	}

	public void giocaTurno(Scanner read) { // All'interno del metodo 'giocaTurno' si svolgono i vari turni della
											// partita.

		String guess = inputTentativo(++tentativi, read);
		/*
		 * Assegna a 'guess' la sequenza inserita dall'utente tramite il metodo
		 * 'inputTentativo' e incrementa i tentativi effettuati di 1.
		 */
		boolean vittoria = sequ.verificaTentativo(guess, tentativi); /*
																		 * Verifica il tentativo del giocatore e ne
																		 * assegna l'esito al booleano 'vittoria'.
																		 */
		if (vittoria) { // Se 'vittoria' è true:
			System.out.printf(Testi.getVittoria(), tentativi); /*
																 * Visualizza un messaggio che congratula il giocatore e
																 * lo informa sul numero di tentativi usati per vincere.
																 */
		} else if (tentativi == maxTentativi) { // Se invece il giocatore non ha vinto e ha finito i tentativi:
			System.out.printf(Testi.getGameOver(), sequ.getCodice());
			/* Viene visualizzato il messaggio di game over, con il codice corretto. */
		} else
			giocaTurno(read); /*
								 * Se entrambe le condizioni precedenti sono false, viene chiamato
								 * ricorsivamente il metodo 'giocaTurno' in modo che l'utente possa giocare un
								 * altro turno.
								 */
	}

	public String inputTentativo(int tentativi, Scanner read) { /*
																 * Prende in input la sequenza inserita dall'utente e
																 * restituisce la stringa validata.
																 */

		String input; // Variabile dove viene generato l'input.
		int i; // Indice/contatore dei caratteri.
		boolean valido = false; // Flag di validazione dell'input.

		do {
			System.out.printf(Testi.getInsSequ(), cifre); /*
															 * Visualizza il messaggio che invita l'utente ad inserire
															 * una sequenza di numeri.
															 */

			input = read.nextLine().replaceAll(" ", ""); // Rimuove tutti gli spazi dalla stringa in input.

			if (input.equalsIgnoreCase("STOP")) { // Se l'input equivale a "STOP" (case insensitive):
				MastermindMain.termina(read); // Chiama il metodo che termina il gioco.
			}

			else if (input.length() != cifre) // Se il numero di caratteri è diverso dal numero di cifre previste:
				valido = false; // Il flag di validità dell'input viene assume il valore false.

			else { // Altrimenti:
				for (i = 0; i < input.length(); i++) { // Cicla su ogni carattere della stringa in input.
					final char c = input.charAt(i); /*
													 * Alla variabile 'c' viene assegnato l'i-esimo carattere di 'guess'
													 * ('c' è dichiarata final in modo da essere successivamente
													 * utilizzata all'interno della funzione lambda).
													 */
					if (c < '0' || c > '9'
							|| (ripetizioni == false && input.chars().filter(num -> num == c).count() > 1))
						/*
						 * Se il carattere 'c' non corrisponde a un numero tra 0 e 9 (compresi), o se le
						 * ripetizioni sono proibite e 'c' compare più di una volta nella sequenza:
						 */
						break; // Esce dal ciclo for.
				}
				valido = (i == input.length()); /*
												 * Se il contatore 'i' equivale al numero di caratteri nella sequenza,
												 * allora il ciclo precedente è terminato senza break e la sequenza in
												 * ingresso è considerata valida ('valido' diventa true).
												 */
			}

			if (!valido) // Se 'valido' è false:
				System.out.println(Testi.getInputNV()); // Visualizza il messaggio di input non valido.

		} while (!valido); /*
							 * La richiesta di input e la validazione si ripete fin a quando non viene
							 * inserita una sequenza valida.
							 */

		System.out.printf(Testi.getTenta(), tentativi, input); /*
																 * Il messaggio visualizza la stringa convalidata e il
																 * numero di tentativi già effettuati.
																 */

		return input; // Restituisce la sequenza validata.
	}

}
