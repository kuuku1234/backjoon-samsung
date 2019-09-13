package tomake1;

public class Treeofone {

	
	Node root;
	int count =0;
	int answer =0;
	class Node{
		
		Node first =null;
		Node second =null;
		Node third =null;
		Node parent = null;
		int data;
		
		public Node() {
			
		}
		public Node(int data) {
			this.data = data;
		}
	}
	
	public int create(Treeofone b,Node a) {
		
			
			if(a.data == 1) {
				a = a.parent;
				if(answer>count) {
					answer = count;
				}
				return answer;
			}
		if(a.data %3 ==0) {
			
			a.first = new Node(a.data/3);
			a.first.parent = a;
			System.out.println(a.first.data);
			count++;
			create(b,a.first);
			count--;
		}
		if(a.data %2 ==0) {
		
			a.second = new Node(a.data/2);
			a.second.parent = a;
			System.out.println(a.second.data);
			count++;
			create(b,a.second);
			count--;
		}
			
		a.third = new Node(a.data-1);
		a.third.parent = a;
		System.out.println(a.third.data);
		count++;
		create(b,a.third);
		count--;
		return answer;
		}
		

	
	public int travel(Treeofone b ,Node a) {
		
		if(a.data == 1) {
			a = a.parent;
			if(answer>count) {
				answer = count;
			}
			return answer;
		}
		if(a.first != null) {
			a = a.first;
			count++;
			travel(b,a);
			count--;
		}
		if(a.second != null) {
			a = a.second;
			count++;
			travel(b,a);
			count--;
		}
		if(a.third != null) {
			a =a.third;
			count++;
			travel(b,a);
			count--;
		}
		return answer;
	}
	
	
	
}
