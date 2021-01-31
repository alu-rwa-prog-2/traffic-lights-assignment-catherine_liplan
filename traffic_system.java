// Author: Liplan Lekipising
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class traffic_system {
    public static void main(String[] args){
        // cars in the street - before the traffic lights
        ArrayList<String> before_light = new ArrayList<String>();
        //generate cars
        for (int i = 1; before_light.size() < 100; i++){
            String add_int_str = Integer.toString(i);
            String name = "car" + add_int_str;
            before_light.add(name);

        }

        // cars in my collection which is EQUAL to the cars present in the round about
        ArrayList<String> waiting_cars = new ArrayList<String>();

        // this array will hold the cars after they exit the roundabout/collection
        ArrayList<String> after_light = new ArrayList<String>();

        // create random object to be used
        Random random = new Random();

        // counter for keeping track of cars that have been added to the round about - collection
        Integer added = 0;


        // loop - this adds the cars randomly to the roundabout/collection to await to exit
        System.out.println();
        System.out.println(">Movement Starts<");
        System.out.println();
        while (true){
            String cr = before_light.get(random.nextInt(before_light.size()));   //get a random index to use

            // check if a car has already been moved to the collection/round about
            if (waiting_cars.contains(cr)){
                ;
            }
            else {
                waiting_cars.add(cr);
                added ++;
            }

            // Add only 20 cars at one time to the round about
            if (added == 20){
                System.out.println("20 cars added to the round about");
                System.out.println();
                added = 0;  //reset counter of added
                continue;
            }

            // check if the round about is full - 100 cars
            if (waiting_cars.size() == 100) {
                before_light.clear();
                break;
            }
            


        }

        //red - yellow - green
        while (true){
            //red
            while (true) {
                /*
            The first light is RED. No movement of cars. Lasts for 20 secs/ 20,000 milliseconds.
            */
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
                /*
                Using thread.sleep method to give the scheduler its time to complete >above<. 
                Duration is the same as the current light total duration - red - 20 secs/20,000 milliseconds
                */
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                break;
            }

            //yellow
            while (true) {
                /*
            The second light is YELLOW. 1 car moves every 2 seconds (2000 milliseconds). Lasts for 10 secs/ 10,000 milliseconds.
            */
                Timer yellow = new Timer();
                int begin_yellow = 0;
                int timeInterval_yellow = 2000;  // move cars every 2 secs
                yellow.schedule(new TimerTask() {
                    int counter = 0;
                    @Override
                    public void run() {
                        if (waiting_cars.size() != 0) {
                            System.out.println();
                            System.out.println("YELLOW -> " + waiting_cars.get(waiting_cars.size() - 1) + " exited");
                            after_light.add(waiting_cars.get(waiting_cars.size() - 1));  // add the exited car to outer collection
                            System.out.println();
                            waiting_cars.remove(waiting_cars.size() - 1);  // remove the exited car from round about collection
                            counter++;
                        }
                        else {
                            yellow.cancel();
                        }
    
                        if (counter >= 5){   // only move 5 cars
                            yellow.cancel();
                        }
                    }
                }, begin_yellow, timeInterval_yellow);
                /*
                Using thread.sleep method to give the scheduler its time to complete >above<. 
                Duration is the same as the current light total duration - yellow - 10 secs/10,000 milliseconds
                */
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                break;
            }

            //green
            while (true) {
                /*
            The third light is GREEN. 1 car moves every 1 seconds (1000 milliseconds). Lasts for 30 secs/ 30,000 milliseconds.
            */
                Timer green = new Timer();
                int begin_green = 0;
                int timeInterval_green = 1000;  // move cars every 1 second
                green.schedule(new TimerTask() {
                    int counter = 0;
    
                    @Override
                    public void run() {
                        if (waiting_cars.size() != 0) {
                            System.out.println();
                            System.out.println("GREEN -> " + waiting_cars.get(waiting_cars.size() - 1) + " exited");
                            after_light.add(waiting_cars.get(waiting_cars.size() - 1));  // add the exited car to outer collection
                            System.out.println();
                            waiting_cars.remove(waiting_cars.size() - 1);  // remove the exited car from round about collection
                            counter ++;
                        }
                        else {
                            green.cancel();
                        }
    
                        if (counter >= 30) {  // only move 30 cars
                            green.cancel();
                        }
                    }
                }, begin_green, timeInterval_green);
                /*
                Using thread.sleep method to give the scheduler its time to complete >above<. 
                Duration is the same as the current light total duration - green - 30 secs/30,000 milliseconds
                */
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                break;
            }
        }
        System.out.println(">Movement Stops - ALL cars out of the round about<");

    }
    
}
