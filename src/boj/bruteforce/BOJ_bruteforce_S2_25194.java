package boj.bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bruteforce_S2_25194 {

	static int N;
	static int[] numCnt;
	static int[][] patterns;
	static boolean able = false;

	public static void make(int num, int sum) {
		if (num == 8) {
			if (sum % 7 == 4) {
				able = true;
			}
			return;
		}

		for (int i = 0; i <= numCnt[num]; i++) {
			make(num + 1, sum + patterns[num][i]);
			if (able)
				return;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		patterns = new int[8][9];
		numCnt = new int[8];

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 8; j++) {
				patterns[i][j] = (i * j) % 7;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			num %= 7;
			if (numCnt[num] < 7) {
				numCnt[num]++;
			}
		}

		make(1, 0);

		if (able) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
