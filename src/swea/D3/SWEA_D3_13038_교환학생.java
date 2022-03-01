package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_13038_교환학생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] schedule = new int[7];
			
			int min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine()); 
            for(int i = 0; i < schedule.length; i++) {
                schedule[i] = Integer.parseInt(st.nextToken());
            }
			
			for(int i = 0; i < 7; i++) {
				if(schedule[i] == 1) {
					int day = 1;
					int remain = N - 1;
					int loop = i;
					while(true) {
						if(remain == 0) break;
						day++;
						loop++;
						if(loop == 7) loop = 0;
						if(schedule[loop] == 1)
							remain--;
					}
					min = Math.min(day, min);
				}
			}
			
			sb.append("#" + t + " " + min + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}