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

	/**
	 * Method that converts the first letter of a Suit to the Suit
	 * @param c char representing the first letter of a Suit
	 * @return Suit that the char was referring to
	 */
	private Suits toSuit(char c)
	{
		if (c == 's' || c == 'S') return Suits.spade;
		else if (c == 'h' || c == 'H') return Suits.heart;
		else if (c == 'd' || c == 'D') return Suits.diamond;
		else if (c == 'c' || c == 'C') return Suits.club;
		else System.out.print("That is not a suit");
	}

	/**
	 * Method that converts a Suit to a String
	 * @param s Suit to be converted
	 * @return String that represents a Suit
	 */
	private String suitToString(Suits s)
	{
		if (s == Suits.club) return "Clubs";
		else if (s == Suits.heart) return "Hearts";
		else if (s == Suits.diamond) return "Diamonds";
		else return "Spades";
	}

	/**
	 * Method that converts a rank to a String
	 * @param r int representing a rank to be converted
	 * @return String that represents a rank
	 */
	private String rankToString(int r)
	{
		if (r == 11) return "Jack";
		else if (r == 12) return "Queen";
		else if (r == 13) return "King";
		else if (r == 1) return "Ace";
		else return String.valueOf(r);
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
		
		s = s + rankToString(getRank()) + " of " + suitToString(getSuit());
		
		return s;
	}
}
