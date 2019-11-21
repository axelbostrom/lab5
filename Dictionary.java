import java.io.*;
import java.util.*;

/*** Denna klass modellerar en ordlista (Dictionary). En ordlista* associerar termer med betydelser. 
 * En term kan mappas till flera betydelser.* Både term och betydelse representeras med klassen Word.*/

public class Dictionary {
	
	/*** Lägger till termen t till ordlistan med betydelsen m. Om termen 
	 * redan  är tillagd med angiven betydelse händer ingenting.*/
	public void add(Word t, Word m){
		
	}
	
	/*** Bekvämare sätt att anropa add för 2 strängar  än 
	 * add(Word, Word).*/
	
	public void add(String t, String m){
		
	}
	/*** Returnerar en icke-null mängd med ordlistans alla termer.*/
	
	public Set<Word> terms(){
		
	}/*** Slår upp och returnerar en mängd av betydelser till t, eller 
	null om t inte finns i ordlistan.*/
	
	public Set<Word> lookup(Word t){
		
	}
	
	/*** Skapar och returnerar en ny ordlista på det motsatta språket, dvs, alla
	 *  betydelser blir termer och alla termer blir betydelser.
	 * T.ex. en* svensk-engelsk ordlista blir efter invertering engelsk-svensk.*/
	
	public Dictionary inverse() {
		return null;
	}
	
	 /*** Läser in orden från den givna strömmen och lägger dessa i ordlistan.*/
	
	public void load(InputStream is) {
	}
	
	/*** Lagrar ordlistan på den givna strömmen.*/
	
	​public void save(OutputStream os);
	
}