package JavaExercises;
// aadded a comment for testing the git
// This just prints the reversed string. But is not stored anywhere in a variable to be used later.
public class Trial {
	public static void main(String[] args) {
		String inputString = "When the world realise its own mistake, corona will dissolve automatically";
		String[] splitStr = inputString.split(" ");
		String[] revStr = new String[splitStr.length]; // Empty array of same size as splitStr array
		
		for (int i = 0; i < splitStr.length; i++) {
			String rev="";
			if ((i%2)!=0) {    // check for the odd index and reverse the particular string
				int lengthSubStr = splitStr[i].length();
				for (int j = lengthSubStr-1; j >=0; j--) {
					System.out.print(splitStr[i].charAt(j));
				}
			}
			else {
				System.out.print(splitStr[i]);
			}
			System.out.print(" ");
		}
		System.out.println(" ");
		System.out.println("Input String : "+inputString);
		
	}
}
/*Write a java program to find the count the characters in the given string
String str = "Karma is powerful than God"
{K=1, a=3, r=2, m=1,  =4, i=1, s=1, p=1, o=2, w=1, e=1, f=1, u=1, l=1, t=1, h=1, n=1, G=1, d=1}*/

