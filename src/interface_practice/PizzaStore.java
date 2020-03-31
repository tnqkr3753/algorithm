package interface_practice;


public class PizzaStore implements DeliveryStore {
	private String[] orderList ;
	private Food[] menuList = new Food[3];
	private PizzaStore() {
		menuList[0] = new Food("Cheese",6000);
		menuList[1] = new Food("Pineapple",16000);
		menuList[2] = new Food("Meatball",26000);
	}
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i <orderList.length ; i++) {
			for (int j = 0; j < menuList.length; j++) {
				if(orderList[i].equals(menuList[j].name)) {
					total+=menuList[i].price;
				}
			}
		}
		return total;
	}
	@Override
	public void setOrderList(String[] str) {
		orderList = new String[str.length];
		for (int i = 0; i < orderList.length; i++) {
			orderList[i] = str[i];
		}
	}
	public int solution(String[] str) {
		setOrderList(str);
		int total = getTotalPrice();
		return total;
	}
}