// Author: Liplan Lekipising
import java.util.ArrayList;
import java.util.Collections;
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

        Collections.shuffle(before_light);

        // cars in my collection which is EQUAL to the cars present in the round about
        ArrayList<String> waiting_cars = new ArrayList<String>();

        // this array will hold the cars after they exit the roundabout/collection
        ArrayList<String> after_light = new ArrayList<String>();


        // counter for keeping track of cars that have been added to the round about - collection


        // loop - this adds the cars randomly to the roundabout/collection to await to exit
        System.out.println();
        System.out.println(">Movement Starts<");
        System.out.println();
        System.out.println(" ---- " + before_light.size() + " cars waiting : " + waiting_cars.size() + " cars in queue : " + after_light.size() + " cars exited");
        System.out.println();

        /*
        The below timer runs every second, it generates 18 cars per second. Only stops after generating 100 cars.
        The cars are generated as soon as the red light is on and continuously added to the queue.
        */
        while (true){
            Timer add_cars = new Timer();
            int begin_add = 0;
            int timeInterval_add = 1000;   // interval
            add_cars.schedule(new TimerTask() {
                int counter = 0;
                @Override
                public void run() {

                    if (before_light.size() == 0) {   // check if all cars got into the queue
                        add_cars.cancel();
                    }
                    else {
                        String cr = before_light.get(0);
                        before_light.remove(0);
                        waiting_cars.add(cr);
                        
                    }
                    counter ++;

                    if (counter == 100){   // maximum number of cars
                        add_cars.cancel();
                    }
                }
            }, begin_add, timeInterval_add);
            //red
                /*
            The first light is RED. No movement of cars. Lasts for 20 secs/ 20,000 milliseconds.
            */
            System.out.println();
            Timer red = new Timer();
            int begin_red = 0;
            int timeInterval_red = 1000;
            red.schedule(new TimerTask() {
                int counter = 0;
                @Override 
                public void run() {   // The below prints out updated scenario each time
                    System.out.println("RED : NO MOVEMENT! " + before_light.size() + " cars waiting : " + waiting_cars.size() + " cars in queue : " + after_light.size() + " cars exited");
                    counter++;
                    

                    if (counter == 20){
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
            
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                System.out.println();
                System.out.println("No more cars");
                System.out.println();
                break;
            }

            //yellow
                /*
            The second light is YELLOW. 1 car moves every 2 seconds (2000 milliseconds). Lasts for 10 secs/ 10,000 milliseconds.
            */
            System.out.println();
            Timer yellow = new Timer();
            int begin_yellow = 0;
            int timeInterval_yellow = 2000;  // move cars every 2 secs
            yellow.schedule(new TimerTask() {
                int counter = 0;
                @Override
                public void run() {
                    if (waiting_cars.size() != 0) {
                        after_light.add(waiting_cars.get(waiting_cars.size() - 1));  // add the exited car to outer collection
                        waiting_cars.remove(waiting_cars.size() - 1);  // remove the exited car from round about collection
                        // The below prints out updated scenario each time
                        System.out.println("YELLOW : " + waiting_cars.get(waiting_cars.size() - 1) + " cars exited : " + before_light.size() + " cars waiting : " + waiting_cars.size() + " cars in queue : " + after_light.size() + " exited");
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
            
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                System.out.println();
                System.out.println("No more cars");
                System.out.println();
                break;
            }

            //green
                /*
            The third light is GREEN. 1 car moves every 1 seconds (1000 milliseconds). Lasts for 30 secs/ 30,000 milliseconds.
            */
            System.out.println();
            Timer green = new Timer();
            int begin_green = 0;
            int timeInterval_green = 1000;  // move cars every 1 second
            green.schedule(new TimerTask() {
                int counter = 0;

                @Override
                public void run() {
                    if (waiting_cars.size() > 0) {
                        after_light.add(waiting_cars.get(waiting_cars.size() - 1));  // add the exited car to outer collection
                        if (waiting_cars.size() == 1) {   // check if we are on the last car
                            // The below prints out updated scenario each time
                            System.out.println("GREEN : " + waiting_cars.get(0) + " cars exited : " + before_light.size() + " cars waiting : 0 cars in queue : " + after_light.size() + " cars exited");
                            waiting_cars.remove(waiting_cars.size() - 1);  // remove the exited car from round about collection
                            green.cancel();
                        }
                        else {
                            waiting_cars.remove(waiting_cars.size() - 1);  // remove the exited car from round about collection
                            // The below prints out updated scenario each time
                            System.out.println("GREEN : " + waiting_cars.get(waiting_cars.size() - 1) + " cars exited : " + before_light.size() + " cars waiting : " + waiting_cars.size() + " cars in queue : " + after_light.size() + " cars exited");
                        }
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
            /*
            This conditional checks we have all cars has exited and breaks if true
            */
            if (waiting_cars.size() == 0) {
                System.out.println();
                System.out.println("No more cars");
                System.out.println();
                break;
            }
        }
        
        System.out.println(">Movement Stops - ALL cars out of the round about<");
        System.out.println();

    }
    
}
