package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1233_사칙연산유효성검사 {
	static int N;
	static String[] tree;
	static boolean isCan = true;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int num) {
		if(num > N / 2) {
			if(!(tree[num].charAt(0) >= 48 && tree[num].charAt(0) <= 57)) {
				isCan = false;
				return;
			}
		}
		
		else if(num <= N / 2)
		{
			if(tree[num].charAt(0) >= 48 && tree[num].charAt(0) <= 57) {
				isCan = false;
				return;
			}
			dfs(num * 2);
			dfs(num * 2 + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N + 1];
			isCan = true;
			sb.append("#" + t + " ");
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken();
			}
			
			if(N % 2 == 0) {
				sb.append(0 + "\n");
				continue;
			}
			
			dfs(1);
			
			if(isCan) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}