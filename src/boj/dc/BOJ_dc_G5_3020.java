package boj.dc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_dc_G5_3020 {

	static int N, H;
	static int[] top, bottom;
	static TreeMap<Integer, Integer> ans = new TreeMap<>();

	public static int search(int[] arr, int left, int right, int height) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] < height)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return arr.length - (right + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		top = new int[N / 2];
		bottom = new int[N / 2];

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				bottom[i / 2] = Integer.parseInt(br.readLine());
			else
				top[i / 2] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bottom);
		Arrays.sort(top);

		for (int i = 1; i <= H; i++) {
			int obs = search(top, 0, top.length - 1, H - i + 1) + search(bottom, 0, bottom.length - 1, i);
			ans.put(obs, ans.getOrDefault(obs, 0) + 1);
		}

		Entry<Integer, Integer> entry = ans.pollFirstEntry();
		System.out.println(entry.getKey() + " " + entry.getValue());
	}
}
