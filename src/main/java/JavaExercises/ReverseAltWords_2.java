package JavaExercises;

public class ReverseAltWords_2 {
	public static void main(String[] args) {
		String inputString = "When the world realise its own mistake, corona will dissolve automatically";
		StringBuffer sb = new StringBuffer(inputString.length());
		String[] splitStr = inputString.split(" ");
		String[] revStr = new String[splitStr.length]; // Empty array of same size as splitStr array

		for (int i = 0; i < splitStr.length; i++) {
			String rev = "";
			if ((i % 2) != 0) { // check for the odd index and reverse the particular string
				int lengthSubStr = splitStr[i].length();
				for (int j = lengthSubStr - 1; j >= 0; j--) {
					char charAt = splitStr[i].charAt(j);
					rev += charAt; // assign reversed chracter sequence to a string
				}
				revStr[i] = rev; // store it in the empty string array
			} else {
				revStr[i] = splitStr[i];
			}
			sb.append(revStr[i]).append(" ");
		}
		System.out.println("Input String : " + inputString);

		System.out.println("reversed String is : " + sb);
	}
}
