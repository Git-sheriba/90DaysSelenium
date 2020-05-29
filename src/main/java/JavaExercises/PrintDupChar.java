package JavaExercises;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//1. Write a java program to print the duplicate character using Collections Framework.
//Input: "When life gives you lemons, make lemonade"
public class PrintDupChar {

	public void printDupCha(String str) {

		char[] charArray = str.toCharArray();
		System.out.println("Output using array comparison");
		System.out.println("*****************************");
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					System.out.print(charArray[i]);
					break;
				}
			}
		}
	}

	public void printDupList(String str) {
		char[] charArray = str.toCharArray();
		List<Character> noDupList = new ArrayList<Character>();
		List<Character> dupList = new ArrayList<Character>();

		for (int i = 0; i < charArray.length; i++) {
			if (!noDupList.contains(charArray[i])) {
				noDupList.add(charArray[i]);
			} 
			else // To add the duplicated character without repitition
			if (!dupList.contains(charArray[i])) {
				dupList.add(charArray[i]);
			}
		}
		String stringDup = dupList.toString();
		System.out.println("\n \nUsing List");
		System.out.println("**********");
		System.out.println("Duplicated characters are : ");
		System.out.println(stringDup);
	}
	
	public void printDupSet(String str) {
		char[] charArray = str.toCharArray();
		Set<Character> NoDupSet = new LinkedHashSet<Character>();
		Set<Character> dupSet = new LinkedHashSet<Character>();
		System.out.println("\n \nUsing Set");
		System.out.println("**********");
		System.out.println("Duplicated characters are : ");
		for (int i = 0; i < charArray.length; i++) {
			if(!NoDupSet.add(charArray[i])) {
				dupSet.add(charArray[i]);
				//System.out.println(charArray[i]);
			}
		}
		String stringDup = dupSet.toString();
		System.out.println(stringDup);
	}

	public static void main(String[] args) {
		String str = "When life gives you lemons, make lemonade";
		PrintDupChar dup = new PrintDupChar();
		System.out.println("Input String : " + "\n" + str + "\n");
		dup.printDupCha(str);
		dup.printDupList(str);
		dup.printDupSet(str);
	}
}
