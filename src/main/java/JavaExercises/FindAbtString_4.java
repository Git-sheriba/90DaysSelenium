package JavaExercises;

public class FindAbtString_4 {

	public static void main(String[] args) {
		 String inputStr="1. It is Work from Home  not Work for Home";
		 System.out.println(inputStr.replaceAll("[^0-9]", "").length());
		 System.out.println(inputStr.replaceAll("[^A-Z]", "").length());
		 System.out.println(inputStr.replaceAll("[^a-z]", "").length());
		 System.out.println(inputStr.replaceAll("[\\S]", "").length());
	}

}
