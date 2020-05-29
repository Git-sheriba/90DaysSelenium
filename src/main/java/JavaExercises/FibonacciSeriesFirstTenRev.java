package JavaExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//2. Print the first 10 fibonacci numbers in reverse order
//output: 34,21,13,8,5,3,2,1,1,0
public class FibonacciSeriesFirstTenRev {

	public void usingList() {
		int a = -1, b = 1, c = 0;

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			c = a + b;
			a = b;
			b = c;
			list.add(c);
		}
		Collections.reverse(list);
		String string = list.toString();
		System.out.println("list:" + list);
	}
	
	public void usingArray() {
		int a = -1, b = 1, c = 0;
		int array[] = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = a + b;
			a = b;
			b = array[i];
		}
	//	System.out.println(Arrays.toString(array));
		
		for (int i = array.length-1; i >=0 ; i--) {
			System.out.print(array[i]+",");
		}
		
	}
	
	public static void main(String[] args) {
		FibonacciSeriesFirstTenRev obj = new FibonacciSeriesFirstTenRev();
		obj.usingList();
		obj.usingArray();
		
	}

}
