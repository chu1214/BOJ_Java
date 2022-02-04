package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] field = new char[H][W];
			int tankR = 0, tankC = 0, tankDir = 0;

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					char a = str.charAt(j);
					field[i][j] = a;
					if (a == '^' || a == 'v' || a == '<' || a == '>') {
						tankR = i;
						tankC = j;
						if (a == '^')
							tankDir = 0;
						else if (a == 'v')
							tankDir = 1;
						else if (a == '<')
							tankDir = 2;
						else if (a == '>')
							tankDir = 3;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			char[] command = new char[N];
			String str = br.readLine();

			for (int i = 0; i < N; i++) {
				command[i] = str.charAt(i);
			}

			for (int i = 0; i < N; i++) {
				int nr, nc;
				switch (command[i]) {
				case 'U':
					tankDir = 0;
					field[tankR][tankC] = '^';
					nr = tankR + deltas[tankDir][0];
					nc = tankC + deltas[tankDir][1];
					if (isIn(nr, nc, H, W) && field[nr][nc] == '.') {
						field[tankR][tankC] = '.';
						tankR = nr;
						tankC = nc;
						field[tankR][tankC] = '^';
					} 
					break;
				case 'D':
					tankDir = 1;
					field[tankR][tankC] = 'v';
					nr = tankR + deltas[tankDir][0];
					nc = tankC + deltas[tankDir][1];
					if (isIn(nr, nc, H, W) && field[nr][nc] == '.') {
						field[tankR][tankC] = '.';
						tankR = nr;
						tankC = nc;
						field[tankR][tankC] = 'v';
					}
					break;
				case 'L':
					tankDir = 2;
					field[tankR][tankC] = '<';
					nr = tankR + deltas[tankDir][0];
					nc = tankC + deltas[tankDir][1];
					if (isIn(nr, nc, H, W) && field[nr][nc] == '.') {
						field[tankR][tankC] = '.';
						tankR = nr;
						tankC = nc;
						field[tankR][tankC] = '<';
					}
					break;
				case 'R':
					tankDir = 3;
					field[tankR][tankC] = '>';
					nr = tankR + deltas[tankDir][0];
					nc = tankC + deltas[tankDir][1];
					if (isIn(nr, nc, H, W) && field[nr][nc] == '.') {
						field[tankR][tankC] = '.';
						tankR = nr;
						tankC = nc;
						field[tankR][tankC] = '>';
					}
					break;
				case 'S':
					int cannonR = tankR;
					int cannonC = tankC;
					boolean isFin = false;

					while (!isFin) {
						nr = cannonR + deltas[tankDir][0];
						nc = cannonC + deltas[tankDir][1];
						
						if (isIn(nr, nc, H, W) && field[nr][nc] != '#' && field[nr][nc] != '*') {
							cannonR = nr;
							cannonC = nc;
						} else if (isIn(nr, nc, H, W) && field[nr][nc] == '#') {
							isFin = true;
						} else if (isIn(nr, nc, H, W) && field[nr][nc] == '*') {
							field[nr][nc] = '.';
							isFin = true;
						} else if (!isIn(nr, nc, H, W)) {
							isFin = true;
						}
					}
					break;
				default:
					break;
				}
			}
			sb.append("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	public static boolean isIn(int nr, int nc, int H, int W) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}
}