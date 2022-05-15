import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_청정수컵_D번 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean yes = true;
		int C1 = 0;
		int C2 = 0;

		int[] alpha1 = new int[26];
		int[] alpha2 = new int[26];
		char[] fl1 = new char[2];
		char[] fl2 = new char[2];
		char[] onlyC1 = new char[N];
		char[] onlyC2 = new char[N];

		String str1 = br.readLine();
		String str2 = br.readLine();

		for (int i = 0; i < N; i++) {
			char a = str1.charAt(i);
			char b = str2.charAt(i);

			alpha1[a - 'a']++;
			alpha2[b - 'a']++;

			if (i == 0) {
				fl1[0] = a;
				fl2[0] = b;
			}
			if (i == N - 1) {
				fl1[1] = a;
				fl2[1] = b;
			}
			if (a != 'a' && a != 'e' && a != 'o' && a != 'u' && a != 'i') {
				onlyC1[C1] = a;
				C1++;
			}
			if (b != 'a' && b != 'e' && b != 'o' && b != 'u' && b != 'i') {
				onlyC2[C2] = b;
				C2++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (alpha1[i] != alpha2[i]) {
				yes = false;
				break;
			}
		}

		if (yes) {
			if (fl1[0] != fl2[0] || fl1[1] != fl2[1]) {
				yes = false;
			}
		}

		if (yes) {
			if (C1 != C2)
				yes = false;
			else {
				for (int i = 0; i < C1; i++) {
					if (onlyC1[i] != onlyC2[i]) {
						yes = false;
						break;
					}
				}
			}
		}

		if (yes)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
