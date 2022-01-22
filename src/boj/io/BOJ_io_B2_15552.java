package boj.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_io_B2_15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String[] strs = new String[2];
		int num = Integer.parseInt(str);
		int sum = 0;
		
		for(int i = 0; i < num; i++) {
			str = br.readLine();
			strs = str.split(" ");
			for(int j = 0; j < strs.length; j++) {
				sum += Integer.parseInt(strs[j]);
			}
			bw.write(sum+"\n");
			sum = 0;
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
