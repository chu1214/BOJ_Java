package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_simul_S3_16935 {

	static int N, M, R, Max;
	static int[] C;
	static int[][] arr;
	static int[][] rotateArr;
	static boolean isRotated;
	static StringBuilder sb = new StringBuilder();

	public static void rotate() {

		for(int r = 0; r < R; r++) {
			rotateArr = new int[Max][Max];
			
			switch (C[r]) {
			case 1:
				for(int i = 0; i < N/2; i++) {
					for(int j = 0; j < M; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[Math.abs(N-1-i)][j];
						arr[Math.abs(N-1-i)][j] = temp;
					}
				}
				break;
			case 2:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M/2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][Math.abs(M-1-j)];
						arr[i][Math.abs(M-1-j)] = temp;
					}
				}
				break;
			case 3:
				int t = M;
				M = N;
				N = t;
				isRotated = true ? false : true;
				rotateArr = new int[Max][Max];
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						rotateArr[i][j] = arr[M-1-j][i];
					}
				}
				arr = new int[Max][Max];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						arr[i][j] = rotateArr[i][j];
					}
				}
				break;
			case 4:
				t = M;
				M = N;
				N = t;
				isRotated = true ? false : true;
				rotateArr = new int[Max][Max];
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						rotateArr[i][j] = arr[j][N-1-i];
					}
				}
				arr = new int[Max][Max];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						arr[i][j] = rotateArr[i][j];
					}
				}
				
				break;
			case 5:
				for(int i = 0; i < N / 2; i++) {
					for(int j = 0; j < M / 2; j++) {
						rotateArr[i][M/2+j] = arr[i][j];
					}
				}
				for(int i = 0; i < N / 2; i++) {
					for(int j = M / 2; j < M; j++) {
						rotateArr[N/2+i][j] = arr[i][j];
					}
				}
				for(int i = N / 2; i < N; i++) {
					for(int j = 0; j < M / 2; j++) {
						rotateArr[i-N/2][j] = arr[i][j];
					}
				}
				for(int i = N / 2; i < N; i++) {
					for(int j = M / 2; j < M; j++) {
						rotateArr[i][j-M/2] = arr[i][j];
					}
				}
				arr = new int[Max][Max];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						arr[i][j] = rotateArr[i][j];
					}
				}
				break;
			case 6:
				for(int i = 0; i < N / 2; i++) {
					for(int j = 0; j < M / 2; j++) {
						rotateArr[N/2+i][j] = arr[i][j];
					}
				}
				for(int i = 0; i < N / 2; i++) {
					for(int j = M / 2; j < M; j++) {
						rotateArr[i][j-M/2] = arr[i][j];
					}
				}
				for(int i = N / 2; i < N; i++) {
					for(int j = 0; j < M / 2; j++) {
						rotateArr[i][j+M/2] = arr[i][j];
					}
				}
				for(int i = N / 2; i < N; i++) {
					for(int j = M / 2; j < M; j++) {
						rotateArr[i-N/2][j] = arr[i][j];
					}
				}
				arr = new int[Max][Max];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						arr[i][j] = rotateArr[i][j];
					}
				}
				break;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		Max = Math.max(N, M);
		
		arr = new int[Max][Max];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		C = new int[R];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		rotate();
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}