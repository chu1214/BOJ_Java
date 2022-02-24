package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1206_View {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] city = new int[N];
			int view = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i < N - 2; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = i - 2; j <= i + 2; j++) {
					if(j == i) continue;
					if(city[i] >= city[j] && min > city[i] - city[j]) {
						min = city[i] - city[j];
					} else if(city[i] < city[j]){ 
						min = 0;
						break;
					}
				}
				if(min != Integer.MAX_VALUE) view += min;
			}
			sb.append("#" + t + " " + view + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}