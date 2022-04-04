package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_dp_G3_24525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length() + 1];

		for (int i = 1; i <= str.length(); i++) {
			arr[i] = str.charAt(i - 1);
		}
		int left = 1;
		int right = 0;
		int sCnt = 0;
		int kCnt = 0;
		int max = -1;

		while (left <= str.length() || right <= str.length()) {
			if (sCnt * 2 - kCnt >= 4 || kCnt - sCnt * 2 >= 3) {
				left++;
				if (left > str.length())
					break;
				if (arr[left] == 'S')
					sCnt--;
				if (arr[left] == 'K')
					kCnt--;
			} else {
				right++;
				if (right > str.length())
					break;
				if (arr[right] == 'S')
					sCnt++;
				if (arr[right] == 'K')
					kCnt++;
			}
			if (sCnt * 2 == kCnt && sCnt != 0 && kCnt != 0) {
				max = right - left + 1;
			}
		}

		System.out.println(max);
	}
}