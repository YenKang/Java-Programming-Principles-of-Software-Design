
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import java.util.*;


public class MarkovRunner {
    public void runMarkovZero() {
        // read in a file the user choose
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// create a Markov object
		MarkovZero markov = new MarkovZero();
		
		markov.setTraining(st);
		// markov.setRandom(101);
		markov.setRandom(88);
		
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
		markov.setRandom(273);
		// print out three random texts
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovFour() {
        // read in a file the user choose
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// create a Markov object
		MarkovFour markov = new MarkovFour();
		
		markov.setTraining(st);
		// set the random seed with 25
		markov.setRandom(371);
		// print out three random texts
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	public void runMarkovModel() {
        // read in a file the user choose
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// create a Markov object
		MarkovModel markov = new MarkovModel(8);
		
		markov.setTraining(st);
		// set the random seed with 38
		markov.setRandom(365);
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
