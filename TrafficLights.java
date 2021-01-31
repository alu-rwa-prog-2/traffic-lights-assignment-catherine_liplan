import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer; 
import java.util.TimerTask; 


class GreenLight extends TimerTask{	
	
	int[] cars = new int[100];
	public void run()
	{
		int[] newCarList = new int[cars.length - 1];
		System.arraycopy(cars, 0, newCarList, 0, newCarList.length-2);
			
	}
}

class YellowLight extends TimerTask{
	
	int[] cars = new int[100];
	
	public void run()
	{
		
		int[] newCarList = new int[cars.length - 1];
		System.arraycopy(cars, 0, newCarList, 0, newCarList.length-2);
			
	}
}

class RedLight extends TimerTask{
	int seconds = 0;
	
	public void run()
	{
		seconds++;
		System.out.println(seconds);
		
	}
}

public class TrafficLights {
	public static int[] cars = new int[100];
	
	public static void main(String[] args) {
		System.out.println("Adding cars to collection...");
		System.out.println("Traffic moving....");
		
		add_car();
		
		
//		while (cars.length > 0) {
			Timer timer = new Timer(); 
		    TimerTask goGreen = new GreenLight();
	        timer.schedule(goGreen, 30000, 1000);
	        System.out.println("Yellow Light!");
	        
	        
	        Timer timer2 = new Timer(); 
	        TimerTask goYellow = new YellowLight();
	        timer.schedule(goYellow, 20000, 30000);
	        System.out.println("Red Light!");
	        
	        Timer timer3 = new Timer();
	        TimerTask stopRed = new RedLight();
	        timer.schedule(stopRed, 10000, 1000);
	        System.out.println("Yellow Light!");
	        
	        Timer timer4 = new Timer(); 
	        TimerTask goYellow2 = new YellowLight();
	        timer.schedule(goYellow2, 20000, 30000);
	        System.out.println("Green Light!");
	        
//		}
			
	}
	
	public static void add_car() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
	         cars[i] = rd.nextInt(); 
	         System.out.println(cars[i]);          
		}
	}
//	public void remove_car() {
//		int[] newCarList = new int[cars.length - 1];
//		System.arraycopy(cars, 0, newCarList, 0, newCarList.length-2);
//		System.out.println(newCarList.length);
//		
//	}
//		
	
				

	

}
