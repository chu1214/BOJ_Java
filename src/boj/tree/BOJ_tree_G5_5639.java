package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_tree_G5_5639 {

	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		public void add(int data) {
			if(this.data > data) {
				if(left == null) {
					left = new Node(data);
				} else {
					left.add(data);
				}
			} else {
				if(right == null) {
					right = new Node(data);
				} else {
					right.add(data);
				}
			}
		}
	}
	
	public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.data + "\n");
        }
    }

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int first = Integer.parseInt(br.readLine());
		Node root = new Node(first);
		
		while(br.ready()) {
			int next = Integer.parseInt(br.readLine());
			root.add(next);
		}
		
		postOrder(root);
		
		System.out.println(sb.toString());
	}
}