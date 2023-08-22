import java.util.Scanner;

public class Algo4_서울_8반_권재현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);    // 테스트케이스를 받아올 스캐너
		
		int[] dr = { 1, 0, -1, 0 };    //행 방향 델타 배열 dr
		int[] dc = { 0, 1, 0, -1 };    //열 방향 델타 배열 dc
				
		int T = sc.nextInt();    // 테스트케이스 수 저장하는 변수 T
		for (int t = 1; t <= T; t++) {    // 테스트케이스 횟수만큼 반복문
			StringBuilder ans = new StringBuilder();    // 출력할 답안 저장하기 위한 StringBuilder ans
			
			int N = sc.nextInt();    // 정수 N			
			int map[][] = new int[N][N];    // N * N 크기 2차원 배열 map
			int num = 1;    // map의 각 칸에 들어갈 정수 num
			int r = -1;    // map에 들어갈 차례의 행 번호 r
			int c = 0;    // map에 들어갈 차례의 열 번호 r
			int dir = 0;    // 방향을 바꾼 횟수를 저장하여 현재의 방향 정보를 나태는 변수 dir
			int rep = N;    // 방향을 바꾸기 전 반복할 횟수 rep
			
			while (num <= N * N) {     // num이 N * N이 될 때까지 반복문
				for (int i = 0; i < rep; i++) {    // rep번만큼 반복문
					r = r + dr[dir % 4];    // r에 델타 배열과 방향 정보를 이용해 알맞은 숫자를 더해줘서 위치 이동
					c = c + dc[dir % 4];    // ㅊ에 델타 배열과 방향 정보를 이용해 알맞은 숫자를 더해줘서 위치 이동
					map[r][c] = num++;    // map의 r행 c열에 num을 저장한 후 num에 1 증가 
				}
				if (dir++ % 2 == 0) rep--;    // 지금까지 방향 바꾼 횟수 dir이 짝수라면 반복횟수 rep 1 감소 
			}
			
			
			ans.append("#").append(t).append("\n");    // 답안 포맷에 맞게 ans에 #t 저장
			for (int i = 0; i < N; i++) {    // N번만큼 반복문
				for (int j = 0; j < N; j++) {    // N번만큼 반복문
					ans.append(map[i][j]).append(" ");    // 답안 포맷에 맞게 ans에 map의 i행 j열 숫자 저장 
				}
				ans.append("\n");    // 행이 끝나면 줄 바꿈
			}
			
			System.out.print(ans);    // ans 출력
		}
		
		sc.close();    //스캐너 close;
	}

}