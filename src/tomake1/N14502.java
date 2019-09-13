package tomake1;
import java.util.Scanner;
import java.util.*;


public class N14502 {


	static int m;
	static int n;
	static int[][] input;
	static int[][] visit;
	static int[] dRow = {0,1,0,-1};
	static int[] dCol = {1,0,-1,0};
	static Position[] zeros = new Position[64];
	static int size =0;
	
	public static void main(String[] args) {

		 Scanner s = new Scanner(System.in);
		 m= s.nextInt();
		 n = s.nextInt();
		
		 input = new int[m][n];
		 visit = new int[m][n];
		
		for(int i =0; i<m; i++) {
			for(int j= 0; j<n; j++) {
				input[i][j] = s.nextInt();
				
			}
		}
		
		sorting();
		/*Position start = new Position(1,5);
		int[][] temp = virus(start);
		
		for(int iii =0; iii<m; iii++) {
			System.out.println();
			for(int jjj=0; jjj<n; jjj++) {
				System.out.print(temp[iii][jjj] + " ");
			}
		}*/
		
		/*for(int i =0; i<size; i++) {
		System.out.println(zeros[i].x +" " + zeros[i].y );
		}*/
		
		System.out.println(build());
	
	}
	

	public static class Position {
		int x;
		int y;
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		

		
	}
	
	public static int[][] virus(Position a, int[][] tempa) {
		int [][]temp =deepCopy(tempa,m,n);
		int [][]visit2 = deepCopy(visit,m,n);
		int newx = 0;
		int newy = 0;
		Queue q = new LinkedList();
		q.offer(a);

		while(!q.isEmpty()) {
			Position s = (Position) q.poll();
			visit2[s.x][s.y]  = 1;
			temp[s.x][s.y] = 2;
			for(int i = 0; i<4; i++) {
				newx = s.x + dRow[i];
				newy = s.y + dCol[i];
				if(0<=newx && newx<m &&0<=newy && newy<n ) {
					if(visit2[newx][newy] ==0 && temp[newx][newy] == 0) {
					
						Position r = new Position(newx,newy);
						q.offer(r);
					}
				}
				
				
			}
			
			
		}
		return temp;
		
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
	
	public static int build() {
		
		int[][]temp = deepCopy(input,m,n);
		
		
	
		int count = 0;
		int answer = 0;
		
		
		
		for(int i =0; i<size-2; i++) {
			for(int j= i+1; j<size-1; j++) {
				for(int k = j+1; k<size; k++) {
					
					temp[zeros[i].x][zeros[i].y] = 1;
					temp[zeros[j].x][zeros[j].y] = 1;
					temp[zeros[k].x][zeros[k].y] = 1;
					
					/*
					for(int iii =0; iii<m; iii++) {
						System.out.println();
						for(int jjj=0; jjj<n; jjj++) {
							System.out.print(temp[iii][jjj] + " ");
						}
					}
					*/
				
				for(int ii =0; ii<m; ii++ ) {
					for(int jj =0; jj<n; jj++) {
						if(temp[ii][jj] ==2) {
							Position x = new Position(ii,jj);
							temp = virus(x,temp);
						}
					}
				}
				/*
				System.out.println("virus");
				for(int iii =0; iii<m; iii++) {
					System.out.println();
					for(int jjj=0; jjj<n; jjj++) {
						System.out.print(temp[iii][jjj] + " ");
					}
				}
				*/
				
				
				for(int iii =0; iii<m; iii++) {
					for(int jjj=0; jjj<n; jjj++) {
						if(temp[iii][jjj] ==0) {
							count++;
						}
					}
				}
				if(answer<count) {
					answer = count;
				}
				
				
				
					
				temp = deepCopy(input,m,n);
				count = 0;
				
				}
				
			}
		}
		return answer;
		
		
		
		
	}
	
	
	public static void sorting() {
		Position[] temp = zeros;
		for(int i =0; i<m; i++) {
			for(int j= 0; j<n; j++) {
				if(input[i][j] ==0) {
					Position z = new Position(i,j);
					temp[size] = z;
					size++;
				}
			}
		}
		zeros = temp;
	}
}
