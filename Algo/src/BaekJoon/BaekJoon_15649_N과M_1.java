package BaekJoon;

import java.util.Scanner;

//22.03.15
//nCr (n과 r을 주고 순서를 고려하지 않고 뽑기!)
public class BaekJoon_15649_N과M_1 {
	static int a;
	static int cnt;
	static int[] num;
	static boolean[] visit;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		cnt = sc.nextInt();
		num = new int[a];
		visit = new boolean[a];
		result = new int[a];

		for (int i = 0; i < a; i++) {
			num[i] = i + 1;
		}
		recur(0);
	}

	public static void recur(int dept) {
		// 이제 그만
		if (dept >= cnt) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();

			return;
		}

		// 재귀
		// 뽑은담에 다시 돌면서 안뽑은거있으면 뽑는다.
		for (int i = 0; i < a; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			result[dept] = num[i];
			recur(dept + 1);
			//다음번 새로 돌때는 다시 리뉴얼해주기 위해서 false로 둔다.
			visit[i] = false;
		}
	}
}
