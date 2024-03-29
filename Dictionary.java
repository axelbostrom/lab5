import java.io.*;
import java.util.*;

public class Dictionary {
		Map<Word,Set<Word>> map;
		
		public Dictionary() {
			map = new HashMap<>();
		}

	public void add(Word t, Word m) {
		if(map.containsKey(t)) {
			Set<Word> existerandeBetydelser = map.get(t);
			existerandeBetydelser.add(m);
			return;
		}
		Set<Word> nyBetydelse = new HashSet<>();
		nyBetydelse.add(m);
		map.put(t, nyBetydelse);
	}
	
	public void add(String t, String m) {
		add(new Word(t), new Word(m));
	}
	/*** Returnerar en icke-null mängd med ordlistans alla termer.*/
	
	public Set<Word> terms() {
		if (!map.isEmpty()) {
			return map.keySet();	
		}
		return null;
		
	}
	/*** Slår upp och returnerar en mängd av betydelser till t, eller 
	null om t inte finns i ordlistan.*/
	
	public Set<Word> lookup(Word t) {
		while (map.containsKey(t)) {
			return map.get(t);
		}
		return null;
	}
	
	/*** Skapar och returnerar en ny ordlista på det motsatta språket, dvs, alla
	 *  betydelser blir termer och alla termer blir betydelser.
	 * T.ex. en* svensk-engelsk ordlista blir efter invertering engelsk-svensk.*/
	
	public Dictionary inverse() {
		Dictionary inv = new Dictionary();
		for(Word key : map.keySet()) {
			for(Word term : lookup(key)) {
				inv.add(term, key);
			}
		}
		return inv;
	}
	
	 /*** Läser in orden från den givna strömmen och lägger dessa i ordlistan.
	 * @throws IOException */
	
	public void load(InputStream is) throws IOException, FileNotFoundException, NullPointerException, ArrayIndexOutOfBoundsException {
	//bufferreader	
//	is = new FileInputStream("/home/axebo861/eclipse-workspace/lab5/src/ordlista.txt");
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		while (reader.ready()) {
			String line = reader.readLine();
			String[] words = line.split(":");
			add(words[0], words[1]);
		}
	}
	
	/*** Lagrar ordlistan på den givna strömmen.
	 * @throws IOException */
	
	public void save(OutputStream os) throws IOException, FileNotFoundException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
		for(Word key : map.keySet()) {
				for(Word value : map.get(key)) {
					writer.write(key + ":" + value + "\n");
				}
		}
		writer.close();
	}
}