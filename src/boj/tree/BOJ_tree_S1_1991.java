package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_tree_S1_1991 {

	public static class Node {
		private int data; //노드의 값
		private Node leftNode; //왼쪽 자식노드의 값
		private Node rightNode; //오른쪽 자식노드의 값
		public Node(int data) {
		this.data = data;
		}
		
		public int getData() {return data;}
		public void setData(int data) {this.data = data;}
		public void setLeftNode(Node node) {this.leftNode = node;}
		public void setRightNode(Node node) { this.rightNode = node;}
		public Node getLeftNode() { return this.leftNode;}
		public Node getRightNode() { return this.rightNode; }
		}
	
	public static class Tree{
		public Node root;
		
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) {
				root = new Node(data);
	            root.leftNode = leftData != '.' ? new Node(leftData) : null;
	            root.rightNode = rightData != '.' ? new Node(rightData) : null;
			}
			else {
	            searchNode(root, data, leftData, rightData);
	        }	
		}
		public void searchNode(Node node, char data, char leftData, char rightData) {
	        if(node == null) {
	            return;
	        }else if(node.data == data) {
	            node.leftNode = leftData != '.' ? new Node(leftData) : null;
	            node.rightNode = rightData != '.' ? new Node(rightData) : null;
	        }else {
	            searchNode(node.leftNode, data, leftData, rightData);  // 오른쪽 재귀 탐색
	            searchNode(node.rightNode, data, leftData, rightData);  // 왼쪽 재귀 탐색
	        }
	    }

	    // 전위순회 Preorder : Root -> Left -> Right
	    public void preOrder(Node node) {
	        if(node != null) {
	            System.out.print((char)node.data);
	            if(node.leftNode != null) {preOrder(node.leftNode);}
	            if(node.rightNode != null) {preOrder(node.rightNode);}
	        }
	    }

	    // 중위순회 Inorder : Left -> Root -> Right
	    public void inOrder(Node node) {
	        if(node != null) {
	            if(node.leftNode != null) {inOrder(node.leftNode);}
	            System.out.print((char)node.data);
	            if(node.rightNode != null) {inOrder(node.rightNode);}
	        }
	    }

	    // 후위순회 Postorder : Left -> Right -> Root
	    public void postOrder(Node node) {
	        if(node != null) {
	            if(node.leftNode != null) {postOrder(node.leftNode);}
	            if(node.rightNode != null) {postOrder(node.rightNode);}
	            System.out.print((char)node.data);
	        }
	    }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.createNode(root, left, right);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);

        br.close();
	}
}