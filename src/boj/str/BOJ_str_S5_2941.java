package boj.str;

import java.io.*;

public class BOJ_str_S5_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = br.readLine();
		
		for(int i = 0; i < list.length; i++) {
			if(str.contains(list[i])) {
				str = str.replace(list[i], ".");
			}
		}
		System.out.println(str.length());
	}
}