public class Word {
	
	private String text;
	
	public Word(String text){
		this.text = text;
	}
	
	public boolean equals(Object obj){
		
		if(obj.toString().equals(this.text))	
			return true;
		return false;
	}
	
	public int hashCode(){
		return text.hashCode();	
	}
	
	public String toString(){
		return text;
	}
}