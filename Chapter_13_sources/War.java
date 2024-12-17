import Chapter_12.Card;
import Chapter_13.Deck;

/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {
        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subDeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subDeck(26, 51));
        Pile p3 = new Pile();
        int staticSize;

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            // compare the cards
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
                if (!p3.isEmpty()) {
                    staticSize = p3.size();
                    for (int index = 0; index < staticSize; index++) {
                        p1.addCard(p3.popCard());
                    }
                }
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
                if (!p3.isEmpty()) {
                    staticSize = p3.size();
                    for (int index = 0; index < staticSize; index++) {
                        p2.addCard(p3.popCard());
                    }
                }
            } else if (diff == 0) {
                // it's a tie...draw four more cards
                p3.addCard(c1);
                p3.addCard(c2);
                for (int index = 0; index < 3 && p1.size() > 0 && p2.size() > 0; index++) {
                    p3.addCard(p1.popCard());
                    p3.addCard(p2.popCard());
                }
            }
        }

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }

        System.out.print("prints to show one pile is empty. ");
        System.out.print("The winner's pile may not have all 52 cards; ");
        System.out.println("some may be left in the p3 pile, but it shouldn't matter");
        p1.print();
        System.out.println();
        p2.print();

    }

}
