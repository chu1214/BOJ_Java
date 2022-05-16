package boj.adhoc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_adhoc_G4_25181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] list = new int[N];
		int[] complete = new int[100001];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list[i] = num;
			hm.put(num, hm.getOrDefault(num, 0) + 1);
			complete[num]++;
			max = Math.max(max, hm.get(num));
		}

		if (max > N / 2) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < N; i++) {
				Set<Integer> keys = hm.keySet();
				int M = 0;
				int MKey = 0;
				for (int key : keys) {
					int value = hm.get(key);
					if (key != list[i] && value > 0) {
						if (value > M) {
							M = value;
							MKey = key;
						} else if (value == M) {
							if (complete[key] > complete[MKey]) {
								M = value;
								MKey = key;
							}
						}
					}
				}
				sb.append(MKey + " ");
				hm.put(MKey, hm.get(MKey) - 1);
				complete[list[i]]--;
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb.toString());
		}
	}
}