package gofish_assn;

public class Card {
	
	public enum Suits {club, diamond, heart, spade};						//defines the 4 different suits
	
	static int TOP_RANK = 13; //King										//sets boundaries for rank
	static int LOW_RANK = 1; //Ace
	
	int rank;  //1 is an Ace												//Instance variables
	Suits suit;

	/**
	 * Class constructor
	 */
	public Card() {
		rank = 1;
		suit = Suits.spade;
	}

	/**
	 * Class constructor specifying rank and ??????
	 * @param r an int specifying the rank of the card
	 * @param s ??????
	 */
	
	public Card(int r, char s) {

	}

	/**
	 * Class constructor specifying rank and suit
	 * @param r an int specifying the rank of the card
	 * @param s a Suit specifying the Suit of the card
	 */
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}
	
	private Suits toSuit(char c) {
		return Suits.spade; //dummy
	}
	
	private String suitToString(Suits s)
	{
		return "s"; //dummy
	}
	
	private String rankToString(int r)
	{
		return "A"; //dummy
	}

	/**
	 * Get method for the card's rank
	 * @return the rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Get method for the card's Suit
	 * @return the Suit of the card
	 */
	public Suits getSuit() {
		return suit;
	}

	/**
	 * Method which returns a String specifying the rank and Suit of a card
	 * @return String containing rank and Suit
	 */
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank()) + suitToString(getSuit());
		
		return s;
	}
}
