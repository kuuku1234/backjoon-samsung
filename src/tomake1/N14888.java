package tomake1;
import java.util.Scanner;

class N14888 {
		
		static int N;
		static int[] operand;
		static int[] operator = new int[4];
		static int[] visit;
		static int[] cal;
		static int[] temp;
		static int[] temp2;
		static int size = 0;

		static int count0;
		static int count1;
		static int count2;
		static int count3;
		
		static int small =1000000000;
		static int big = -100000000;
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		operand = new int[N];
		for(int i =0; i<N; i++) {
			operand[i] = s.nextInt();
		}
		for(int i =0; i<4; i++) {
			operator[i] = s.nextInt();
			
		}
		count0 = operator[0];
		count1 = operator[1];
		count2 = operator[2];
		count3 = operator[3];
		for(int i =0; i<4; i++) {
			size +=operator[i];
		}
		
		temp = new int[size];
		dfs(0);

		
		temp2 = new int[size];
		cal = new int[N+temp2.length];
		visit = new int[size];
		variation(0);
		System.out.println(big);
		System.out.println(small);
	}
		
	
	
	
	public static void dfs(int count) {
		
		
		if(count == size) {
			return;
		}
		
		
		if(count0>0) {
			for(int i =0; i<operator[0]; i++) {
				temp[count] = 0;
				count0--;
				dfs(count+1);
			}
			
		}
		if(count1>0) {
			for(int i =0; i<operator[1]; i++) {
				temp[count] = 1;
				count1--;
				dfs(count+1);
			}
		}
		if(count2>0) {
			for(int i =0; i<operator[2]; i++) {
				temp[count] = 2;
				count2--;
				dfs(count+1);
			}
		}
		if(count3>0) {
			for(int i =0; i<operator[3]; i++) {
				temp[count] = 3;
				count3--;
				dfs(count+1);
			}
		}

	}
	
	public static void variation( int count) {
		
		
		if(count == size) {
			calin();
			int a = answer();
			if(a<small) {
				small = a;
			}
			if(a>big) {
				big = a;
			}
			return;
		}
		
		else {
			
			for(int i =0; i<size; i++) {
				if(visit[i] ==0) {
				temp2[count] = temp[i];
				visit[i] = 1;
				variation(count+1);
				visit[i] = 0;
		
				}
			}
		
		}
		
		
	}
	
	public static void calin() {
		int c1 =0;
		int c2 =0;
		for(int i = 0; i<cal.length; i++) {
			if(i%2==0) {
				cal[i] = operand[c1];
				c1++;
			}
			else {
				cal[i] = temp2[c2];
				c2++;
			}
		}
	}
	
	public static int answer() {
		int fake =0;
		for(int i =0; i<cal.length; i++) {
			
		if(i == 1) {	
			if(cal[i] == 0) {
				fake = cal[0]+cal[2];
			}
			if(cal[i] == 1) {
				fake = cal[0]-cal[2];
			}
			if(cal[i] == 2) {
				fake = cal[0]*cal[2];
			}
			if(cal[i] == 3) {
				fake = cal[0]/cal[2];
			}
		}
			
			
		else if(i%2 ==1) {
				if(cal[i] == 0) {
					 fake = fake+ cal[i+1];
				}
				if(cal[i] == 1) {
					fake = fake- cal[i+1];
				}
				if(cal[i] == 2) {
					fake = fake* cal[i+1];
				}
				if(cal[i] == 3) {
					fake = fake/ cal[i+1];
				}
			}
		}
		return fake;
	}
}
