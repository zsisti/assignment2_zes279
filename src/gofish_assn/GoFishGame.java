package gofish_assn;

public class GoFishGame {


    public void play(Player person, Player opponent, Deck d1){
        boolean noCards = true;
        if (person.checkHandForBook()) System.out.println(person.getName() + " books the " + (person.book.get(person.getBookSize()-1)).toString()
                + " and the " + (person.book.get(person.getBookSize()-2)).toString() + ". He now has " + String.valueOf(person.getBookSize()/2) + " pairs.");
        while (person.hand.size()>0) {
            noCards = false;
            Card askCard = new Card();
            askCard = person.chooseCardFromHand();
            System.out.println(person.getName() + " asks: 'Do you have a " + String.valueOf(askCard.getRank()) + "?'" );
            int cardIndex = opponent.rankInHand(askCard);
            if (cardIndex != -1) {
                System.out.println(opponent.getName() + " replies: 'Yes, here's my " + String.valueOf(askCard.getRank()) + "'" );
                askCard = opponent.removeCardFromHand(opponent.hand.get(cardIndex));
                person.addCardToHand(askCard);
                if (person.checkHandForBook()) System.out.println(person.getName() + " books the " + (person.book.get(person.getBookSize()-1)).toString()
                        + " and the " + (person.book.get(person.getBookSize()-2)).toString() + ". He now has " + String.valueOf(person.getBookSize()/2) + " pairs.");
            }
            else if (cardIndex == -1) {
                person.fishHelper.add(0,askCard );
                opponent.fishHelper.add(1,askCard);
                System.out.println(opponent.getName() + " replies: 'Go Fish!'" );
                break;
            }
        }
        if (d1.deck.size() > 0) {
            Card dealCard = new Card();
            dealCard = d1.dealCard();
            person.hand.add(dealCard);
            if (noCards) System.out.println(person.getName() + " draws a " + dealCard.toString() + " because he doesn't have any cards" );
            else System.out.println(person.getName() + " draws a " + dealCard.toString());
            if (person.checkHandForBook()) System.out.println(person.getName() + " books the " +
                    (person.book.get(person.getBookSize()-2)).toString() + " and the " +
                    (person.book.get(person.getBookSize()-1)).toString() + ". He now has " +
                    String.valueOf(person.getBookSize()/2) + " pairs.");
        }
        else System.out.println(person.getName() + " can't draw a card because the deck is empty");
        person.checkHandForBook();
    }

    public void finish(Player person){
        System.out.println(person.getName() + " wins with " + String.valueOf(person.getBookSize()/2) + " pairs!");
        for (int i=0; i<person.getBookSize(); i++){
            System.out.print((person.book.get(i)).toString() + " and ");
            i++;
            System.out.println(person.book.get(i).toString());
        }
    }

	public GoFishGame() {
        Deck d1 = new Deck();
        d1.shuffle();
        Player p1 = new Player("James");
        Player p2 = new Player("Gosling");
        for (int i=0; i<7; i++) {
            p1.hand.add(d1.dealCard());
            p2.hand.add(d1.dealCard());
        }
        int turnIndicator = 0;
        while(p1.getBookSize() + p2.getBookSize() != d1.NUM_CARDS){
            switch(turnIndicator){
                case 0 : play(p1, p2, d1);
                break;
                case 1 : play(p2, p1, d1);
                break;
            }
            System.out.println();
            turnIndicator = (turnIndicator == 0) ? 1 : 0;
        }
        if (p1.getBookSize() > p2.getBookSize()) finish(p1);
        else if (p1.getBookSize() < p2.getBookSize()) finish(p2);
        else System.out.println("It's a tie! " + p1.getName() + " and " + p2.getName() + " both have " + String.valueOf(p1.getBookSize()/2) + " pairs!");
	}

}
