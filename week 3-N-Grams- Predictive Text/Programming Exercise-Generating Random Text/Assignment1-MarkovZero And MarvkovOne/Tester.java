import edu.duke.*;
import java.util.*;

/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public void testGetFollows(){
        MarkovOne markov = new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = markov.getFollows("t");
        System.out.println(follows);
    }
    
    public void testGetFollowsWithFile(){
        MarkovOne markov = new MarkovOne();
        FileResource fr = new FileResource();
        
        String frStr = fr.asString().replace('\n', ' ');
        markov.setTraining(frStr);
        ArrayList<String> follows = markov.getFollows("t");
        System.out.println(follows.size());
        
    }
}
