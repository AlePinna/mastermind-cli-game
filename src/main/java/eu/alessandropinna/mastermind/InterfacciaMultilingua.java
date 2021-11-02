package eu.alessandropinna.mastermind;

interface InterfacciaMultilingua {

	/*
	 * L'interfaccia contiene le costanti con i testi in italiano e in inglese. Ad
	 * eccezione di 'LANG' (String contenente il messaggio da visualizzare al
	 * momento della scelta della lingua), le altre costanti consistono in degli
	 * array di String dove l'indice corrisponde a una certa lingua (0 per
	 * l'italiano, 1 per l'inglese). Ciò permette di richiamare i testi della lingua
	 * selezionata settando una sola volta l'indice nella classe Testi che
	 * implementa l'interfaccia.
	 */

	String LANG = "\n	Seleziona la lingua - Select the language\n\n	Inserisci - Enter :"
			+ "\n	- ITA per giocare in italiano\n	- ENG to play in English";

	String[] INTRO = {

			"\n	Benvenuto a Mastermind \n\n	Sviluppato da Alessandro Pinna, matricola 955969\n",
			"\n	Welcome to Mastermind \n\n	Developed by Alessandro Pinna, student ID 955969\n" };

	String[] REGOLE = {

			"	Istruzioni:\n\n	Lo scopo del gioco è di indovinare una sequenza di numeri generata casualmente, con un numero limitato di tentativi a disposizione.\n"
					+ "	Dopo ogni tentativo il giocatore sarà informato del numero di cifre azzeccate, e tra di esse quante nella posizione esatta.\n"
					+ "	In qualsiasi momento sarà possibile terminare il programma digitando \"stop\".\n",
			"	How to play:\n\n	The game's goal is to guess a randomly generated sequence of numbers, with a limited amount of possible tries.\n"
					+ "	After each guess the player will be informed about the number of guessed digits, and how many of them are in the exact position.\n"
					+ "	At any time you'll be able to quit the game by entering \"stop\".\n" };

	String[] LIV_DIFF = {

			"	Seleziona il livello di difficoltà digitando il numero associato:"
					+ "\n	- 4 Normale (sequenza di 4 cifre, 12 tentativi)"
					+ "\n	- 6 Avanzato (sequenza di 6 cifre, 18 tentativi)"
					+ "\n	- 8 Difficile (sequenza di 8 cifre, 24 tentativi)",
			"	Select the difficulty level by entering the corresponding number:"
					+ "\n	- 4 Normal (sequence of 4 digits, 12 attempts)"
					+ "\n	- 6 Advanced (sequence of 6 digits, 18 attempts)"
					+ "\n	- 8 Difficult (sequence of 8 digits, 24 attempts)" };

	String[] INS_SEQU = {

			"\n	Inserisci una sequenza di %d cifre\n", "\n	Enter a sequence of %d digits\n"

	};

	String[] RIPETI = {

			"\n	Inserisci:\n	- 1 se vuoi consentire le ripetizioni di una stessa cifra all'interno della sequenza\n	- 0 in caso contrario\n",
			"\n	Enter:\n	- 1 to allow multiple occurrences of the same digit inside the sequence\n	- 0 if you'd rather not\n"

	};

	String[] TENTA = {

			"	Tentativo n.%d: %s\n", "	Attempt n.%d: %s\n" };

	String[] RISULTATO = {

			"	%d numeri indovinati, dei quali %d nella posizione corretta\n\n",
			"	%d guessed numbers, %d of which in the correct position\n\n" };

	String[] INPUT_NV = {

			"	Input non valido", "	Invalid input" };

	String[] VITTORIA = {

			"\n	Congratulazioni, hai vinto con %d tentativi!\n\n", "\n	Congrats, you won in %d attempts!\n\n" };

	String[] GAME_OVER = {

			"\n	Ops, hai perso. Ritenta!\n	La sequenza giusta era: %s\n",
			"\n	Oops, game over. Try again!\n	The correct sequence was: %s\n" };

	String[] REPLAY = {

			"\n	Inserisci:\n	- 1 per tornare al menù principale\n	- 0 per terminare il programma\n\n",
			"\n	Enter:\n	- 1 to go back to the main menu\n	- 0 to quit the program\n\n" };

	String[] FINE = {

			"\n	Grazie per aver giocato a Mastermind", "\n	Thanks for playing Mastermind" };

}