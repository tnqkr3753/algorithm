package starbucks;

public class Cake extends Menu {
	private char type;
	public Cake(String name, int price) {
		super(name, price);
		this.type = 'c';
	}

	@Override
	public char getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	
}
