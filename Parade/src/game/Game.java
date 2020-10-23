package game;

import java.io.IOException;
import java.util.*;

public class Game {

	public static void main(String[] args) throws IOException {
		ArrayList<Card> mainDeck = createDeck(new ArrayList<Card>());
		Collections.shuffle(mainDeck);
		int nPlayers, turn = 0;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Player> player = new ArrayList<>();
		ArrayList<Card> parade = new ArrayList<>();
		ArrayList<Score> score = new ArrayList<>();
		ArrayList<Majority> majority = new ArrayList<>();
		boolean isValid = false;
		boolean isOver = false;
		boolean colorsEnd = false;
		String[] colors = {"BLUE","BLACK","RED","YELLOW","PURPLE","GREEN"};
		do {
			//Get Number Of Players
			System.out.print("How many people are playing: ");
			nPlayers = keyboard.nextInt();
			if (nPlayers >= 2 && nPlayers <= 6) {
				isValid = true;
			} else {
				System.out.println("Game is for 2 to 6 players, please enter 2, 3, 4, 5, or 6");
			}
		} while (!isValid);
		//Get player names
		for(int i=0; i<nPlayers; i++) {
			System.out.print("Player "+(i+1)+": ");
			String name = keyboard.next();
			//Create Objects for each player
			player.add(new Player(name, new ArrayList<Card>(), new ArrayList<Card>()));
		}
		//Deal 5 cards to each player
		for(int i=0; i<5; i++) {
			for(int j=0; j<nPlayers; j++) {
				player.get(j).addToHand(mainDeck.get(mainDeck.size()-1));
				mainDeck.remove(mainDeck.size()-1);
			}
		}
		//Deal 6 cards for starting parade
		for(int i=0; i<6; i++) {
			parade.add(mainDeck.get(mainDeck.size()-1));
			mainDeck.remove(mainDeck.size()-1);
		}
		/****Setup Complete****/
		//----------------------------------------------------------------------------------------------
		/*Start Game Loop*/
		do {
			//Clear the console
			//Print Everyones palette
			for (int i = 0; i < nPlayers; i++) {
				System.out.println(player.get(i).getName() + "'s palette: " + player.get(i).getPalette());
			}
			//Display the current parade
			System.out.println("F "+parade+" E");
			//Display turn
			int temp = turn%nPlayers;
			int index;
			do {
				isValid = false;
				System.out.println(player.get(temp).getName() + "'s turn\tCurrent Parade Size: "+parade.size());
				System.out.println("Hand: " + player.get(temp).getHand());
				System.out.print(
						"Enter the index (0, 1, 2, 3, 4) of the card you wish to play onto the E of the parade: ");
				index = keyboard.nextInt();
				if(index >= 0 && index <= player.get(temp).getHand().size()) {
					isValid = true;
				} else {
					System.out.println("Invalid: please enter 0, 1, 2, 3, 4");
				}
			} while (!isValid);
			//Add card to parade
			parade.add(player.get(temp).getHand().get(index));
			//Check if they get some cards in their palette
			int value = player.get(temp).getHand().get(index).getValue();
			String color = player.get(temp).getHand().get(index).getColor();
			int starting = (parade.size()-2)-value;
			for (int j=starting; j>=0; j--){
				if(j<0) {
					break;
				}
				else if(parade.get(j).getValue() <= value) {
					player.get(temp).addToPalette(parade.get(j));
					parade.remove(j);
				}
				else if(parade.get(j).getColor().equals(color)) {
					player.get(temp).addToPalette(parade.get(j));
					parade.remove(j);					
				}
			}
			//Remove Card from hand
			player.get(temp).getHand().remove(index);
			//Draw a card if possible
			if(mainDeck.size() > 0) {
				player.get(temp).addToHand(mainDeck.get(mainDeck.size()-1));
				mainDeck.remove(mainDeck.size()-1);
			}
			for(int i=0; i<nPlayers; i++) {
				if(player.get(i).getHand().size() == 4) {
					isOver = true;
				}
				else {
					isOver = false;
				}
			}
			//Check to see if all six colors are present -if yes game end
			if(sixColors(player.get(temp).getPalette())) {
				colorsEnd = true;
				break;
			}
			turn++;
		}while(!isOver);
		//Print Everyones palette
		for (int i = 0; i < nPlayers; i++) {
			System.out.println(player.get(i).getName() + "'s palette: " + player.get(i).getPalette());
		}
		// each player has four cards now decide which two to add to palette
		for(int i=0; i<nPlayers; i++) {
			if(colorsEnd) {break;}
			do {
				isValid = false;
				System.out.println(player.get(i).getName() + "'s Hand: " + player.get(i).getHand());
				System.out.print("Enter Two indexes that you want to add to your palette: ");
				int first = keyboard.nextInt();
				int second = keyboard.nextInt();
				player.get(i).addToPalette(player.get(i).getHand().get(first));
				player.get(i).addToPalette(player.get(i).getHand().get(second));
				if(first > 3 || second > 3) {
					System.out.println("Invalid choice enter 0, 1, 2, or 3");
				}
				else if(first == second) {
					System.out.println("Your choices must be different cards");
				}
				else {
					isValid = true;
				}
			} while (!isValid);
		}
		//Create Score object for each player
		for (int i = 0; i < nPlayers; i++) {
			score.add(new Score(player.get(i).getName(), 0));
		}
		//Figure out max of each color
		for (int i=0; i<6; i++) { //Loop to track each of the six colors
			int max=0;
			for(int j=0; j<nPlayers; j++) { //Loop each player
				int color=0;
				for(int k=0; k<player.get(j).getPalette().size(); k++) { //illiterate though players palette
					if(player.get(j).getPalette().get(k).getColor().equals(colors[i])) {color++;}
				}
				if(color > max) {max = color;}
			}
			majority.add(new Majority(new ArrayList<Integer>(), max, colors[i]));
		}
		//figure out what player indexes have that many cards
		for (int i=0; i<6; i++) { //Loop to track each of the six colors
			for(int j=0; j<nPlayers; j++) { //Loop each player
				int color=0;
				for(int k=0; k<player.get(j).getPalette().size(); k++) { //illiterate though players palette
					if(player.get(j).getPalette().get(k).getColor().equals(colors[i])) {color++;}
				}
				if(color == majority.get(i).getMax()) {majority.get(i).addIndex(j);}	
			}
		}
		//print majorities
		for(int i=0; i<majority.size(); i++) {
			System.out.println(colors[i]+"- Max: "+majority.get(i).getMax()+" Owner(s): "+majority.get(i).getIndex());
		}
		//Print Everyones palette
		for (int i = 0; i < nPlayers; i++) {
			System.out.println(player.get(i).getName() + "'s palette: " + player.get(i).getPalette());
		}
		//Add majority scores and remove cards from palette (a.k.a) number of cards
		for(int i=0; i<majority.size(); i++) {
			for(int j=0; j<majority.get(i).getIndex().size(); j++) {
				for(int k=0; k<player.get(majority.get(i).getIndex().get(j)).getPalette().size(); k++) {
					if(player.get(majority.get(i).getIndex().get(j)).getPalette().get(k).getColor().equals(majority.get(i).getColor())) {
						player.get(majority.get(i).getIndex().get(j)).getPalette().remove(k);
						k--;
					}
				}
				score.get(majority.get(i).getIndex().get(j)).addScore(majority.get(i).getMax());
			}	
		}
		//Add all remaining cards in palette by value
		for(int i=0; i<nPlayers; i++) {
			for(int j=0; j<player.get(i).getPalette().size(); j++) {
				score.get(i).addScore(player.get(i).getPalette().get(j).getValue());
			}
		}
		//Print scores
		for (int i = 0; i < nPlayers; i++) {
			System.out.println(score.get(i).getName() + "'s score: " + score.get(i).getScore());
		}
	}
	
	public static boolean sixColors(ArrayList<Card> list) {
		boolean colors =  false;
		int yellow=0, blue=0, green=0, red=0, black=0, purple=0;
		for(int i=0; i<list.size()-1; i++) {
			switch(list.get(i).getColor()) {
				case "PURPLE":
				purple++;
				break;
				case "BlACK":
				black++;
				break;
				case "YELLOW":
				yellow++;
				break;
				case "BLUE":
				blue++;
				break;
				case "GREEN":
				green++;
				break;
				case "RED":
				red++;
				break;
				default:
				break;
				
			}
		}
		if(purple > 0 && black > 0 && yellow > 0 && blue > 0 && green > 0 && red > 0) {
			colors = true;
		}
		return colors;
	}

	public static ArrayList<Card> createDeck(ArrayList<Card> deck) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] colors = {"BLUE","BLACK","RED","YELLOW","PURPLE","GREEN"};
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<colors.length; j++) {
				deck.add(new Card(nums[i],colors[j]));
			}
		}
		return deck;
	}

}
