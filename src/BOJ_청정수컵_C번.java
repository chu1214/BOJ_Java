import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_청정수컵_C번 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int min = Math.min(N, M);
		int max = Integer.MIN_VALUE;

		int[] present = new int[N];
		int[] past = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			present[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			past[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < min; i++) {
			int now = past[i] - present[i];
			max = Math.max(max, now);
		}

		if (M > N) {
			for (int i = min; i < M; i++) {
				max = Math.max(max, past[i]);
			}
		}

		if (max < 0) {
			max = 0;
		}

		System.out.println(max);
	}

}
