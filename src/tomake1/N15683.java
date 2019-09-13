package tomake1;
import java.util.Scanner;
import java.util.ArrayList;
public class N15683 {

		static int R;
		static int C;
		static int[][] input;
		static int[] dRow = {0,1,0,-1};
		static int[] dCol = {1,0,-1,-0};
		
		static int c1c1 = 0;
		static int c2c2 = 0;
		static int c3c3 = 0;
		static int c4c4 = 0;
		static int c5c5 = 0;
		
		static int count1 =0;
		static int count2 =0;
		static int count3 =0;
		static int count4 =0;
		static int count5 =0;
	
		static int count11 = count1;
		static int count22 = count2;
		static int count33 = count3;
		static int count44 = count4;
		static int count55 = count5;
		 
		static Pos[] v1 = new Pos[8];
		static Pos[] v2= new Pos[8];
		static Pos[] v3= new Pos[8];
		static Pos[] v4= new Pos[8];
		static Pos[] v5= new Pos[8];
		
		static int[] possible ;
		static int[] inputarray;
		
		static ArrayList al = new ArrayList();
		
		static int answer = 99999;
		
		
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		R = s.nextInt();
		C= s. nextInt();
		input = new int[R][C];
		
		for(int i =0; i<input.length; i++) {
			for(int j= 0; j<input[i].length; j++) {
				input[i][j] = s.nextInt();
			}
		}
		
		fivecamcount(input);
		
		possible = new int[count1+count2+count3+count4+count5];
		
		inputarray = arrinput();
		
		
		dfs(0,0);
		System.out.println(answer);
	}
	
	
	public static int[][] deepCopy(int[][] original, int m,int n) {
	    if (original == null) {
	        return null;
	    }

	    int[][] result = new int[m][n];
	    for (int i = 0; i < original.length; i++) {
	        System.arraycopy(original[i], 0, result[i], 0, original[i].length);
	    }
	    return result;
	}

	public static int[][] deepCopy2(int[][] original, int m, int n){
		if(original == null) {
			return null;
		}
		
		int[][] result = new int[m][n];
		for(int i =0; i<original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0,original[i].length);
		}
		return result;
	}
	
	public static class Pos {
		int x;
		int y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		

		
	}
	
	
	
	public static void fivecamcount(int[][] a) {
		
		
		for(int i =0; i<a.length; i++) {
			for(int j =0; j<a[i].length; j++) {
				if(a[i][j] ==1) {
					
					v1[count1] = new Pos(i,j);
					count1++;
					
				}
				
				if(a[i][j] ==2) {
					v2[count2] = new Pos(i,j);				
					count2++;
				
				}
				

				if(a[i][j] ==3) {
					v3[count3] = new Pos(i,j);					
					count3++;
					
				}
				

				if(a[i][j] ==4) {
					v4[count4] = new Pos(i,j);	
					count4++;
					
				}
				

				if(a[i][j] ==5) {
					v5[count5] = new Pos(i,j);
					count5++;
					
				}
			}
		}
	}
	
	
	public static void dfs(int cur,int count) {
		
		if(count==possible.length) {
			
			letsdothis(inputarray,possible);
			
			/*
			for(int i =0; i<possible.length; i++) {
				System.out.print(possible[i]);
				
			}
			System.out.println();
			*/
			return;
		}
		
		if(inputarray[cur] ==1) {
			for(int i=0; i<4; i++) {
				possible[count] = i;
				dfs(cur+1,count+1);
			}
		}

		if(inputarray[cur] ==2) {
			for(int i =0; i<2; i++) {
				possible[count] = i;
				dfs(cur+1,count+1);
			}
		}


		if(inputarray[cur] ==3) {
			for(int i =0; i<4;i++) {
				possible[count] = i;
				dfs(cur+1, count+1);
			}
		}


		if(inputarray[cur] ==4) {
			for(int i =0; i<4; i++) {
				possible[count] = i;
				dfs(cur+1,count+1);
			}
		}


		if(inputarray[cur] ==5) {
			possible[count] = 0;
			dfs(cur+1,count+1);
		}

				
	}
	
	
	
	
	public static int[] arrinput() {
		int[] answer = new int[count1 +count2+ count3+ count4 + count5];
		int count =0;
		for(int i =0; i<count1; i++) {
			answer[count] = 1;
			count++;
		}
		for(int i =0; i<count2; i++) {
			answer[count] = 2;
			count++;
		}
		for(int i =0; i<count3; i++) {
			answer[count] = 3;
			count++;
		}
		for(int i =0; i<count4; i++) {
			answer[count] = 4;
			count++;
		}
		for(int i =0; i<count5; i++) {
			answer[count] = 5;
			count++;
		}
		return answer;
	}
	
	public static void letsdothis(int[] a ,int[] p) {
	int[][] temp = deepCopy(input,R,C);
	int countt = 0;
	int tempanswer = 0;
	int cs1 = 0;
	int cs2 = 0;
	int cs3 = 0;
	int cs4 = 0;
	int cs5 = 0;
	while(countt != a.length) {
		
		if(a[countt] ==1) {
			
			if(p[countt] ==0) {
				for(int i =1; i<=v1[cs1].x; i++) {
					int newx = v1[cs1].x -i;
					int newy = v1[cs1].y;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -1;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}

			if(p[countt] ==1) {
				for(int i=1; i<C- v1[cs1].y; i++) {
					int newx = v1[cs1].x;
					int newy = v1[cs1].y +i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -1;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}

			}

			if(p[countt] ==2) {
				for(int i =1; i<R-v1[cs1].x; i++) {
					int newx = v1[cs1].x +i;
					int newy = v1[cs1].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -1;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}

			}

			if(p[countt] ==3) {
				for(int i=1; i<=v1[cs1].y; i++) {
					int newx = v1[cs1].x;
					int newy = v1[cs1].y -i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -1;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}

			}

			

			countt++;
			cs1++;
		}

		else if(a[countt] ==2) {
			
			if(p[countt] ==0) {
				for(int i =1; i<=v2[cs2].y; i++) {
					int newx = v2[cs2].x;
					int newy = v2[cs2].y -i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -2;
					}
					if(temp[newx][newy] ==6) {
						break;
					}
				}
				for(int i = 1; i<C-v2[cs2].y; i++) {
					int newx = v2[cs2].x;
					int newy = v2[cs2].y + i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -2;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}

			if(p[countt] ==1) {
				
				for(int i = 1; i<=v2[cs2].x; i++) {
					int newx = v2[cs2].x -i;
					int newy = v2[cs2].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -2;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<R-v2[cs2].x; i++) {
					int newx = v2[cs2].x +i;
					int newy = v2[cs2].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -2;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				
				
			}
			countt++;
			cs2++;
		}


		else if(a[countt] ==3) {
			
			if(p[countt] ==0) {
				for(int i =1;i<=v3[cs3].x; i++) {
					int newx = v3[cs3].x -i;
					int newy = v3[cs3].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<C- v3[cs3].y; i++) {
					int newx = v3[cs3].x;
					int newy = v3[cs3].y +i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}

			if(p[countt] ==1) {
				for(int i =1; i<C- v3[cs3].y; i++) {
					int newx = v3[cs3].x;
					int newy = v3[cs3].y +i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i = 1; i<R-v3[cs3].x; i++) {
					int newx = v3[cs3].x +i;
					int newy = v3[cs3].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}

			if(p[countt] ==2) {
				for(int i = 1; i<R-v3[cs3].x; i++) {
					int newx = v3[cs3].x +i;
					int newy = v3[cs3].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<=v3[cs3].y; i++) {
					int newx = v3[cs3].x;
					int newy = v3[cs3].y -i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}

			if(p[countt] ==3) {
				
				for(int i =1; i<=v3[cs3].y; i++) {
					int newx = v3[cs3].x;
					int newy = v3[cs3].y -i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1;i<=v3[cs3].x; i++) {
					int newx = v3[cs3].x -i;
					int newy = v3[cs3].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -3;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}
			countt++;
			cs3++;
		}


		else if(a[countt] ==4) {

			if(p[countt] == 0) {
				
				for(int i =1; i<=v4[cs4].y; i++) {//4번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y -i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1;i<=v4[cs4].x; i++) {//1번
					int newx = v4[cs4].x -i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<C- v4[cs4].y; i++) {//2번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y +i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				
			}

			if(p[countt] == 1) {
				
				for(int i =1;i<=v4[cs4].x; i++) {//1번
					int newx = v4[cs4].x -i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<C- v4[cs4].y; i++) {//2번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y +i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i = 1; i<R-v4[cs4].x; i++) {//3번
					int newx = v4[cs4].x +i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				
			}

			if(p[countt] == 2) {
				
				for(int i =1; i<C- v4[cs4].y; i++) {//2번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y +i;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i = 1; i<R-v4[cs4].x; i++) {//3번
					int newx = v4[cs4].x +i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<=v4[cs4].y; i++) {//4번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y -i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				
			}

			if(p[countt] == 3) {
				
				for(int i = 1; i<R-v4[cs4].x; i++) {//3번
					int newx = v4[cs4].x +i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1; i<=v4[cs4].y; i++) {//4번
					int newx = v4[cs4].x;
					int newy = v4[cs4].y -i;
					if(temp[newx][newy] ==0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
				for(int i =1;i<=v4[cs4].x; i++) {//1번
					int newx = v4[cs4].x -i;
					int newy = v4[cs4].y;
					if(temp[newx][newy] == 0) {
						temp[newx][newy] = -4;
					}
					if(temp[newx][newy] == 6) {
						break;
					}
				}
			}
			
			countt++;
			cs4++;
		}


		else if(a[countt] ==5) {
			for(int i =1;i<=v5[cs5].x; i++) {//1번
				int newx = v5[cs5].x -i;
				int newy = v5[cs5].y;
				if(temp[newx][newy] == 0) {
					temp[newx][newy] = -5;
				}
				if(temp[newx][newy] == 6) {
					break;
				}
			}
			for(int i =1; i<C- v5[cs5].y; i++) {//2번
				int newx = v5[cs5].x;
				int newy = v5[cs5].y +i;
				if(temp[newx][newy] == 0) {
					temp[newx][newy] = -5;
				}
				if(temp[newx][newy] == 6) {
					break;
				}
			}
			for(int i = 1; i<R-v5[cs5].x; i++) {//3번
				int newx = v5[cs5].x +i;
				int newy = v5[cs5].y;
				if(temp[newx][newy] == 0) {
					temp[newx][newy] = -5;
				}
				if(temp[newx][newy] == 6) {
					break;
				}
			}
			for(int i =1; i<=v5[cs5].y; i++) {//4번
				int newx = v5[cs5].x;
				int newy = v5[cs5].y -i;
				if(temp[newx][newy] ==0) {
					temp[newx][newy] = -5;
				}
				if(temp[newx][newy] == 6) {
					break;
				}
			}
			
			countt++;
			cs5++;
		}

		
		
	}
	
	for(int i =0; i<temp.length; i++) {
		for(int j = 0; j<temp[i].length; j++) {
			if(temp[i][j] == 0) {
				tempanswer++;
			}
		}
	}
	
	if(answer>tempanswer) {
		answer = tempanswer;
	}
	/*
	for(int i =0; i<temp.length; i++) {
		for(int j = 0; j<temp[i].length; j++) {
			System.out.print(temp[i][j]);
		}
		System.out.println();
	}
	*/
	
	
	}
	
	
	
}
