import java.util.*;
import java.io.*;

public class WordQuiz {
	Dictionary dict;
	public WordQuiz(Dictionary dictionary) {
		dict = dictionary;
	}
	public void runMenu() throws IOException, NullPointerException {
		//s document
		InputStream is = new FileInputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
		dict.load(is);
		Scanner scan = new Scanner(System.in);
		System.out.println("Vänligen välj ett av alternativen nedan.");
		int result = 0;
		
		while (!(result == 6)) {
			System.out.println();
			System.out.println("======= Meny =======");
			result = showMenu();
	
			switch (result) {
			case 1:
				System.out.println("Gör dig redo!");
				runQuiz();
				break;	
			case 2:
				System.out.println("Skriv Ord:Word");
				OutputStream os = new FileOutputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
				String line = scan.nextLine();
				String[] word = line.split(":");
				this.dict.add(word[0], word[1]);
				dict.save(os);
				break;
			case 3:
				//Add new words to wordlist
				Set<Word> words = dict.terms();
				System.out.println("");
				System.out.println("Ordlistan är:" + words);
				break;
			case 4:
				//Inverses the wordlist, run and reverts to original
				dict = dict.inverse();
				runQuiz();
				dict = dict.inverse();
				break;
			case 5:
				//Saves and quits the game
				System.out.println("Hejdå :(");
				System.exit(0);
			default:
				//If wrong input
			System.out.println("Fel inmatning. Försök igen.");
			}
		}
	}
		public void runQuiz() throws IOException, FileNotFoundException {
		
			//Counter for correct and incorrect answers
			int rätt = 0;
			int fel = 0;
			//Create two arrays, one with terms and one empty
			Set<Word> terms = dict.terms();
			ArrayList<Word> wordList = new ArrayList<Word>(terms);
			ArrayList<Word> correct = new ArrayList<Word>();
			
			while(!(wordList.isEmpty())) { 
				Scanner scan = new Scanner(System.in);
				for(Word term : wordList) {
					System.out.println("Ordet är: " + term);
					System.out.println("Svar: ");
					String svar = scan.nextLine();
					Word svarWord = new Word(svar);
					Set<Word> betydelser = dict.lookup(term);
					
					if(betydelser.contains(svarWord)) {
						//if correct answer, add the answer to empty array
						System.out.println("Rätt svar! :-)");
						correct.add(term);
						rätt++;
					}else {
						//wrong answer
						System.out.println("Fel svar! :-(");
						fel++;
					}
				}			
				//Removes all correct answers from wordList array
				for(Word term : correct) {
					wordList.remove(term);
				}
			}
			System.out.println("");
			System.out.println("Färdig brakkam bongo dongo!!");
			System.out.println("Du hade: " + fel + " fel och " + rätt + " rätt!");
			System.out.println("Tillbaka till menyn!");
			System.out.println("");
		}
			public static void main(String[] args) throws IOException {
				//Create an empty wordlist and fills it with words
				Dictionary sweng = new Dictionary();
				WordQuiz wq = new WordQuiz(sweng);
				wq.runMenu();    
			}
			private static int showMenu() {
				boolean cont = true;
				int choice = -1;
				while(cont) {
					//meny options
					System.out.println("1. Spela!");
					System.out.println("2. Lägg till ord.");
					System.out.println("3. Skriv ut hela ordlistan.");
					System.out.println("4. Spela invers!");
					System.out.println("5. Avsluta :(");
				
					try {
						Scanner scan = new Scanner(System.in);
						choice = scan.nextInt();
						cont = false;
					}
					catch (InputMismatchException ex) {
						System.out.println("Fel inmatning. Försök igen.");
					}
				}
				return choice;
			}
}