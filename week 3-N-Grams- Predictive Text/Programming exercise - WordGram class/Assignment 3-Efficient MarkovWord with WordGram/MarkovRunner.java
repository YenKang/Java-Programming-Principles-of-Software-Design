
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        //MarkovWordOne markovWord = new MarkovWordOne(); 
        MarkovWord m3 = new MarkovWord(3);
        runModel(m3,st,20,643);
        //runModel(markovWord, st, 200); 
    } 

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    }
    
    public void testHashMap(){
       String st = "this is a test yes this is really a test yes a test this is wow";
       //String st = "this is a test yes this is really a test";
       EfficientMarkovWord em2 = new EfficientMarkovWord(2);
       runModel(em2, st, 50, 42);
    }
    
    public void compareMethods(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        
        EfficientMarkovWord em2 = new EfficientMarkovWord(2);
        long startTime = System.nanoTime();
        runModel(em2,st,100,42);
        
        long endTime = System.nanoTime();
        long timeElasped = (endTime-startTime);
        System.out.println("Seconds the run took: " + timeElasped/1000000000.0);
        
        // MarkovWord v.s EfficientMarkovWord
        MarkovWord m2 = new MarkovWord(2);
        long startTime2 = System.nanoTime();
        runModel(m2, st, 100, 42);
        long endTime2 = System.nanoTime();
        
        long timeElapsed2 = (endTime2 - startTime2);
        System.out.println("Seconds the run took: " + timeElapsed2/1000000000.0);
        
        

        
        
        
        
        
        
        
    }

}
