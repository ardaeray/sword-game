/* Arda ERAY */

import java.util.*;

public class swordProject {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Pick a card and enter it here (like: 7, A, Q etc.): ");
        String pickedCard = input.nextLine();
        pickedCard = pickedCard.toLowerCase();
        String opponentsCard = "";
        String usersCard = "";

        System.out.println("\nThe one that gets the card you picked wins\nGame is starting...\n");

        LinkedList<String> deck = new LinkedList<String>();

        for (int shapes = 1; shapes < 5; shapes++) { // first part represents "clubs, diamonds, hearts and spades".
            String shape = "";
            if (shapes == 1)
                shape = "clubs";           
            if (shapes == 2)
                shape = "diamonds";
            if (shapes == 3)
                shape = "hearts";
            if (shapes == 4)
                shape = "spades";
            for (int numbers = 1; numbers < 14; numbers++) { //second part represents "A(1) to number 10 and 11 => King, 12 => Queen, 13 => Jack".
                String special = "";
                if (numbers > 10) {
                    if (numbers == 11)
                        special = "k";
                    if (numbers == 12)
                        special = "q";
                    if (numbers == 13)
                        special = "j";
                }
                else{
                    if (numbers == 1) {
                        special = "a";
                    }
                    else
                        special = "" + numbers;
                }

                String card = special + "-" + shape;
                deck.add(card);
            }
        }

        int chosenCard, countRound = 0;
        
        do {
            countRound++;
            System.out.println("Round: " + countRound);
            chosenCard = random.nextInt(deck.size());
            usersCard = deck.get(chosenCard);
            System.out.println("Your card is: " + usersCard);
            deck.remove(chosenCard);
            chosenCard = random.nextInt(deck.size());
            opponentsCard = deck.get(chosenCard); // more players can be added if necessary
            System.out.println("My card is: " + opponentsCard + "\n");
            deck.remove(chosenCard);
        } while (!(usersCard.substring(0, 1).equals(pickedCard) || opponentsCard.substring(0, 1).equals(pickedCard)));

        if (usersCard.substring(0, 1).equals(pickedCard)) {
            System.out.println("You picked " + usersCard + ". You won!");
        }
        else {
            System.out.println("You Lost! I picked the " + opponentsCard + ".");
        }
        System.out.println("Number of cards that showed off: " + (countRound * 2));
    }
}
