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
	 * �� ����� ������ 10000�� �Ѿ�� �ڵ带 ���� �����ؾ��� > ���� ����� �ƴ�
	private static boolean isSelfNum(int x) {
		boolean result = true;
		
		//Loop�� �̸��� ���̰� break LoopName ���� ���ϴ� �������� �������� �� ����
		
		//x = 1001*a + 101*b + 11*c + 2*d
		//���� �����ϴ� abcd ������ ������ �����ѹ� �ƴ�
		
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
