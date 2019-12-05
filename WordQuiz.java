import java.util.*;
import java.io.*;

public class WordQuiz {
	Dictionary dict;
	public WordQuiz(Dictionary dictionary) {
		dict = dictionary;
	}
	public void runMenu() throws IOException {
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
				InputStream is = new FileInputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
				dict.load(is);
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
				Set<Word> words = dict.terms();
				System.out.println("");
				System.out.println("Ordlistan är:" + words);
				break;
			case 4:
				InputStream is2 = new FileInputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
				dict.load(is2);
				dict = dict.inverse();
				OutputStream os2 = new FileOutputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
				dict.save(os2);
				runQuiz();
				break;
			case 5:
				OutputStream os3 = new FileOutputStream ("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
				dict.save(os3);
				System.out.println("Hejdå :(");
				System.exit(0);
			default:
			System.out.println("Fel inmatning. Försök igen.");
			}
		}
	}
		public void runQuiz() throws IOException, FileNotFoundException {
		
			int rätt = 0;
			int fel = 0;
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
						System.out.println("Rätt svar! :-)");
						//lägg rätt svar i correct
						correct.add(term);
						rätt++;
					}else {
						System.out.println("Fel svar! :-(");
						fel++;
					}
				}			
				for(Word term : correct) {
					wordList.remove(term);
				}
			}
			System.out.println("");
			System.out.println("Färdig brakkam bongo dongo!!");
			System.out.println("Du hade: " + fel + " fel och " + rätt + " rätt!");
			System.out.println("Tillbaka till menyn!");
			System.out.println("");
			runMenu();
		}
			public static void main(String[] args) throws IOException {
				// Skapa en tom ordlista på ngt sätt och fyll den med ord. Dictionary
				Dictionary sweng = new Dictionary();
				WordQuiz wq = new WordQuiz(sweng);
				wq.runMenu();    
			}
			private static int showMenu() {
				boolean cont = true;
				int choice = -1;
				while(cont) {
					System.out.println("1. Spela!");
					System.out.println("2. Lägg till ord.");
					System.out.println("3. Skriv ut hela ordlistan.");
					System.out.println("4. Spela Invers!");
					System.out.println("5. Spara och avsluta :(");
				
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