package MyCodes;

public class trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Rs. 2,974.00";
		String price = s.replaceAll("\\D", "");
		System.out.println(price);
		
		String str1 = s.replaceAll("Rs.", "");
		System.out.println(str1);
		String str2 = str1.replaceAll(",", "");
		System.out.println(str2);
		Double.parseDouble(str2);
		
		int num = 2974;
		int diff = (int) (num-Double.parseDouble(str2));
		System.out.println(diff);
	}

}
