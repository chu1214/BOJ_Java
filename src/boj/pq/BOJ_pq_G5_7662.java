package boj.pq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_pq_G5_7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int k = 0; k < K; k++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				String ord = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (ord.equals("I"))
					map.put(num, map.getOrDefault(num, 0) + 1);
				else {
					if (!map.isEmpty()) {
						int del;
						if (num == 1) {
							del = map.lastKey();
						} else {
							del = map.firstKey();
						}
						if (map.put(del, map.get(del) - 1) == 1) {
							map.remove(del);
						}

					}
				}

			}
			if (map.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(map.lastKey() + " " + map.firstKey() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}