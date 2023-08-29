import java.util.Arrays;
import java.util.Scanner;
 
public class 윤길재_러시아국기같은깃발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][M];
            for(int i=0; i<N;i++) {
                String input = sc.next();
                // 1 2 3으로 굳이 바꾸기
                for(int j=0;j<M;j++) {
                    if(input.charAt(j)=='W') arr[i][j] = 1;
                    else if(input.charAt(j)=='B') arr[i][j] = 2;
                    else  arr[i][j] = 3;
                }
            }
             // 한 줄당 각각 빈도 수 체크
            int[][] fre = new int[N][4];
            for(int i=0; i<N; i++) {
                int[] cnt = new int[4];
                for(int j=0; j<M; j++) {
                    cnt[arr[i][j]]+=1;
                }
                fre[i] = cnt;
            }
            
            int ans=Integer.MAX_VALUE;
            for(int i=0; i<N-2; i++) {
                int count = M-fre[0][1];
                	// 하얀색 채워넣기
                    for(int l=1; l<=i;l++) count += M-fre[l][1];
                    
                for(int j=i+1; j<N-1; j++) {
                	//블루 채워 넣기
                    for(int o = i+1; o<=j;o++) count += M-fre[o][2];
                    
                    for(int k=j+1; k<N;k++) {
                        count += M-fre[k][3];
                    }
                    if(ans>count) {
                        ans = count;
                    }
                    count = 0;
                    //하얀색 채워 넣고
                    for(int l=0; l<=i;l++) count += M-fre[l][1];
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}