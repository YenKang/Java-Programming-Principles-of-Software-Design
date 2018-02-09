import java.util.*;
import edu.duke.*;

/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel implements IMarkovModel{
    private int keyLength;
    private String myText;
    private Random myRandom;
    
    public MarkovModel(int num) {
        myRandom = new Random();
        keyLength = num;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-keyLength);
        String key = myText.substring(index, index+keyLength);
        sb.append(key);
        
        
        for(int k=0; k < numChars-keyLength; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0){
                break;
            }
            
            index = myRandom.nextInt(follows.size());
            String successor = follows.get(index);
            sb.append(successor);
            key = key.substring(key.length()-(keyLength-1)) + successor;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        int pos =0;
        while(true){
            int index = myText.indexOf(key,pos);
            int indexOfSuccessor = index + key.length();
            
            if(index == -1 || indexOfSuccessor >= myText.length()){
                break;
            }
            
            String successor = myText.substring(indexOfSuccessor,indexOfSuccessor+1);
            follows.add(successor);
            // key is one character length
            pos = index+1;
        }
        return follows;
    }
}
