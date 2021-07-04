package mastermind;

public class Testi implements InterfacciaMultilingua {

	private Testi() {}
	
	private static int lingua = -1; /*
									 * Variabile utilizzata per salvare l'indice della lingua di cui richiamare i
									 * testi. E' inizializzata di default al valore -1, che non corrisponde ad
									 * alcuna lingua.
									 */

	public static void setLingua(int l) { /*
											 * Il metodo 'setLingua' permette di settare il valore di 'lingua' in base
											 * alla scelta dell'utente. Questo metodo viene chiamato solamente quando
											 * 'lingua' equivale a -1, ovvero nella prima partita effettuata a partire
											 * dall'avvio del programma.
											 */

		lingua = l;
	}

	/*
	 * I seguenti metodi 'get...' richiamano i testi dagli array di String di
	 * InterfacciaMultilingua in base all'indice salvato nella variabile 'lingua'.
	 */

	public static int getLingua() {

		return lingua;
	}

	public static String getIntro() {

		return INTRO[lingua];
	}

	public static String getRegole() {

		return REGOLE[lingua];
	}

	public static String getLivDiff() {

		return LIV_DIFF[lingua];
	}
	
	public static String getRipeti() {

		return RIPETI[lingua];
	}

	public static String getInsSequ() {

		return INS_SEQU[lingua];
	}

	public static String getTenta() {

		return TENTA[lingua];
	}

	public static String getRisultato() {

		return RISULTATO[lingua];
	}

	public static String getInputNV() {

		return INPUT_NV[lingua];
	}

	public static String getVittoria() {

		return VITTORIA[lingua];
	}

	public static String getGameOver() {

		return GAME_OVER[lingua];
	}

	public static String getReplay() {

		return REPLAY[lingua];
	}

	public static String getFine() {

		return FINE[lingua];
	}

}
