package tomake1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Hmmmm {
	
	

	static int[] answer = new int[1000001];
	public static void cal(ArrayList<Integer>[] a, int value) {
	
		Iterator <Integer>itr= a[value].iterator();
		
		while(itr.hasNext()) {
			int d = itr.next();
		if(answer[d] ==0) {
			if(!(d ==value) || !(d==1)) {

				answer[d] = value;
					cal(a,d);	
			}
		}
	}
	
	}
	public static void main(String[] args) {
		
		
		
		Scanner s = new Scanner(System.in);
		String y = s.nextLine();
		int x = Integer.parseInt(y);
		ArrayList<Integer>[] array2 = new ArrayList[x+1];
		String[] array = new String[x];
		for (int i =0; i<x+1; i++) {
			array2[i] = new ArrayList<Integer>();
		}
		
		
		
		for(int i =0; i<array.length-1; i++) {
			array[i] = s.nextLine();
			
		}
	
		for(int i= 0; i<array.length-1; i++) {
			
			String[] words = array[i].split("\\s");
			
			array2[Integer.parseInt(words[0])].add(Integer.parseInt(words[1]));
			
			array2[Integer.parseInt(words[1])].add(Integer.parseInt(words[0]));

			}
		
	
		cal(array2,1);
		
		for(int i = 2; i<x+1; i++) {
			if(answer[i] !=0) {
			System.out.println(answer[i]);
			}
	}
	
		
		
		
	}
	

}		
		
	

