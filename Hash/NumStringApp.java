

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumStringApp {

	public static void main(String[] args) {
		// Create map
		Map<String, String> pairs = new HashMap<String, String>();

		// Set up file reading
		String fname = "numbers.txt";       // input file of text
		FileReader fin = null;
		//can throw exception
		//must handle
		//is this a checked or unchecked exception?
		try {
			fin = new FileReader(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner info = new Scanner(fin);
		info.useDelimiter("[#\\n\\r]");  // delimiters are # signs, line feeds,
		// carriage returns

		// Reads the key/value pairs from the file and puts them into the map
		String key, value;

		ArrayList<String> fileLines = new ArrayList<>();
		while (info.hasNext())      
		{
			
			pairs.put(info.next(), info.next());
			info.next();
			
		}
		

		//Prompt user to enter number
		//Display the English written version of that number
		//Eg. User enters 4 program display four

				

	}

}

