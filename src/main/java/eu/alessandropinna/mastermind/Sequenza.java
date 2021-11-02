package eu.alessandropinna.mastermind;

import java.util.Random;

public class Sequenza {

	private String codice; // Sequenza da indovinare.

	private Sequenza(String codice) { /*
										 * Costruttore privato, viene chiamato solamente dal metodo che genera la
										 * sequenza.
										 */

		this.codice = codice;

	}

	public String getCodice() { // Restituisce la sequenza.

		return codice;
	}

	public static Sequenza generaSequenza(int n, boolean ripetizioni) { /*
																		 * Genera casualmente una sequenza con 'n'
																		 * cifre, che può ammettere ripetizioni o meno.
																		 */

		Random rand = new Random(); // Oggetto Random utilizzato per generare interi casuali.
		String s = ""; // Variabile nella quale viene generata la sequenza.
		int e; /*
				 * Variabile in cui vengono immagazzinati gli interi generati casualmente
				 * durante la costruzione della sequenza.
				 */

		for (int i = 0; i < n; i++) { // Cicla 'n' volte, in base al numero di cifre della sequenza da generare.

			do { /*
					 * Assegna ad 'e' un intero casuale tra 0 e 10 (compresi) e, se le ripetizioni
					 * di una stessa cifra non sono permesse ('ripetizioni' è false), esegue la
					 * stessa istruzione fin tanto che il valore di 'e' è già contenuto nella
					 * sequenza.
					 */
				e = rand.nextInt(10);
			} while (ripetizioni == false && s.contains("" + e));
			s += e; /*
					 * 'e' viene sommato alla stringa, aggiungendo una nuova cifra alla sequenza ad
					 * ogni ciclo del for.
					 */
		}

		return new Sequenza(s); /*
								 * Ritorna un nuovo oggetto di classe Sequenza, che prende la stringa della
								 * sequenza appena generata come parametro del costruttore.
								 */

	}

	public boolean verificaTentativo(String guess, int tentativi) {
		/*
		 * Verifica se la sequenza inserita dall'utente corrisponde a quella da
		 * indovinare e stampa un feedback a proposito del numero di cifre indovinate.
		 */

		int presenti = 0, individuati = 0; /*
											 * Alla variabile 'presenti' è assegnato il totale dei numeri indovinati,
											 * che si trovino nella posizione giusta o meno, mentre ad 'individuati'
											 * quello dei numeri individuati nella loro posizione corretta. Perciò il
											 * valore di presenti è sempre maggiore o uguale a quello di individuati.
											 */

		for (int i = 0; i < guess.length(); i++) { /*
													 * Effettua tanti cicli quanti i caratteri contenuti nella stringa
													 * 'guess' (la sequenza inserita dal giocatore).
													 */
			final char c = guess.charAt(i); /*
											 * Alla variabile final 'c' viene assegnato l'i-esimo carattere di 'guess'.
											 */
			if (codice.contains("" + c)) { // Se il carattere 'c' è contenuto nella stringa 'codice':

				individuati += c == codice.charAt(i) ? 1 : 0;
				/*
				 * E se l'i-esimo carattere di 'codice' equivale a 'c', 'individuati' è
				 * incrementato di 1, altrimenti di 0 (nessun incremento).
				 */

				presenti += guess.substring(0, i).chars().filter(n -> n == c).count() < codice.chars()
						.filter(n -> n == c).count() ? 1 : 0;
				/*
				 * E se 'c' ha un numero di occorrenze minore nella sottostringa dei caratteri
				 * di 'guess' precedenti a 'c' che nella stringa intera di 'codice', 'presenti
				 * viene incrementato di 1, altrimenti di 0 (nessun incremento).
				 */

			}
		}

		System.out.printf(Testi.getRisultato(), presenti, individuati);
		/*
		 * Visualizza un messaggio che indica i valori di 'presenti' e di 'individuati'
		 * per tale sequenza in ingresso.
		 */

		return individuati == guess.length(); /*
												 * Se tutti i numeri della sequenza sono stati individuati (ovvero se il
												 * giocatore ha vinto) viene restituito true, altrimenti false.
												 */
	}

}
