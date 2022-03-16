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
	 * 	분할정복
	 * 	큰 문제의 정답을 작은 문제의 정답으로 쪼갤 수 있을 때
	 * 	히스토그램의 경우 히스토그램 안에 들어가는 직사각형 넓이의 최댓값은 
	 * 	1. 히스토그램을 반 잘라서 왼쪽 히스토그램에 들어가는 직사각형 중 최댓값
	 * 	2. 오른쪽 히스토그램에 들어가는 직사각형중 최댓값
	 * 	3. 전체 히스토그램 중 최댓값
	 *  3개 중 가장 큰 값을 고른다.. >> 3번?
	 */
	
	public static int getMaxAreaWithDC(int from, int to, int[] h) {
		int result = 0;
		
		//밑변의 길이가 1인 경우 재귀 종료
		if (from == to) {
			return h[from];
		}
		
		int mid = (from + to) / 2;
		
		result = Math.max(result, getMaxAreaWithDC(from, mid, h));
		result = Math.max(result, getMaxAreaWithDC(mid + 1, to, h));
		
		//분할하는 구간에서 최대 넓이가 나올 때
		int maxArea = h[mid];
		
		//구간 양 끝에 도달할 때까지 반복
		//mid에서의 높이에서 높이가 높은 쪽으로 밑변 넓히기
		//높이는 구간중 가장 낮은 높이 선택
		int height = h[mid], width = 1, left = mid, right = mid;
		
		while (left > from || right < to) {
			int nStep = 0;
			int nL = left - 1;
			int nR = right + 1;
			
			//다음 스텝이 왼쪽인 경우
			//1 오른쪽으로 끝까지 간 경우
			//2 왼쪽의 높이가 오른쪽 높이보다 높은 경우
			//이때 왼쪽이 바운더리를 넘으면 안됨 outOfIndex 방지
			
			//오른쪽으로 끝까지 갔거나 왼쪽이 아직 범위 안쪽이고 왼쪽 높이가 더 높은 경우
			if (right >= to || (left > from && h[nL] >= h[nR]))
				nStep = --left;
			
			//왼쪽으로 끝까지 갔거나 오른쪽이 아직 범위 안쪽이고 오른쪽 높이가 더 높은 경우
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
