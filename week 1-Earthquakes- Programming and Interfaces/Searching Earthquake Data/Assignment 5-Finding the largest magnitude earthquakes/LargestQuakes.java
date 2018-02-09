
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LargestQuakes {
    /**
    * Reads in earthquake data from a source, stores them into an ArrayList of type QuakeEntry,
    * and prints all the earthquakes and how many. 
    *
    */
    
    
    
    public void findLargestQuake(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("Read " + list.size() + " quakes");
        
        ArrayList<QuakeEntry> listLargest = getLargest(list, 50);
        for(QuakeEntry quake:listLargest){
            System.out.println(quake);
        }
        
    }
    
    /**
     * Returns the index location in data of the earthquake with the largest magnitude
     */
    
    public int indexOfLargest (ArrayList<QuakeEntry> data){
        double magMax =0;
        int index = -1;
        
        for(QuakeEntry qe:data){
            double mag = qe.getMagnitude();
            if(mag > magMax){
                magMax = mag;
                index = data.indexOf(qe);
            }
        }
        
        return index;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> data, int howMany){
        ArrayList<QuakeEntry> dataRemovable = data; 
        ArrayList<QuakeEntry> largest = new ArrayList<QuakeEntry>();
        
        // Until either largest contains howMany elements or data runs out
        while(largest.size() < howMany || dataRemovable.size() == 0){
            int index = indexOfLargest(dataRemovable);
            largest.add(dataRemovable.get(index));
            dataRemovable.remove(index);
        }
        
        return largest;
    }
}
