import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_청정수컵_F번 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int length = 0;

		while (N > 0) {
			if (N < 10) {
				N = 0;
				length += 1;
			} else {
				for (int i = 9; i >= 5; i--) {
					if (N >= i * 2) {
						N -= i * 2;
						length += 2;
						break;
					}
				}
			}
		}
		System.out.println(length);
	}
}