package starbucks;

public abstract class Menu {
	//멤버변수
	protected String name;
	protected int price;
	public Menu(String name,int price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public abstract char getType();
}
