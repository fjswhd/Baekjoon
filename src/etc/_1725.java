package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1725 {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		int[] h = new int[n];
		
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}
		
		
		int result = getMaxAreaWithDC(0, n-1, h);
		
		System.out.println(result);
		
	}
	
	
	/*
	 * 	��������
	 * 	ū ������ ������ ���� ������ �������� �ɰ� �� ���� ��
	 * 	������׷��� ��� ������׷� �ȿ� ���� ���簢�� ������ �ִ��� 
	 * 	1. ������׷��� �� �߶� ���� ������׷��� ���� ���簢�� �� �ִ�
	 * 	2. ������ ������׷��� ���� ���簢���� �ִ�
	 * 	3. ��ü ������׷� �� �ִ�
	 *  3�� �� ���� ū ���� ����.. >> 3��?
	 */
	
	public static int getMaxAreaWithDC(int from, int to, int[] h) {
		int result = 0;
		
		//�غ��� ���̰� 1�� ��� ��� ����
		if (from == to) {
			return h[from];
		}
		
		int mid = (from + to) / 2;
		
		result = Math.max(result, getMaxAreaWithDC(from, mid, h));
		result = Math.max(result, getMaxAreaWithDC(mid + 1, to, h));
		
		//�����ϴ� �������� �ִ� ���̰� ���� ��
		int maxArea = h[mid];
		
		//���� �� ���� ������ ������ �ݺ�
		//mid������ ���̿��� ���̰� ���� ������ �غ� ������
		//���̴� ������ ���� ���� ���� ����
		int height = h[mid], width = 1, left = mid, right = mid;
		
		while (left > from || right < to) {
			int nStep = 0;
			int nL = left - 1;
			int nR = right + 1;
			
			//���� ������ ������ ���
			//1 ���������� ������ �� ���
			//2 ������ ���̰� ������ ���̺��� ���� ���
			//�̶� ������ �ٿ������ ������ �ȵ� outOfIndex ����
			
			//���������� ������ ���ų� ������ ���� ���� �����̰� ���� ���̰� �� ���� ���
			if (right >= to || (left > from && h[nL] >= h[nR]))
				nStep = --left;
			
			//�������� ������ ���ų� �������� ���� ���� �����̰� ������ ���̰� �� ���� ���
			else if (left <= from || (right < to && h[nL] < h[nR]))
				nStep = ++right;
			
			height = Math.min(height, h[nStep]);
			width++;
			
			maxArea = Math.max(maxArea, height*width);
			
		}
		
		result = Math.max(result, maxArea);
		
		return result;
	}
	
}
