package boj.recursive;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_recursive_S1_1497 {

	static int N, M;
	static int[] music;
	static String[] guitar;
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		guitar = new String[N];
		music = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			guitar[i] = st.nextToken();
		}

		playingMusic(0, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static void playingMusic(int cnt, int guitarCnt) {
		if (cnt == N) {
			int musicCnt = 0;
			for (int i = 0; i < M; i++) {
				if (music[i] > 0)
					musicCnt++;
			}
			if (musicCnt != 0 && musicCnt == max) {
				if (min > guitarCnt)
					min = guitarCnt;
			} else if (musicCnt > max) {
				min = guitarCnt;
				max = musicCnt;
			}
			return;
		}

		playingMusic(cnt + 1, guitarCnt);
		for (int i = 0; i < M; i++) {
			if (guitar[cnt].charAt(i) == 'Y') {
				music[i]++;
			}
		}
		playingMusic(cnt + 1, guitarCnt + 1);
		for (int i = 0; i < M; i++) {
			if (guitar[cnt].charAt(i) == 'Y') {
				music[i]--;
			}
		}
	}
}