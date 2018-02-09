
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes {
    
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        // TO DO
        for(int i=0; i< howMany; i++){
            ret.add(quakeData.get(i));
            
        }
        
        // for each quake in quakeData
        for(QuakeEntry qe:quakeData){
            // Calculate distance between quakeData quake and current location
            Location qeLocation = qe.getLocation();
            float qeDistance = current.distanceTo(qeLocation)/1000 ;
            System.out.println("Distance between quakeData quake and current location: " + qeDistance);
            
            // for each quake in ret
            for(QuakeEntry quake: ret){
                // Calculate distance between ret quake and current location

                Location qeRet = quake.getLocation();
                float retDistance = current.distanceTo(qeRet)/1000 ;
                System.out.println("Distance between ret quake and current location: " + retDistance);
                
                // If quakeData quake is closer than ret quake
                if(qeDistance < retDistance){
                    // replace ret quake with quakeData quake
                    int index = ret.indexOf(quake);
                    ret.remove(index);
                    ret.add(index, qe);
                    
                    System.out.println("retDistance:" + retDistance+ " V.S " + "qeDistance:"+ qeDistance);
                    System.out.println("Added quake to pos " + index);
                    // Check next quakeData quake
                    break;
                }
            }
            
            
        }
        
        System.out.println(ret.size());
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
