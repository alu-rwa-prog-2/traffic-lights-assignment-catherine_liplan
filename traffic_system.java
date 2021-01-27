import java.util.ArrayList;

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

        // main loop
        while (round_about.size() < 101){
            
        }
    }
}