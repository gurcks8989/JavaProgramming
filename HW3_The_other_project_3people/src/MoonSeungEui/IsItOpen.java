package MoonSeungEui;

/*
 * Name of program: Is That Store Opened? 
 * writer: Moon, Seung Eui
 * Student Num: 21500242
 * 
 */

import java.util.Scanner;

public class IsItOpen {

	public static void main(String[] args)
	{
		IsItOpen iio=new IsItOpen();		//make a object
		Scanner scanner=new Scanner(System.in);
		
		
		while(true) {		
//This literative sentences will end when the user say "no"
			
		System.out.println("which store do you want to know ?");		//Choice of store
	    System.out.println("GS\tMarket\tEdiya\tResrauran\tBurgerking");		
		String s=scanner.next();		
//get a store name from user
		String store=s.toLowerCase();
		int storeNum=iio.setStoreName(store);
		if(storeNum==-1) continue;			
//If the name of store is not there, ask again.
		
		System.out.println("What time do you want to go ?");		//ask about the time 
	    System.out.println("example: midnight=0, noon=12");		
		int time=scanner.nextInt();	
		if(time>24||time<0) {		
//if answer of time is wrong restart this program.
			System.out.println("It is Wrong time. Please use 0 to 24 ");
			System.out.println();
			continue;
		}
		
		System.out.println("What day do you want to go ?");			//ask about the day
	    System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		String d=scanner.next();	
		String day=d.toLowerCase();		
//make lowercase for compare
		boolean dayright=setDay(day);
		if(dayright==false) {
			System.out.println("It is Wrong day. Please use mon to sun ");
			continue;
		}
		
		boolean b=iio.isit(storeNum,time,day);			
//give the value to the object 'iio' the function 'isit' return the value of yes or not about the store
		if(b==true) {			
			System.out.println("Yes that is opened that time.");
		}else {
			System.out.println("No, that is not opened that time\n");
		}
			
		System.out.println("Do you want to Know more?");		
//ask again, if the answer is no, program will finish.
		String yesorno=scanner.next();
		if(yesorno.equals("no")) break;
		}
		
		System.out.println("Thank you for using this program:)");		
		
	}
	
	public int setStoreName(String store) {			
//this method changes the name of store to number.
		int a;
		if(store.equals("gs")) {
			a=1; return a;
		}else if(store.equals("market")) {
			a=2; return a;
		}else if(store.equals("ediya")) {
			a=3; return a;
		}else if(store.equals("restaurant")) {
			a=4; return a;
		}else if(store.equals("burgerking")) {
			a=5; return a;
		}else {
			System.out.println("It is Wrong store name.");
			a=-1; return a;
		}
	}
	public static boolean setDay(String day) {		
//this method check there are wrong answer in day.
		if(day.equals("mon")) return true;
		else if(day.equals("tue")) return true;
		else if(day.equals("wed")) return true;
		else if(day.equals("thu")) return true;
		else if(day.equals("fri")) return true;
		else if(day.equals("sat")) return true;
		else if(day.equals("sun")) return true;
		else return false;
	}
	
	
	public boolean GS(int time,String day) {	
//each method return the boolean result by each conditions.
		if(time>9 && time<23) {				
			if(day.equals("Sun")) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean Market(int time,String day) {
		if(time>9 && time<19) {
			if(day.equals("Sun")) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean Ediya(int time,String day) {
		if(time>9 && time<21) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Restaurant(int time,String day) {
		if(time>9 && time<20) {
			if(day.equals("Sun")) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean Burgerking(int time,String day) {
		if(time>9 && time<20) {
			if(day.equals("Mon")) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
		
}
