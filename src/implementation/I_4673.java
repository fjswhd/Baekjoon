package implementation;

public class I_4673 {
	public static void main(String[] args) {

		for (int i = 1; i <= 10000; i++) {
			if (isSelfNum(i)) System.out.println(i);
		}
	}
	
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
}
