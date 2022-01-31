package boj.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_math_S2_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		br.close();
		
		List<Boolean> ans = new ArrayList<>(end + 1);
		ans.add(false);
		ans.add(false);
		
		for(int i = 2; i <= end; i++) {
			ans.add(true);
		}
		
		for(int i = 2; i * i <= end; i++) {
			if(ans.get(i)) {
				for(int j = i * i; j <= end; j += i)
					ans.set(j, false);
			}
		}
		
		for(int i = start; i <= end; i++) {
			if(ans.get(i) == true) bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}