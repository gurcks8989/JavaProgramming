package MoonSeungEui;

public class isit extends IsItOpen  {
	private int storeNum ;
	private int time ;
	private String day ;
	
	isit(int storeNum, int time, String day){
		this.storeNum = storeNum ;
		this.time = time ;
		this.day = day ;
	}
	
	public boolean isit()		//this method get the elements and call other fuction to know that store is opened at that time and day.
	{
		IsItOpen iio2=new IsItOpen();
		boolean openornot;
		
		if(storeNum==1) {
			openornot=iio2.GS(time,day);
			return openornot;
		}else if(storeNum==2) {
			openornot=iio2.Market(time,day);
			return openornot;
		}else if(storeNum==3) {
			openornot=iio2.Ediya(time,day);
			return openornot;
		}else if(storeNum==4) {
			openornot=iio2.Restaurant(time,day);
			return openornot;
		}else if(storeNum==5) {
			openornot=iio2.Burgerking(time,day);
			return openornot;
		}else return false;
		
	}
	
}
