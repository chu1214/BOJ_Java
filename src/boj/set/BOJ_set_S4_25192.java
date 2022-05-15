package boj.set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_set_S4_25192 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Set<String> s = new HashSet<>();
		int ans = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			if (str.equals("ENTER")) {
				ans += s.size();
				s = new HashSet<>();
			} else {
				s.add(str);
			}

		}

		ans += s.size();

		System.out.println(ans);

	}
}
