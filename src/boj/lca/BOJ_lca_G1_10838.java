package boj.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_lca_G1_10838 {

	static int N, K;
	static int[][] nodes;

	// 공통 조상 찾기
	public static int lca(int a, int b) {
		// 같으면 종료
		if (a == b)
			return a;

		boolean[] check = new boolean[N];

		// 최단 경로가 1000 이하이므로 각각 1000번만 체크한다.
		// a에서 연산횟수를 최대 10^5 -> 10^3으로 줄일 수 있다.

		// a부터 체크하며 올라간다
		for (int i = 0; i < 1000; i++) {
			// 현재 노드 체크
			check[a] = true;

			// 부모로 올라가기
			a = nodes[a][0];
		}

		// b는 공통 조상을 만나면 리턴
		for (int i = 0; i < 1000; i++) {
			// 이미 방문 된 노드를 만나면 최소 공통 조상이므로 그 노드를 리턴
			if (check[b] == true)
				return b;

			// 부모로 올라가기
			b = nodes[b][0];
		}
		return 0;
	}

	public static void paint(int a, int b, int c) {
		int lca = lca(a, b);

		// a부터 공통 조상까지 색칠
		while (a != lca) {
			nodes[a][1] = c;
			a = nodes[a][0];
		}

		// b부터 공통 조상까지 색칠
		while (b != lca) {
			nodes[b][1] = c;
			b = nodes[b][0];
		}
	}

	public static void move(int a, int b) {
		nodes[a][0] = b;
	}

	public static int count(int a, int b) {
		HashSet<Integer> hs = new HashSet<>();
		int lca = lca(a, b);

		// a부터 공통 조상까지 색 저장
		while (a != lca) {
			hs.add(nodes[a][1]);
			a = nodes[a][0];
		}

		// b부터 공통 조상까지 색 저장
		while (b != lca) {
			hs.add(nodes[b][1]);
			b = nodes[b][0];
		}

		return hs.size();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 0: 부모 번호, 1: 에지 색
		nodes = new int[N][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (r == 1) {
				int c = Integer.parseInt(st.nextToken());
				paint(a, b, c);
			} else if (r == 2)
				move(a, b);
			else
				sb.append(count(a, b) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}