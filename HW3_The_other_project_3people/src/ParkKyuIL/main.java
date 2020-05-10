package ParkKyuIL ;

import java.util.Scanner;

public class main {
    
	public static void main(String[] args) {
		
    int coke = 800;                //The first four variables represents the price of each drinks
    int water = 500;
    int coffee = 700;
    int redbull = 1200;
    
    
    int coke_num = 1;            // These four variables represents the number of each drink left in the machine
    int red_num = 5;
    int coffee_num = 5;
    int water_num = 5;
    
    Scanner sc = new Scanner(System.in);          //Scanner
    
    while(true) {                                  // To repeatedly ask the user the while statement starts
    	
    printMenu();                                    // the method printMenu() prints the interface of the menu board that shows price and name of the drinks
    int money = sc.nextInt();                        //get the value of money inserted
    if(money == 0) break;                                     // if 0 is typed we terminate the program
    System.out.println(money + "원을 투입하셨습니다.");            // confirms the money inserted
    System.out.print("원하시는 음료를 말씀해주세요 >> ");           // asks for menu
    String menu = sc.next();                                 //get menu as a string form
    
    
    if(menu.equals("콜라")){                               //if coke is selected, enters the if statement
    		 
       if(money<coke){                                    // if the money is less than the price
    	   System.out.println("금액이 부족합니다.");          // prints the statement
    	   System.out.println("");
    	   continue;                                     // go back to the beginning of the while loop
    	   }
       
       if (coke_num==0) {                                      //if the there is no coke in the machine
    	   System.out.println("죄송합니다 콜라가 다 떨어졌습니다");     //print the statement
    	  continue;                                             // go back to the beginning of the while loop
       }
       coke_num--;                                         // decrement the number of cokes
       orderProcess(money,coke,menu,coke_num);                // enters getChange() method that prints the change and the number of drinks left.
       String re_order = sc.next();                         // take the [Y/N] answer to re-start
       
       if (re_order.equals("Y")) continue;                  // if Yes, go back to the beginning of while loop
       else if(re_order.equals("N")) break;                  // if No, terminate the program.
       
          }
    
    
    else if(menu.equals("물")){                          // until line number 118, exactly the same code repeats with just the different variables
   
        
        if(money<water){
     	   System.out.println("금액이 부족합니다.");
     	   System.out.println("");
     	   continue;
     	   }
        
        if (water_num==0) {
     	   System.out.println("죄송합니다 물이 다 떨어졌습니다");
     	  continue;
        }
        
        water_num--;
        orderProcess(money,water,menu,water_num);
        String re_order = sc.next();
        if (re_order.equals("Y")) continue;
        else if(re_order.equals("N")) break;
        
           }
    
    
    else if(menu.equals("커피")){
   
    	
        if(money<coffee){
     	   System.out.println("금액이 부족합니다.");
     	   System.out.println("");
     	   continue;
     	   }
        
        if (coffee_num==0) {
     	   System.out.println("죄송합니다 커피가 다 떨어졌습니다");
     	  continue;
        }
        
        coffee_num--;
        orderProcess(money,coffee,menu,coffee_num);
        String re_order = sc.next();
        if (re_order.equals("Y")) continue;
        else if(re_order.equals("N")) break;
        
           }
    
    
    else if(menu.equals("레드불")){
    
    	
        if(money<coffee){
     	   System.out.println("금액이 부족합니다.");
     	   System.out.println("");
     	   continue;
     	   }
        
        if (red_num==0) {
     	   System.out.println("죄송합니다 레드불이 다 떨어졌습니다");
     	  continue;
        }
        
        red_num--;
       
        orderProcess(money,redbull,menu,red_num);
        String re_order = sc.next();
        if (re_order.equals("Y")) continue;
        else if(re_order.equals("N")) break;
        
           }
    
    
    else  System.out.println("정확히 입력해주세요!");     // if none of the menu is selected or irrelevant letter is typed, warns the user and resumes the while loop
    
  }

    System.out.println("이용해주셔서 감사합니다.");      //if break statement is used, the program finishes the session with the statement.
}
	
   
	// method//
	
	
	
	public static void printMenu() {                                                 // printMenu prints the interface of the vending machine
		                                                                             // there are no parameters, it only prints the sentecnes.
		 System.out.println("-------------한동자판기-------------");
		 System.out.println("      1.콜라   (800원)");
		 System.out.println("      2.물    (500원)");
		 System.out.println("      3.커피   (700원)");
		 System.out.println("      4.레드불 (1200원)");
		 System.out.println("    종료를 원하시면 0을 입력 해주세요 ");
		 System.out.println("---------------------------------");
		 System.out.print("금액을 넣어주세요 >> ");
		    
	 }
	
}
