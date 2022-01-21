package backjoon;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;


public class Baek1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] visit = new int[200001];
		
		if (n == k) {
			System.out.println(0);
		}else {
			visit[n] = 1;
			LinkedList<Node> linkedList = new LinkedList<Node>();
			linkedList.add(new Node(n, 1));
			Node lastNode = null;
			mainLoop : while(!linkedList.isEmpty()) {
				Node curNode = linkedList.poll();
				for (int i = 1; i < 4; i++) {
					int cul = search(curNode.point, i);
					if (cul < 0 || cul > 200000) continue; 
					if (visit[cul] == 1) {
						continue;
					}else {
						visit[cul] = 1;						
					}
					if (cul != k) {
						linkedList.add(new Node(cul, curNode.depth+1));
					}
					else {
						lastNode = curNode;
						break mainLoop;
					}
				}
			}
			System.out.println(lastNode.depth);
		}

	}	

	public static int search(int curPoint, int t) {
		switch (t) {
			case 1:
				curPoint = curPoint - 1;
				break;
			case 2:
				curPoint = curPoint + 1;
				break;
			case 3:
				curPoint = curPoint * 2;
				break;
			default :
				break;
		}
		return curPoint;
	}
}
class Node{
	int point;
	int depth;
	public Node(int point, int depth) {
		this.point = point;
		this.depth = depth;
	}
	
}
