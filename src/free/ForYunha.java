package free;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ForYunha {

	static int N, M, K;
	static long[] arr;

	static class SegmentTree {
		// 트리구조, 요소 하나하나는 노드
		long[] tree;

		// 생성자, n은 수의 개수
		SegmentTree(int n) {
			tree = new long[4 * n];
		}

		// 값을 초기화하는 함수
		// 첫 번째 인자: 값이 들어있는 배열
		// 두 번째 인자: 현재 세그먼트 트리의 노드 번호
		// 세 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최솟값
		// 네 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최댓값
		long init(long[] arr, int node, int start, int end) {
			if (start == end) {
				// 리프노드이면 값을 그대로 저장
				return tree[node] = arr[start];
			} else {
				// 자식노드가 있다면 자식노드들의 합을 저장
				return tree[node] = init(arr, node * 2, start, (start + end) / 2)
						+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
			}
		}

		// 배열의 특정 인덱스의 값을 변경하는 함수
		// 첫 번째 인자: 현재 세그먼트 트리의 노드 번호
		// 두 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최솟값
		// 세 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최댓값
		// 네 번째 인자: 값을 바꿀 배열의 인덱스
		// 다섯 번째 인자: 바꿀 값과 기존 값의 차이
		void update(int node, int start, int end, int index, long diff) {
			// 바꿀 인덱스를 포함하고 있지 않은 노드라면
			if (index < start || index > end) {
				return;
			} else { // 바꿀 인덱스를 포함하고 있다면
				// 바꿀 값 - 기존 값 을 더해준다.
				tree[node] += diff;

				// 리프노드가 아니라면 자식노드로 내려간다.
				if (start != end) {
					update(node * 2, start, (start + end) / 2, index, diff);
					update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
				}
			}
		}

		// 배열의 연속된 인덱스 범위의 합을 구하는 함수
		// 첫 번째 인자: 현재 세그먼트 트리의 노드 번호
		// 두 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최솟값
		// 세 번째 인자: 현재 노드가 가지고 있는 값의 배열 인덱스 범위 중 최댓값
		// 네 번째 인자: 합을 구하고 싶은 인덱스 범위의 최솟값
		// 다섯 번째 인자: 합을 구하고 싶은 인덱스 범위의 최댓값
		long sum(int node, int start, int end, int left, long right) {
			// 현재 노드가 가지고 있는 값의 배열 인덱스 범위와
			// 합을 구하고 싶은 인덱스 범위가 전혀 겹치지 않는 경우
			if (end < left || start > right) {
				// 합에 영향을 주지 않는 0을 리턴한다.
				return 0;
				// 현재 노드가 가지고 있는 값의 배열 인덱스 범위가
				// 합을 구하고 싶은 인덱스 범위 안에 온전히 포함되는 경우
			} else if (left <= start && end <= right) {
				// 값을 그대로 리턴한다.
				return tree[node];
				// 나머지 경우
			} else {
				// 자식노드의 결과 값을 합한다
				return sum(node * 2, start, (start + end) / 2, left, right)
						+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N: 수의 개수, M: 수의 변경이 일어나는 횟수, K: 구간의 합을 구하는 횟수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 세그먼트 트리 생성
		SegmentTree seg = new SegmentTree(N + 1);

		// 값 입력 받기
		arr = new long[N + 1];
		for (int n = 1; n <= N; n++) {
			arr[n] = Long.parseLong(br.readLine());
		}

		seg.init(arr, 1, 1, N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				// b번째 수를 c로 바꾼다
				seg.update(1, 1, N, b, c - arr[b]);
				// 세그먼트 트리의 값 뿐만 아니라 기존 배열의 값도 바꿔준다.
				// 왜냐하면 diff를 구할 땐 기존 배열의 값을 이용하기 때문.
				arr[b] = c;
			} else {
				// b번째 수부터 c번째 수까지 합을 구한다.
				sb.append(seg.sum(1, 1, N, b, c) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}