import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_청정수컵_A번 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) - 1;
		int K = Integer.parseInt(st.nextToken());

		int ans = (M + (K - 3)) % N;

		System.out.println(ans < 0 ? N + ans + 1 : ans + 1);

	}

}
