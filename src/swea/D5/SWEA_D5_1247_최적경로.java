package swea.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적경로 {

	static int N, min;
	static int[][] Client;
	static int[] Company, Home;
	
	public static void delivery(int[] start, boolean[] isVisited, int sum, int cnt) {
		int r = start[0];
		int c = start[1];
		
		if(sum > min) return;
		
		if(cnt == N) {
			sum += Math.abs(Home[0] - r) + Math.abs(Home[1] - c);
			if(sum < min) min = sum;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				int distance = Math.abs(Client[i][0] - r) + Math.abs(Client[i][1] - c);
				isVisited[i] = true;
				delivery(Client[i], isVisited, sum + distance, cnt + 1);
				isVisited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			Company = new int[2];
			Home = new int[2];
			Client = new int[N][2];
			boolean[] isVisited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			
			Company[0] = Integer.parseInt(st.nextToken());
			Company[1] = Integer.parseInt(st.nextToken());
			Home[0] = Integer.parseInt(st.nextToken());
			Home[1] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				Client[i][0] = Integer.parseInt(st.nextToken());
				Client[i][1] = Integer.parseInt(st.nextToken());
			}
			
			delivery(Company, isVisited, 0, 0);
			sb.append("#" + t + " " + min + "\n");
		}
		sb.setLength(sb.length() -1);
		System.out.println(sb.toString());
	}
}