package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_3289_서로소집합 {

	static int T, N, M;
	static int[] set;
	
	public static void makeSet(int n) {
		for(int i = 1; i <= N; i++) {
			set[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a == set[a]) return a;
			return set[a] = find(set[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) set[a] = b;
		else set[b] = a;
		return;
	}
	
	public static boolean isInSame(int a, int b) {
		return find(a) == find(b);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new int[N + 1];
			
			makeSet(N);
			
			sb.append("#" + t + " ");
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					union(a, b);
				}
				else if(command == 1) {
					if(isInSame(a, b)) {
						sb.append(1 + "");
					} else {
						sb.append(0 + "");
					}
				}
			}
			sb.append("\n");
		}	
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}