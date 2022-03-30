import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_greedy_D4_18186 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		long[] factory = new long[N + 2];
		long ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			factory[i] = Long.parseLong(st.nextToken());
		}

		if (B < C)
			C = B;

		for (int i = 0; i < N; i++) {

			if (factory[i + 1] > factory[i + 2]) {
				long buy2 = Math.min(factory[i], factory[i + 1] - factory[i + 2]);
				ans += (B + C) * buy2;
				factory[i] -= buy2;
				factory[i + 1] -= buy2;

				long buy3 = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
				ans += (B + 2 * C) * buy3;
				factory[i] -= buy3;
				factory[i + 1] -= buy3;
				factory[i + 2] -= buy3;

			} else {
				long buy3 = Math.min(factory[i], Math.min(factory[i + 1], factory[i + 2]));
				ans += (B + 2 * C) * buy3;
				factory[i] -= buy3;
				factory[i + 1] -= buy3;
				factory[i + 2] -= buy3;

				long buy2 = Math.min(factory[i], factory[i + 1]);
				ans += (B + C) * buy2;
				factory[i] -= buy2;
				factory[i + 1] -= buy2;
			}
			ans += B * factory[i];
		}

		System.out.println(ans);
	}

}