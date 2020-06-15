package starbucks;

public class Coffee extends Menu {
	private char type;
	public Coffee(String name, int price,char type) {
		super(name, price);
		this.type = type;
	}
	public char getType() {
		return type;
	}
	
	
}
