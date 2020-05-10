package ParkKyuIL;

public class order extends main {
	
	private int money ;
	private int price ;
	private int number ;
	private String menu ;
	
	order(int money, int price, String menu,int number){
		this.money = money ;
		this.price = price ;
		this.menu = menu ;
		this.number = number ;
	}


	public void orderProcess() {     // getChange calculates the change and prints the amount of change and
	    // the number of drinks left and asks for another order
		int change;                                                                 // takes three four parameters and there is no return.
		change = money - price;
		System.out.println(menu+"와(과) "+ change + "원이 나왔습니다");
		System.out.println("현재" + menu + "는(은)" + number + "개 남아 있습니다");
		System.out.print("더 주문 하시겠습니까? [Y/N]");
	
	}
}