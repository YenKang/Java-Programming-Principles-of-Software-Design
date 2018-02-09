import java.util.*;

/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author (Bryan) 
 * @version (2017-12-8)
 */
public class MarkovWordTwo implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        // markovwordone-> 1
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key = myText[index];
        String key2 = myText[index+1];
        sb.append(key);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key,key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            //  key = next;
            key = key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    private int indexOf(String[] words, String target1,String target2,int start){
        int index = -1;
        for(int k=start;k<words.length-1;k++ ){
            if(words[k].equals(target1) && words[k+1].equals(target2)){
                return k+1;
            }
        }
        return index;
    }
    
    private ArrayList<String> getFollows(String key,String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        //  do to 
        int pos =0;
        while(pos < myText.length){
            int start = indexOf(myText,key,key2, pos);
            if(start == -1){
                break;
            }
            
            if(start + 1>= myText.length-1){
                break;
            }
            
            String next = myText[start+1];
            follows.add(next);
            // key is one character length
            pos = start+key.length();
        }
        return follows;
    }
}
