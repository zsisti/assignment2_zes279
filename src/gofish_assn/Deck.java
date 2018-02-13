package gofish_assn;

import java.util.ArrayList;

import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck

	/**
	 * Class Constructor that creates deck of NUM_CARDS unique cards
	 */
	public Deck() {
		Suits currentSuit = null;									//Keeps track of which suit we are assigning
		for (int i=0; i<4; i++){
			switch (i){
				case 0: currentSuit = Suits.club;
				break;
				case 1: currentSuit = Suits.diamond;
				break;
				case 2: currentSuit = Suits.heart;
				break;
				case 3: currentSuit = Suits.spade;
			}
			for (int j=1; j<(NUM_CARDS/4)+1; j++){
				Card newCard = new Card();							//Creates a new Card object for each rank
				newCard.rank = j;
				newCard.suit = currentSuit;
				deck.add(newCard);
			}
		}
	}

	/**
	 * Method that randomizes the deck
	 */
	public void shuffle() {
		int[] deckOrder = new int[NUM_CARDS];						//An array of ints which will represent the new locations of each card in the deck
		Random rand = new Random();
		int position;												//An integer which will take random ints to be inserted into deckOrder
		for (int k=0; k<10; k++) {
			for (int j = 0; j < NUM_CARDS; j++) {
				position = rand.nextInt(NUM_CARDS);
				for (int i = 0; i < NUM_CARDS; i++) {
					if (position == deckOrder[i]) {
						position = rand.nextInt(NUM_CARDS);
						i = 0;
					}
				}
				deckOrder[j] = position;
			}
			Card cHolder = new Card();								//Creates a new card as a temporary holder for cards as they are swapped
			for (int i = 0; i < NUM_CARDS; i++) {
				cHolder = deck.get(deckOrder[i]);
				deck.set(deckOrder[i], deck.get(i));
				deck.set(i, cHolder);
			}
		}
	}

	/**
	 * Method that prints the deck of cards
	 */
	public void printDeck() {
		for (int i=0; i<NUM_CARDS; i++){
			System.out.println((deck.get(i)).toString());
		}
	}
	
	
	public Card dealCard() {
		
		Card c = new Card();
		
		return c;
		
	}
	

}
