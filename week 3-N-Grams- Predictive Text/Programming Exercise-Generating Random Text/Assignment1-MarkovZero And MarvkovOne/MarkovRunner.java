
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
    public void runMarkovZero() {
        // read in a file the user choose
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// create a Markov object
		MarkovZero markov = new MarkovZero();
		
		markov.setTraining(st);
		markov.setRandom(101);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	public void runMarkovOne() {
        // read in a file the user choose
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// create a Markov object
		MarkovOne markov = new MarkovOne();
		
		markov.setTraining(st);
		markov.setRandom(42);
		// print out three random texts
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
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
	
}
