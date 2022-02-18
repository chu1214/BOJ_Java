package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_bruteforce_G5_15683 {

	static int N, M, CCTV = 0;
	static int[] dir;
	static int[][] office;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int ans = Integer.MAX_VALUE;
	
	public static void setCCTV(int cnt) {
		if (cnt == CCTV) {
			int num = 0;
			int blind = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (office[r][c] < 6 && office[r][c] > 0) {
						boolean isOut = false;
						switch (office[r][c]) {
						case 1:
							int or = r, oc = c;
							while (!isOut) {
								int nr = or + deltas[dir[num]][0];
								int nc = oc + deltas[dir[num]][1];
								if (isIn(nr, nc) && office[nr][nc] != 6) {
									if (office[nr][nc] == 0) {
										office[nr][nc] = '#';
									}
									or = nr;
									oc = nc;
								} else
									isOut = true;
							}
							num++;
							break;
						case 2:
							for (int i = 0; i < 2; i++) {
								or = r;
								oc = c;
								isOut = false;
								while (!isOut) {
									int nr = or + deltas[(dir[num] + i * 2) % 4][0];
									int nc = oc + deltas[(dir[num] + i * 2) % 4][1];
									if (isIn(nr, nc) && office[nr][nc] != 6) {
										if (office[nr][nc] == 0) {
											office[nr][nc] = '#';
										}
										or = nr;
										oc = nc;
									} else
										isOut = true;
								}
							}
							num++;
							break;
						case 3:
							for (int i = 0; i < 2; i++) {
								or = r;
								oc = c;
								isOut = false;
								while (!isOut) {
									int nr = or + deltas[(dir[num] + i) % 4][0];
									int nc = oc + deltas[(dir[num] + i) % 4][1];
									if (isIn(nr, nc) && office[nr][nc] != 6) {
										if (office[nr][nc] == 0) {
											office[nr][nc] = '#';
										}
										or = nr;
										oc = nc;
									} else
										isOut = true;
								}
							}
							num++;
							break;
						case 4:
							for (int i = 0; i < 3; i++) {
								or = r;
								oc = c;
								isOut = false;
								while (!isOut) {
									int nr = or + deltas[(dir[num] + i) % 4][0];
									int nc = oc + deltas[(dir[num] + i) % 4][1];
									if (isIn(nr, nc) && office[nr][nc] != 6) {
										if (office[nr][nc] == 0) {
											office[nr][nc] = '#';
										}
										or = nr;
										oc = nc;
									} else
										isOut = true;
								}
							}
							num++;
							break;
						case 5:
							for (int i = 0; i < 4; i++) {
								or = r;
								oc = c;
								isOut = false;
								while (!isOut) {
									int nr = or + deltas[(dir[num] + i) % 4][0];
									int nc = oc + deltas[(dir[num] + i) % 4][1];
									if (isIn(nr, nc) && office[nr][nc] != 6) {
										if (office[nr][nc] == 0) {
											office[nr][nc] = '#';
										}
										or = nr;
										oc = nc;
									} else
										isOut = true;
								}
							}
							num++;
							break;
						}
					}
				}
			}
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(office[r][c] == 0) {
						blind++;
					}
					else if(office[r][c] == '#') {
						office[r][c] = 0;
					}
				}
			}
			
			if(blind < ans) ans = blind;
			return;
		}

		for (int d = 0; d < 4; d++) {
			dir[cnt] = d;
			setCCTV(cnt + 1);
		}
	}

	public static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] < 6 && office[i][j] > 0)
					CCTV++;
			}
		}

		dir = new int[CCTV];
		setCCTV(0);
		
		System.out.println(ans);
	}
}
