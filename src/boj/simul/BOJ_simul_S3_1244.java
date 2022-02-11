package boj.simul;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_simul_S3_1244 {

	static int N, S;
	static int[] Switch;
	static int[][] Student;
	
	public static void change() {
		for(int s = 0; s < S; s++) {
			switch(Student[s][0]) {
			case 1:
				for(int i = 1; i <= N; i++) {
					if(i % Student[s][1] == 0) {
						if(Switch[i] == 1) Switch[i] = 0;
						else Switch[i] = 1;
					}
				}
				break;
			case 2:
				if(Switch[Student[s][1]] == 0) Switch[Student[s][1]] = 1;
				else Switch[Student[s][1]] = 0;
				
				for(int i = 1; i < N / 2; i++) {
					if(Student[s][1] - i < 1 || Student[s][1] + i > N) 
						break;
					if(Switch[Student[s][1] - i] == Switch[Student[s][1] + i]) {
						if(Switch[Student[s][1] - i] == 1) {
							Switch[Student[s][1] - i] = 0;
							Switch[Student[s][1] + i] = 0;
						}
						else {
							Switch[Student[s][1] - i] = 1;
							Switch[Student[s][1] + i] = 1;
						}
					}
					else break;
				}
				break;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Switch = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			Switch[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		Student = new int[S][2];
		
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			Student[i][0] = Integer.parseInt(st.nextToken());
			Student[i][1] = Integer.parseInt(st.nextToken());
		}
		
		change();
		
		for(int i = 1; i <= N; i++) {
			sb.append(Switch[i] + " ");
			if(i % 20 == 0) {
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}