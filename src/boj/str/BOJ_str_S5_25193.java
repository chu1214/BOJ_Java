package boj.str;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_str_S5_25193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();
		int chicken = 0;
		int others = 0;

		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'C') {
				chicken++;
			} else {
				others++;
			}
		}

		if (others == 0) {
			ans = chicken;
		} else {
			if (chicken % (others + 1) != 0) {
				ans = 1;
			}
			ans += chicken / (others + 1);
		}

		System.out.println(ans);

	}
}
