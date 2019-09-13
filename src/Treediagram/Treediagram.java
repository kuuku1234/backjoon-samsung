package Treediagram;

import java.util.Scanner;



public class Treediagram {

	public static void main(String[] args) {
		
		System.out.println("how many(N) node do you want?");
		Scanner input = new Scanner(System.in);
		Tree ho = new Tree(input.nextInt());
		
		System.out.println("plase write down distance and connection data");
		for(int i =0; i<ho.vertex.length; i++) {
			ho.vertex[i] = ho.new Node(i);
		}

		ho.connect(ho);
		
		ho.changetonode(ho.inner);
	
		
		System.out.println("1 node");
		System.out.println(ho.vertex[0].first.name);
		//System.out.println(ho.vertex[0].second.name);
		//System.out.println(ho.vertex[0].third.name);
		
		
		System.out.println("2 node");
		System.out.println(ho.vertex[1].first.name);
		//System.out.println(ho.vertex[1].second.name);
		//System.out.println(ho.vertex[1].third.name);
		
		System.out.println("3 node");
		
		System.out.println(ho.vertex[2].first.name);
		System.out.println(ho.vertex[2].second.name);
	//	System.out.println(ho.vertex[2].third.name);
		
		System.out.println("4 node");
		
		System.out.println(ho.vertex[3].first.name);
		System.out.println(ho.vertex[3].second.name);
		System.out.println(ho.vertex[3].third.name);
		
		System.out.println("5 node");
		
	//	System.out.println(ho.vertex[4].first.name);
		//System.out.println(ho.vertex[4].second.name);
		System.out.println(ho.vertex[4].third.name);
		
		int ans = ho.paththrough(ho);
		System.out.println(ans);
		input.close();
	}

}
