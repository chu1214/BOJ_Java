package boj.dp;

import java.util.*;

public class BOJ_dp_S3_1463_bfsVer {

	static int[] visited = new int[10000001];
	public static class Number {
		int num;
		int level;

		public Number(int curNum, int level) {
			super();
			this.num = curNum;
			this.level = level;
		}
	}

	public static int bfs(int n) {
		Queue<Number> q = new LinkedList<>();
		Number cur;
		int curNum, curLevel;
		q.add(new Number(n, 0));
		while (!q.isEmpty()) {
			cur = q.poll();
			curNum = cur.num;
			curLevel = cur.level;
			if (curNum != 1) {
				if (curNum % 3 == 0 && visited[curNum / 3] != 1) {
					q.add(new Number(curNum / 3, curLevel + 1));
					visited[curNum / 3] = 1;
				}
				if (curNum % 2 == 0 && visited[curNum / 2] != 1) {
					q.add(new Number(curNum / 2, curLevel + 1));
					visited[curNum / 2] = 1;
				}
				if(visited[curNum - 1] != 1) {
					q.add(new Number(curNum - 1, curLevel + 1));
					visited[curNum - 1] = 1;
				}
			}
			else {
				return curLevel;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(bfs(N));
	}
}