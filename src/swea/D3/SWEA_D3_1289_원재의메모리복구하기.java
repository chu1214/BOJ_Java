package swea.D3;

import java.io.*;

public class SWEA_D3_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int cnt = 0;
			String str = br.readLine();
			int[] recovery = new int[str.length()];
			int[] target = new int[str.length()];
			
			for(int i = 0; i < str.length(); i++) {
				target[i] = str.charAt(i) - '0';
			}
			
			for(int i = 0; i < recovery.length; i++) {
				if(recovery.equals(target)) break;
				if(recovery[i] != target[i]) {
					cnt++;
					for(int j = i; j < recovery.length; j++) {
						recovery[j] = recovery[j] == 0 ? 1 : 0;
					}
				}
			}
			sb.append("#" + t + " " + cnt + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}