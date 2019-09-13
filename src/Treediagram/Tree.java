package Treediagram;

import java.util.Scanner;

public class Tree {// Tree instance�� �����ϸ� ó�� ��� ��带 ���� �Ұ��ΰ� �� �����ȴ�. �״����� �ݺ����� ���� �׸�ŭ �뵵�� �������ش� ������ ��쿣 5��
	
	int numberofnode;
	int temp[] = new int[10];
	int inner[][];
	Node vertex[];
	Tree(int n){
		this.inner = new int[n][n];
		this.numberofnode = n;
		this.vertex = new Node[n];
	}
	int sum = 0;
	int compare =0;

	public class Node{
		int name;
		int visited = 0;
		int firstlength =0;
		int secondlength =0;
		int thirdlength =0;
		Node first;
		Node second;
		Node third;
		
		Node(int i) {
			this.name = i+1;
			this.first = null;
			this.second = null;
			this.third = null;
		}
	}
	// path�Լ����� ��� ������ path�� DFS BFS�� ã���鼭 ���ذ���  �̰��� �ִ밪�� ��� ���ϸ鼭 ã�ư���
	
	public void connect(Tree t) {
		
	for(int k = 0; k<numberofnode; k++) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i = 0;

		while(	true) {
				temp[i] = input.nextInt();
				if(temp[i] == -1) {
					break;
				}
				
				
				i++;
				
		
			}
			for(int m = 1; m<i; m = m+2) {
				int index =0;
				index = temp[m];
				inner[k][index-1] = temp[m+1];// matrix �ȿ��� ����� ���� 0 ����ũ�� ��� ���� �Ÿ��� ��������
			}
	}
		
	}




	public void changetonode(int[][] a) {
		
		for(int k =0; k<a.length; k++) {
				
			for(int i = 0; i<a[k].length; i++) {
				
				if(a[k][i]>0) {// matrix�߿��� 0�̻��� �͵��� �� ����Ǿ��ְ� �Ÿ��� ǥ�õǾ��ִ�. vertex�߿� ���� ������� ���� e  ã�� �Ŀ� vertex[k]�� �ִ³𿡰� ������ ���ش� first second third�������
					for(int e = 0; e<vertex.length; e++) {
						if(vertex[e].name == i+1 && vertex[k].first == null &&vertex[e].first == null ) {
						
							vertex[k].first = vertex[e];
							vertex[e].first = vertex[k];
							vertex[k].firstlength = a[k][i];
							vertex[e].firstlength = a[k][i];
							System.out.println("1������");
							
							continue;
						}
						
						if(vertex[e].name == i+1 && vertex[k].second == null &&vertex[e].second == null) {
							
							vertex[k].second = vertex[e];
							vertex[e].second = vertex[k];
							
							if(vertex[k].second == vertex[k].first) {
								
								vertex[k].second = null;
								vertex[e].second = null;
								continue;
							}
							vertex[k].secondlength = a[k][i];
							vertex[e].secondlength = a[k][i];
							System.out.println("2������");
							continue;
						}
						if(vertex[e].name == i+1 && vertex[k].third == null &&vertex[e].third == null) {
							
							vertex[k].third = vertex[e];
							vertex[e].third = vertex[k];
							
							if(vertex[k].third == vertex[k].first || vertex[k].third == vertex[k].second) {
								
								vertex[k].third = null;
								vertex[e].third = null;
								continue;
							}
							vertex[k].thirdlength= a[k][i];
							vertex[e].thirdlength = a[k][i];
							System.out.println("3������");
							
						}
						
					}
				}
			}
		}
	}

	public int paththrough(Tree a) {
		int answer = 0;
		Node curr;
		for(int i = 0; i<a.vertex.length; i++) {
				curr = vertex[i];
				curr.visited = 1;
				answer = visiting(curr);
				initiaite(curr);
			}
		return answer;	
	}
	
	public int visiting(Node a) {
		
		Node cur = a;
		if(cur.first != null &&  cur.second == null && cur.third == null) {
			
			if(cur.first.visited == 1) {
				return sum;
			}
		}
		if(cur.first == null &&  cur.second != null && cur.third == null) {
			
			if(cur.second.visited == 1) {
				return sum;
			}
		}
		if(cur.first == null &&  cur.second == null && cur.third != null) {
			
			if(cur.third.visited == 1) {
				return sum;
			}
		}
		
		if(cur.first != null && cur.first.visited ==0) {
			compare  = compare +cur.firstlength;
			if(sum<compare) {
				sum = compare;
			}
			cur = cur.first;
			cur.visited = 1;
			visiting(cur);
			compare = compare -cur.firstlength;// ���ٰ� ���ƿ��� ������ �����¡ ����?
			cur = cur.first;
		}
		if(cur.second != null && cur.second.visited ==0) {
			compare = compare + cur.secondlength;
			if(sum<compare) {
				sum = compare;
			}
			cur = cur.second;
			cur.visited = 1;
			visiting(cur);
			compare =compare- cur.secondlength;
			cur = cur.second;
		}
		if(cur.third != null && cur.third.visited ==0) {
			compare += cur.thirdlength;
			if(sum<compare) {
				sum = compare;
			}
			cur = cur.third;
			cur.visited = 1;
			visiting(cur);
			compare =compare- cur.thirdlength;
			cur = cur.third;
		}
		return sum;
		
	}

public void initiaite(Node a) {
		
		Node cur = a;
		if(cur.first != null &&  cur.second == null && cur.third == null) {
			
			if(cur.first.visited == 0) {
				return;
			}
		}
		if(cur.first == null &&  cur.second != null && cur.third == null) {
			
			if(cur.second.visited == 0) {
				return;
			}
		}
		if(cur.first == null &&  cur.second == null && cur.third != null) {
			
			if(cur.third.visited == 0) {
				return;
			}
		}
		
		if(cur.first != null && cur.first.visited ==1) {
			
			cur = cur.first;
			cur.visited = 0;
			visiting(cur);
			cur = cur.first;
		}
		if(cur.second != null && cur.second.visited ==1) {
			
			cur = cur.second;
			cur.visited = 0;
			visiting(cur);
			cur = cur.second;
		}
		if(cur.third != null && cur.third.visited ==1) {
			compare += cur.thirdlength;
			if(sum<compare) {
				sum = compare;
			}
			cur = cur.third;
			cur.visited = 0;
			visiting(cur);
			cur = cur.third;
		}
		return;
		
	}
		}