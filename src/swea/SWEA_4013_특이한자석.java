package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

	static int T, K, score;
	static int[][] magnet;
	static int[][] rotate;
	static boolean[] visited;

	public static void rotation(int num, int dir) {
		visited[num] = true; // 회전한 자석 체크

		// 왼쪽 체크
		if (num - 1 >= 0 && !visited[num - 1]) {
			if (magnet[num][6] != magnet[num - 1][2]) {
				rotation(num - 1, -dir); // 극이 다르다면 회전 시키기
			}
		}

		// 오른쪽 체크
		if (num + 1 < 4 && !visited[num + 1]) {
			if (magnet[num][2] != magnet[num + 1][6]) {
				rotation(num + 1, -dir); // 극이 다르다면 회전 시키기
			}
		}

		// 자석 회전
		if (dir == 1) { // 시계방향
			int temp = magnet[num][7];
			for (int i = 7; i > 0; i--) {
				magnet[num][i] = magnet[num][i - 1];
			}
			magnet[num][0] = temp;
		} else { // 반시계방향
			int temp = magnet[num][0];
			for (int i = 0; i < 7; i++) {
				magnet[num][i] = magnet[num][i + 1];
			}
			magnet[num][7] = temp;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			rotate = new int[K][2];
			score = 0;

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					rotate[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 회전
			for (int i = 0; i < K; i++) {
				visited = new boolean[4];
				int num = rotate[i][0];
				int dir = rotate[i][1];
				rotation(num - 1, dir);
			}

			// 점수 계산
			for (int j = 0; j < 4; j++) {
				score += (magnet[j][0] << j);
			}

			sb.append("#" + t + " " + score + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}