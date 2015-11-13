/*Given a hashtag string which can contain possible words from a doctionary.
 * Read the string and give all possible outputs.
 * say awesome will give awe-some and awesome.
 * each subsrting should be a valid word.*/
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BreakHashTag {

	static Map<String, String> dict = new HashMap<>();
	static String input = "niceawesomeview";
//	static String input = "viewsome";
	static boolean found = false;
	
	public static void main(String[] args) {
		init(dict);	
		java.util.List<String> out = new ArrayList<>();
		findWords(0, out);
	}
	
	static void init(Map<String, String> dict) {
		dict.put("very", "very_value");
		dict.put("nice", "nice_value");
		dict.put("awesome", "1");
		dict.put("awe", "1");
		dict.put("some", "some");
		dict.put("view", "2");
		dict.put("at", "3");
		dict.put("golden","4");
		dict.put("gate", "5");
	}
	
	static void findWords(int start, java.util.List<String> out) {
		boolean found = false;
		String temp = "";
		 for(int i = start; i < input.length(); i++) {
			 temp += Character.toString(input.charAt(i));
			if(dict.containsKey(temp)) {
				out.add(input.substring(start, i + 1));
				findWords(i + 1, out);
				out.remove(out.size() - 1);
				out.remove(out.size() - 1);
				
			}
			else {
				//This case will come in case where string is valida. Here valid is present in dict.
				//character a makes the complete string invalid. 
				//So it checks if the string end has been reached and it comes in the case 
				//where it is not present in the dict map, then show error.
				if((i == input.length() - 1) ) {
					if((!out.isEmpty()) && !found) {
						System.out.println("Part of the string matched. But could not match completely. Error!");
					}
					else {
						System.out.println("Invalid string input");
					}
				}
			}
		}
		 // Now print the vector here after one iteration is over for the string parsing.
		 // After the for loop ends for a string, all the possible words are captured in the vector 
		 //Print all the possible words from the vector which are found.
		 found = true;
	}

}
