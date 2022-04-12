package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_9760_PokerGame {

	static boolean[][] cards;
	static int[] count;

	public static boolean isFourCard() {
		for (int i = 0; i < 13; i++) {
			if (count[i] == 4)
				return true;
		}
		return false;
	}

	public static boolean isTriple() {
		for (int i = 0; i < 13; i++) {
			if (count[i] == 3)
				return true;
		}
		return false;
	}

	public static boolean isTwoPair() {
		int cnt = 0;

		for (int i = 0; i < 13; i++) {
			if (count[i] == 2) {
				cnt++;
			}
		}

		if (cnt == 2)
			return true;
		return false;
	}

	public static boolean isOnePair() {
		for (int i = 0; i < 13; i++) {
			if (count[i] == 2)
				return true;
		}
		return false;
	}

	public static boolean isStraight() {
		for (int i = 0; i < 9; i++) {
			boolean found = true;
			for (int j = i; j < i + 5; j++) {
				if (count[j] != 1) {
					found = false;
					break;
				}
			}
			if (found) {
				return true;
			}
		}
		return false;
	}

	public static boolean isMountain() {
		if (count[0] == 1) {
			for (int i = 9; i < 13; i++) {
				if (count[i] != 1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static boolean isFlush() {
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			for (int j = 0; j < 13; j++) {
				if (cards[i][j])
					cnt++;
			}
			if (cnt == 5) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			cards = new boolean[4][13];
			count = new int[13];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				String card = st.nextToken();
				int shape = -1;
				int num = -1;
				switch (card.charAt(0)) {
				case 'S':
					shape = 0;
					break;
				case 'D':
					shape = 1;
					break;
				case 'H':
					shape = 2;
					break;
				case 'C':
					shape = 3;
					break;
				}
				switch (card.charAt(1)) {
				case 'A':
					num = 0;
					break;
				case '2':
					num = 1;
					break;
				case '3':
					num = 2;
					break;
				case '4':
					num = 3;
					break;
				case '5':
					num = 4;
					break;
				case '6':
					num = 5;
					break;
				case '7':
					num = 6;
					break;
				case '8':
					num = 7;
					break;
				case '9':
					num = 8;
					break;
				case 'T':
					num = 9;
					break;
				case 'J':
					num = 10;
					break;
				case 'Q':
					num = 11;
					break;
				case 'K':
					num = 12;
					break;
				}
				cards[shape][num] = true;
				count[num]++;
			}

			boolean fourcard = isFourCard();
			boolean flush = isFlush();
			boolean mountain = isMountain();
			boolean straight = isStraight();
			boolean triple = isTriple();
			boolean twopair = isTwoPair();
			boolean onepair = isOnePair();

			sb.append("#" + t + " ");
			if ((mountain || straight) && flush) {
				sb.append("Straight Flush\n");
			} else if (fourcard) {
				sb.append("Four of a Kind\n");
			} else if (triple && onepair) {
				sb.append("Full House\n");
			} else if (flush) {
				sb.append("Flush\n");
			} else if (straight) {
				sb.append("Straight\n");
			} else if (triple) {
				sb.append("Three of a kind\n");
			} else if (twopair) {
				sb.append("Two pair\n");
			} else if (onepair) {
				sb.append("One pair\n");
			} else {
				sb.append("High card");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}