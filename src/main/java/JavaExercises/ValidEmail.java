package JavaExercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*1. Write a java program to verify whether the given String is valid email address.
Input: "balaji.chandrasekaran@testleaf.com"
output: true

Input: "balaji.c@tunatap.co.uk"
output: true

Input: "naveen e@tl.com"
output: false

Note: Spl characters like . _ are only allowed*/

public class ValidEmail {
	public static void main(String[] args) {
//  String input = "balaji.chandrasekaran@testleaf.com";
//  String patt = "[a-z.]+@[a-z]+.[a-z]{2,3}";
		
//  String input = "balaji.c@tunatap.co.uk";
//  String patt = "[a-z.]+@[a-z]+.[a-z.]{2,}"; 
		
	String input = "naveen e@tl.com";
	String patt = "[a-zA-Z._]+@[a-z]+.[a-z]{2,3}";
	
    Pattern compile = Pattern.compile(patt);
    Matcher matcher = compile.matcher(input);
    System.out.println( matcher.matches());
    
	}
	
	
}

