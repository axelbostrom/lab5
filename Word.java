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
		if (obj instanceof Word) {
			if (this.getText().equalsIgnoreCase(((Word)obj).getText()))
				return true;
			return false;
		}
		return false;	
	}
	
	public int hashCode(){
		return text.hashCode();	
	}
	
	public String toString(){
		return text;
	}
}