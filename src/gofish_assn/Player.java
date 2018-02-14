package gofish_assn;

import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>();				//ArrayList containing Player's cards
	ArrayList<Card> book = new ArrayList<Card>();				//ArrayList containing the Player's pairs
    ArrayList<Card> fishHelper = new ArrayList<Card>();		//ArrayList to help pick card, [0]: Last Card Player
															// asked for and did not get, [1-3]: Last cards opponent
                                                                //asked for and did not get
	String name;												//Player's name

	/**
	 * Class constructor specifying Player name
	 * @param name String containing Player name
	 */
	public Player(String name) {
		this.name = name;
		for (int i=0; i<4; i++){
		    Card placeHolder = new Card();
		    placeHolder.rank = 0;
		    placeHolder.suit = Card.Suits.diamond;
		    fishHelper.add(placeHolder);
        }
	}

	/**
	 * Method that adds a Card to the Player's hand
	 * @param c Card to be added to hand
	 */
	public void addCardToHand(Card c) {
		hand.add(c);
	}

	/**
	 * Method to remove a Card from the Player's hand
	 * @param c Card to be removed
	 * @return Card which was removed from hand
	 */
	public Card removeCardFromHand(Card c) {
		Card retCard = new Card();								//Card to be returned
        hand.remove(c);
		retCard.rank = c.getRank();
		retCard.suit = c.getSuit();
		return retCard;
	}

	/**
	 * Get method for Player name
	 * @return String containing Player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method which creates and returns a string specifying the Card's in the Player's hand
	 * @return String containing the Player's Cards
	 */
	public String handToString() {
		String s = new String();								//String which cards will be added to
		s = "";
		for (int i=0; i<hand.size(); i++) {
			s = s + (hand.get(i)).toString() + " ";
		}
		return s;
	}

	/**
	 * Method which creates and returns a string specifying the Card's in the Player's book
	 * @return String containing the Player's book's cards
	 */
	public String bookToString() {
		String s = new String();								//String which cards will be added to
		s = "";
		for (int i=0; i<book.size(); i++) {
			s = s + (book.get(i)).toString() + " ";
		}
		return s;
	}

	/**
	 * Get method for the size of the Player's hand
	 * @return int specifying hand size
	 */
	public int getHandSize() {
		return hand.size();
	}

	/**
	 * Get method for the size of the Player's book
	 * @return int specifying book size
	 */
	public int getBookSize() {
		return book.size();
	}
	
	
	//Here are som ideas for additional functionality that you may want/need
	//OPTIONAL
	// comment out if you decide to not use it
	//Does the player have a card with the same rank as c in her hand?
	//Return index, if N/A return -1

	/**
	 * Method which finds any Card of the same rank as c in hand, and returns its index, or -1 if no such card is found
	 * @param c Card with the rank we are looking for
	 * @return	int specifying location of card in hand
	 */
	public int rankInHand(Card c) {
		for (int i=0; i<hand.size(); i++){
		    if (hand.get(i).getRank() == c.getRank()) return i;
        }
        return -1;
	}

	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

	/**
	 * Method that removes pairs from hand, and adds them to book, also returns whether or not it found any pairs
	 * @return boolean specifying if a pair was found
	 */
    public boolean checkHandForBook() {
		Card searchCard = new Card();							//Card we are looking for a pair of
		boolean pairFound = false;								//indicates if we have found a pair
		int index;												//Location of second card in pair
		Card pair = new Card();									//Second card in pair
		for (int i=0; i<hand.size(); i++){
    		searchCard = hand.get(i);
    		removeCardFromHand(searchCard);
    		index = rankInHand(searchCard);
    		if (index != -1){
    			pair = hand.get(index);
				removeCardFromHand(pair);
				book.add(searchCard);
				book.add(pair);
				pairFound = true;
			}
			else hand.add(i, searchCard);
		}
		return pairFound;
    }

    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"
    public Card chooseCardFromHand() {
    	Card c = new Card();
    	int index;
    	for (int i = 1; i<4; i++){
    	    index = rankInHand(fishHelper.get(i));
    		if (index != -1){
    			c = hand.get(index);
    			return c;
			}
		}
		for (int i=0; i<hand.size(); i++){
    		if (hand.get(i).getRank() != fishHelper.get(0).getRank()){
    			c = hand.get(i);
    			return c;
			}
		}
		c = hand.get(0);
    	return c;
    }
    /*
    //Does the player have the card c in her hand?
    public boolean cardInHand(Card c) {
    	return false; //stubbed
    }
    

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    //e.g. will return true if the player has a 7d and the parameter is 7c
    
    public boolean sameRankInHand(Card c) {
    	return false; //stubbed
    }
*/
}
