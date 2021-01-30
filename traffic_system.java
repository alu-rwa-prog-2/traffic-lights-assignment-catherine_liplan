import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class traffic_system{
    public static void main(String[] args){
        // cars in the street
        ArrayList<String> AllCars = new ArrayList<String>();
        for (int i = 1; AllCars.size() < 100; i++){
            String add_int_str = Integer.toString(i);
            String name = "car" + add_int_str;
            AllCars.add(name);

        }

        // cars in my collection which is equal to the cars present in the round about
        ArrayList<String> round_about = new ArrayList<String>();

        ArrayList<String> out_cars = new ArrayList<String>();

        Random random = new Random();

        Integer added = 0;


        // loop - this adds the cars randomly to the roundabout to await to exit
        while (true){
            String cr = AllCars.get(random.nextInt(AllCars.size()));
            
            // System.out.println("Picked: " + cr);
            // DELETE THE CARS WHICH HAVE MOVED

            if (round_about.contains(cr)){
                ;
            }
            else {
                round_about.add(cr);
                added ++;
            }

            
            if (added == 20){
                System.out.println("20 cars added to the round about");
                added = 0;  //reset counter of added
                continue;
            }

            if (round_about.size() == 100) {
                AllCars.clear();
                System.out.println("Cars in the street now " + AllCars.size());
                System.out.println("Cars in the round about now " + round_about.size());
                break;
            }
            


        }


        while (true){
            while (true) {
                Timer green = new Timer();
                int begin_green = 0;
                int timeInterval_green = 1000;
                green.schedule(new TimerTask() {
                    int counter = 0;
                    // Integer exit_car = 1;
    
                    @Override
                    public void run() {
                        
                        System.out.println();
                        System.out.println("GREEN -> " + round_about.get(round_about.size() - 1) + " exited");
                        out_cars.add(round_about.get(round_about.size() - 1));
                        System.out.println();
                        round_about.remove(round_about.size() - 1);
                        counter ++;
                        // exit_car ++;
    
                        if (counter >= 30) {
                            green.cancel();
                        }
                    }
                }, begin_green, timeInterval_green);
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            if (round_about.size() == 0) {
                break;
            }
    
            while (true) {
                Timer red = new Timer();
                int begin_red = 0;
                int timeInterval_red = 20000;
                red.schedule(new TimerTask() {
                    int counter = 0;
                    @Override
                    public void run() {
                        
                        System.out.println();
                        System.out.println("RED -> No movement!");
                        System.out.println();
                        counter++;
                        
    
                        if (counter == 1){
                            red.cancel();
                        }
                    }
                }, begin_red, timeInterval_red);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            if (round_about.size() == 0) {
                break;
            }
    
            while (true) {
                Timer yellow = new Timer();
                int begin_yellow = 0;
                int timeInterval_yellow = 2000;
                yellow.schedule(new TimerTask() {
                    int counter = 0;
                    // Integer exit_car = 1;
                    @Override
                    public void run() {
                        
                        System.out.println();
                        System.out.println("YELLOW -> " + round_about.get(round_about.size() - 1) + " exited");
                        out_cars.add(round_about.get(round_about.size() - 1));
                        System.out.println();
                        round_about.remove(round_about.size() - 1);
                        counter++;
                        // exit_car ++;
    
                        if (counter >= 5){
                            yellow.cancel();
                        }
                    }
                }, begin_yellow, timeInterval_yellow);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            if (round_about.size() == 0) {
                break;
            }

        }

    }
    
}
