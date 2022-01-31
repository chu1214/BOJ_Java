package boj.str;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ_str_S5_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			list.add(br.readLine());
		}
	
		list.sort(new Comparator <String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else if(o1.length() > o2.length()){
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			if(i < list.size() - 1 && list.get(i).equals(list.get(i + 1))) {
				continue;
			}else {
				bw.write(list.get(i) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}