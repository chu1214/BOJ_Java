package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	static int T, N, W, H, ans;
	static int[][] block, test;
	static int[] ballPos;
	static int[] dh = { -1, 1, 0, 0 };
	static int[] dw = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static boolean isFinished;

	public static void check() {
		int cnt = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if (test[h][w] != 0)
					cnt++;
			}
		}
		if (cnt < ans)
			ans = cnt;
	}

	public static void clean() {
		Queue<Integer> q = new ArrayDeque<>();

		for (int w = 0; w < W; w++) {
			for (int h = H - 1; h >= 0; h--) {
				if (test[h][w] != 0) {
					q.offer(test[h][w]);
				}
			}

			for (int h = H - 1; h >= 0; h--) {
				if (!q.isEmpty()) {
					test[h][w] = q.poll();
				} else {
					test[h][w] = 0;
				}
			}
		}
	}

	public static void explode(int sh, int sw) {
		int scnt = test[sh][sw] - 1;
		test[sh][sw] = 0;
		visited[sh][sw] = true;
		for (int d = 0; d < 4; d++) {
			int h = sh;
			int w = sw;
			int cnt = scnt;
			while (cnt-- > 0) {
				int nh = h + dh[d];
				int nw = w + dw[d];
				if (isIn(nh, nw) && !visited[nh][nw] && test[nh][nw] != 0) {
					explode(nh, nw);
				}
				h = nh;
				w = nw;
			}
		}
		visited[sh][sw] = false;
	}

	public static void drop(int w) {
		int sh = -1;
		int sw = w;
		for (int h = 0; h < H; h++) {
			if (test[h][w] != 0) {
				sh = h;
				break;
			}
		}

		if (sh != -1) {
			explode(sh, sw);
		}
	}

	public static void breakBlock(int cnt) {
		if (isFinished)
			return;

		if (cnt == N) {
			test = new int[H][W];
			visited = new boolean[H][W];
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					test[h][w] = block[h][w];
				}
			}
			for (int i = 0; i < N; i++) {
				int pos = ballPos[i];
				drop(pos);
				clean();
			}

			check();
			if (ans == 0)
				isFinished = true;

			return;
		}

		for (int i = 0; i < W; i++) {
			ballPos[cnt] = i;
			breakBlock(cnt + 1);
		}
	}

	public static boolean isIn(int nh, int nw) {
		return nh >= 0 && nh < H && nw >= 0 && nw < W;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			block = new int[H][W];
			ballPos = new int[N];
			ans = Integer.MAX_VALUE;
			isFinished = false;

			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					block[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			breakBlock(0);

			sb.append("#" + t + " " + ans + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}