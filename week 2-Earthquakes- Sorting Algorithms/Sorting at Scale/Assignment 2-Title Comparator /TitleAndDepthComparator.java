
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class TitleAndDepthComparator implements Comparator <QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
   
        String q1Title = q1.getInfo();
        String q2Title = q2.getInfo();
      
        int value = q1Title.compareTo(q2Title);
      
        
        if(value == 0){
           value = Double.compare(q1.getDepth(), q2.getDepth());
        }
        
        return value;
    }
    

}
