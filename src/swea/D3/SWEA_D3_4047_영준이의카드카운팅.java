package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_4047_영준이의카드카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			String str = br.readLine();
			boolean[] S, D, H, C;
			boolean error = false;
			int cntS = 0, cntD = 0, cntH = 0 , cntC = 0;
			S = new boolean[14];
			D = new boolean[14];
			H = new boolean[14];
			C = new boolean[14];
			
			for(int i = 0; i < str.length(); i+=3) {
				char shape = str.charAt(i);
				int number;
				if(str.charAt(i+1) == '1') number = 10;
				else number = 0;
				number += str.charAt(i+2) - '0';
				if(shape == 'S') {
					if(S[number]) {
						error = true;
						break;
					} else {
						S[number] = true;
					}
				}else if(shape == 'D') {
					if(D[number]) {
						error = true;
						break;
					} else {
						D[number] = true;
					}
				}else if(shape == 'H') {
					if(H[number]) {
						error = true;
						break;
					} else {
						H[number] = true;
					}
				}else if(shape == 'C') {
					if(C[number]) {
						error = true;
						break;
					} else {
						C[number] = true;
					}
				}
			}
			if(!error) {
			for(int i = 1; i <= 13; i++) {
				if(!S[i]) cntS++;
				if(!D[i]) cntD++;
				if(!H[i]) cntH++;
				if(!C[i]) cntC++;
			}
			sb.append(cntS + " " + cntD + " " + cntH + " " + cntC + "\n");
			}
			else {
			sb.append("ERROR\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}