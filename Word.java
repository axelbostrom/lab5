public class Word {
	
	private String text;
	
	public Word(String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public boolean equals(Object obj){
		
		if(obj.toString().equals(this.text))	
			return true;
		return false;
//		if (!(obj instanceof Word))
//				return false;
//		Word objWord = (Word) obj;
//		if (this.hashCode() == objWord.hashCode()) {
//			return true;
//		}	
	}
	
	public int hashCode(){
		return text.hashCode();	
	}
	
	public String toString(){
		return text;
	}
}