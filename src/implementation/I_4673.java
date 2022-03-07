package implementation;

import java.util.Arrays;

public class I_4673 {
	public static void main(String[] args) {

		boolean[] selfNumbers = new boolean[10001];
		Arrays.fill(selfNumbers, true);
		
		for (int i = 0; i < selfNumbers.length; i++) {
			int n = d(i);
			if (n <= 10000) selfNumbers[n] = false;
		}
		
		for (int i = 0; i < selfNumbers.length; i++) {
			if (selfNumbers[i]) System.out.println(i);
		}
		
		
		
	}
	
	private static int d(int x) {
		int result = x;
		
		while (x != 0) {
			result += x%10;
			x /= 10;
		}
		
		return result;
	}
	
	/*
	 * 이 방식은 범위가 10000을 넘어가면 코드를 전부 수정해야함 > 좋은 방식이 아님
	private static boolean isSelfNum(int x) {
		boolean result = true;
		
		//Loop에 이름을 붙이고 break LoopName 으로 원하는 루프에서 빠져나갈 수 있음
		
		//x = 1001*a + 101*b + 11*c + 2*d
		//식을 만족하는 abcd 조합이 있으면 셀프넘버 아님
		
		Loop1 : for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						if (x == 1001*i + 101*j + 11*k + 2*l) { 
							result = false;
							break Loop1;
						}
					}
				}
			}
		}
		
		return result;
	}
	*/
}
