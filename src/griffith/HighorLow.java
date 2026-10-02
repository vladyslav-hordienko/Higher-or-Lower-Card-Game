// Academic project by Vladyslav Hordiienko

package griffith;

import java.util.Random;
import java.util.Scanner;

public class HighorLow {

  // cyan text color for highlighting the text
    public static final String CYAN = "\u001B[36m";

    // Bold text formatting for emphasis in text
    public static final String BOLD = "\u001B[1m";
  
    
    		// ASCII color codes
    	public static final String GREY = "\u001B[90m";
    	public static final String YELLOW = "\u001B[33m";
    	public static final String BLUE = "\u001B[34m";
    	public static final String GREEN = "\u001B[32m";
    	public static final String RED = "\u001B[31m";
    
    	
    		// messages for different languages to choose
   private static String welcomemessage, languagechoice, startmessage, roundmessage, cardmessage, guessmessage, invalidinputmessage;
   private static String statisticsmessage, totalroundsmessage, totalpointsmessage, playerlevelmessage;
   private static String nextstepmessage1, nextstepmessage2, nextstepmessage3;
   private static String nextcardmessage, wrongmessage, pointsmessage;

   		public static void main(String[] args) {
    	
    		Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Language selection for game
        System.out.println(BOLD + CYAN + "Welcome to Higher or Lower!");
        	System.out.println(YELLOW + "Please select your language:");
        	System.out.println("1 - English");
        	System.out.println("2 - Irish");
        	System.out.println("3 - German");
        	System.out.print("Enter your choice: ");
        int languageChoice = Integer.parseInt(scan.nextLine());
     setMessages(languageChoice);
     

     System.out.println(welcomemessage); // Game description and welcoming text
        System.out.println(languagechoice); // Language choice message
        System.out.println(startmessage); // Start message
        
        	boolean keepPlaying = true;  // game loop flag
        	int currentCardValue = random.nextInt(13) + 1; // first random card value from 1 to 13
        	String currentCardSuit = getRandomSuit(random); // First random card suit
        	int points = 0; // score of user
        	int totalRounds = 0; // total rounds played
        
        	
       while (keepPlaying) {
    	   
    	   	// Play 5 rounds
            int roundsToPlay = 5;
            
            for (int round = 1; round <= roundsToPlay; round++) {
                totalRounds++;
                	System.out.println(BOLD + roundmessage + " " + totalRounds + ":");
                	System.out.println(GREEN + cardmessage + " " + cardToString(currentCardValue, currentCardSuit));
                
                // asking user for guess
              System.out.print(GREY + guessmessage);
               String guess = scan.nextLine().toUpperCase();

                // validating input of user
               		while (!guess.equals("H") && !guess.equals("L")) {
                		System.out.print(RED + invalidinputmessage);
                		guess = scan.nextLine().toUpperCase();
                }

              // Generating next card
                int nextCardValue = random.nextInt(13) + 1; // Random card value (1-13)
                String nextCardSuit = getRandomSuit(random); // Random card suit
               System.out.println(GREEN + nextcardmessage + " " + cardToString(nextCardValue, nextCardSuit));

                // understanding whether the guess is correct or not
             if ((guess.equals("H") && nextCardValue > currentCardValue) || 
                    (guess.equals("L") && nextCardValue < currentCardValue)) {
                    System.out.println(BOLD + GREEN + "Correct! You earn a point.");
                    points++;
             } else if (nextCardValue == currentCardValue) {
                    System.out.println(BOLD + YELLOW + "It's a tie! No points awarded.");
                } else {
                    System.out.println(BOLD + RED + wrongmessage);
                    points--;
                }
             
                // update the current card to next one
             currentCardSuit = nextCardSuit;
                currentCardValue = nextCardValue;

                // Displaying current points
                System.out.println(CYAN + pointsmessage + points);
            		}
            

            // menu after 5 rounds played
         while (true) {
               System.out.println(BOLD + nextstepmessage1);
                System.out.println(GREY + nextstepmessage2);
                System.out.println(GREEN + nextstepmessage3);
               System.out.print(BOLD + "Enter your choice: ");
                
                String choice = scan.nextLine();
                
                
                if (choice.equals("1")) { // play next 5 rounds
                    break;
             } else if (choice.equals("2")) { // view statistics of the game 
                    displayStatistics(points, totalRounds);
                    
                 //  quit  game 
             		} else if (choice.equals("3")) { 
                    System.out.println(BOLD + "Thanks for playing! Final statistics:");
                    displayStatistics(points, totalRounds);
                    keepPlaying = false;
                    break;
              	} else { // invalid input
                    System.out.println(RED + "Invalid choice. Enter 1, 2, or 3.");
                	}
            }
        }
    }
  	   // generating a random suit for game
	private static String getRandomSuit(Random random) {
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
			return suits[random.nextInt(suits.length)];
}

	// converting card value and suit to a readable format
		private static String cardToString(int cardValue, String cardSuit) {
			String valueString;
				switch (cardValue) {

		case 1: valueString = "Ace"; break;
	   case 2: valueString = "Jack"; break;
	   case 3: valueString = "Queen"; break;
	   case 4: valueString = "King"; break;
    default: valueString = String.valueOf(cardValue); break;
}
return valueString + " of " + cardSuit;
}

    	// set of messages for game based on choice of the language
    private static void setMessages(int choice) {
    		if (choice == 1) {
    			//   enslish language masseges 
            welcomemessage = "Let's play Higher or Lower!";
            languagechoice = "Please select your language:";
            startmessage = "You start with 0 points. Let's go!";
            roundmessage = "Round";
            cardmessage = "Current card:";
            guessmessage = "Will the next card be higher (H) or lower (L)? ";
            invalidinputmessage = "Invalid input. Enter 'H' or 'L': ";
            statisticsmessage = "Game Statistics:";
            totalroundsmessage = "Total rounds played: ";
            totalpointsmessage = "Total points: ";
            playerlevelmessage = "Player level: ";
            nextstepmessage1 = "What would you like to do next?";
            nextstepmessage2 = "1 - Play next 5 rounds";
            nextstepmessage3 = "2 - View statistics - Quit the game";
            nextcardmessage = "Next card:";
            wrongmessage = "Wrong! You lose a point.";
            pointsmessage = "Your points: ";
    	} else if (choice == 2) {
        		// Irish language messages
           welcomemessage = "Déanaimis imirt níos airde nó níos ísle!";
           languagechoice = "Tosaíonn tú le 0 pointe. A ligean ar dul!";
           startmessage = "A ligean ar imirt!";
           roundmessage = "Babhta";
           cardmessage = "Cárta reatha:";
           guessmessage = "An mbeidh an chéad chárta eile níos airde (H) nó níos ísle (L)? ";
           invalidinputmessage = "Ionchur neamhbhailí. Cuir isteach 'H' nó 'L': ";
           statisticsmessage = "Staitisticí na hImeartha:";
           totalroundsmessage = "Uimhreacha iomlána na mbabhtaí: ";
           totalpointsmessage = "Pointe iomlána: ";
          playerlevelmessage = "Leibhéal imreora: ";
           nextstepmessage1 = "Cad ba mhaith leat a dhéanamh anois?";
           nextstepmessage2 = "1 - Imir 5 babhta eile";
           nextstepmessage3 = "2 - Féach ar na staitisticí - Críochnaigh an cluiche";
           nextcardmessage = "Cárta eile:";
           wrongmessage = "Mícheart! Caillfidh tú pointe.";
           pointsmessage = "Do phointí: ";
    		} else {
        		// german language messages
        		welcomemessage = "Spielen wir um höher oder niedriger!";
        		languagechoice = "Der Wert der Karten reicht von 1 bis 13.";
        		startmessage = "Sie beginnen mit 0 Punkten.";
        		roundmessage = "Runde";
            	cardmessage = "Aktuelle Karte:";
            	guessmessage = "Ist die nächste Karte höher (H) oder niedriger (L)? ";
            	invalidinputmessage = "Ungültige Eingabe, bitte 'H' oder 'L' eingeben: ";
            	statisticsmessage = "Spielstatistiken:";
            	totalroundsmessage = "Gesamtzahl der gespielten Runden: ";
            	totalpointsmessage = "Gesamtpunkte: ";
            	playerlevelmessage = "Spielerlevel: ";
            	nextstepmessage1 = "Was möchten Sie als Nächstes tun?";
            	nextstepmessage2 = "1 - Spielen Sie weitere 5 Runden";
            		nextstepmessage3 = "2 - Sehen Sie sich die Statistik  - Beenden Sie das Spiel";
            	nextcardmessage = "Nächste Karte:";
            	wrongmessage = "Falsch! Du verlierst einen Punkt.";
            	pointsmessage = "Deine Punkte: ";
        }
    }

   

    	// providing statistics of play including levels
    
    private static void displayStatistics(int points, int totalRounds) {
    		System.out.println(CYAN + statisticsmessage);
        	System.out.println(GREEN + totalroundsmessage + totalRounds);
        	System.out.println(GREEN + totalpointsmessage + points);
        	String playerLevel = "";

        		if (points >= 35) {
        		playerLevel = "GOD player";
        } else if (points >= 20) {
            playerLevel = "TOP Player";
        } else if (points >= 10) {
            playerLevel = "Good player";
        } else if (points >= 5) {
            playerLevel = "Beginner level";
        } else {
            playerLevel = "No level reached";
        }

        System.out.println(GREEN + playerlevelmessage + playerLevel);
    }
}
