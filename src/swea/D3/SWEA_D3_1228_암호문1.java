package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {

	public static class Node {
		public int data;
		public Node link;

		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
	}

	public static class Linkedlist {
		public Node head;

		public Linkedlist() {
			this.head = null;
		}

		public void add(int data) {
			Node newNode = new Node(data, null);
			if (this.head == null) {
				head = newNode;
			} else {
				Node current = this.head;
				while (current.link != null) {
					current = current.link;
				}
				current.link = newNode;
			}
		}

		public void insert(int index, int data) {
			Node newNode = new Node(data, null);

			if (this.head == null) {
				head = newNode;
			} else {
				Node current = head;
				if (index == 0) {
					head = newNode;
					newNode.link = current;
				} else {
					for (int i = 0; i < index - 1; i++) {
						if (current.link == null)
							break;
						current = current.link;
					}
					newNode.link = current.link;
					current.link = newNode;
				}
			}
		}

		@Override
		public String toString() {
			Node current = this.head;
			StringBuilder sb = new StringBuilder();
			int cnt = 10;
			while (cnt-- > 0) {
				sb.append(current.data + " ");
				current = current.link;
			}
			sb.setLength(sb.length() - 1);
			return sb.toString();
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			Linkedlist list = new Linkedlist();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if (st.nextToken().equals("I")) {
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for (int j = X; j < X + Y; j++) {
						list.insert(j, Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.println("#" + t + " " + list.toString());
		}
	}
}