package JavaExercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsername {
	
/*2. Write a java program to validate the given username is valid or not
 * 
	Input: "Balaji_1"
	output: false
	
	Input: "Testleaf$123"
	output: false
*/
	public static void main(String[] args) {
String input = 	"Balaji1";
String patt  =  "[a-zA-Z0-9]{5,}";

Pattern compile = Pattern.compile(input);
Matcher matcher = compile.matcher(patt);
System.out.println(matcher.matches());

	}
}
