package proyectozombie.CharacterCreation;
import java.util.ArrayList;
import java.util.HashMap;

public class PFGear {
    private static HashMap<String,Gear> pfGear = new HashMap<>();

   
    public static void addPrototype(String name, Gear gear) {
        pfGear.put(name.toUpperCase().strip(), gear);
    }
    
    public static Gear getPrototype(String gearName){
       return (Gear)pfGear.get(gearName.toUpperCase().strip()).clone();
    }
    
    public static ArrayList<Gear> getPrototypes(ArrayList<String> gearList) {
        ArrayList<Gear> gearChoosen = new ArrayList<Gear>();
        for(int i=0; i<gearList.size(); i++){
            gearChoosen.add((Gear) pfGear.get(gearList.get(i).toUpperCase().strip()).clone());
        }
        return gearChoosen;
    }
    
   

}
