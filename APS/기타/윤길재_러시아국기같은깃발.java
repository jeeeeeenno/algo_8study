import java.util.Arrays;
import java.util.Scanner;
 
public class ������_���þƱ��ⰰ����� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][M];
            for(int i=0; i<N;i++) {
                String input = sc.next();
                // 1 2 3���� ���� �ٲٱ�
                for(int j=0;j<M;j++) {
                    if(input.charAt(j)=='W') arr[i][j] = 1;
                    else if(input.charAt(j)=='B') arr[i][j] = 2;
                    else  arr[i][j] = 3;
                }
            }
             // �� �ٴ� ���� �� �� üũ
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
                	// �Ͼ�� ä���ֱ�
                    for(int l=1; l<=i;l++) count += M-fre[l][1];
                    
                for(int j=i+1; j<N-1; j++) {
                	//��� ä�� �ֱ�
                    for(int o = i+1; o<=j;o++) count += M-fre[o][2];
                    
                    for(int k=j+1; k<N;k++) {
                        count += M-fre[k][3];
                    }
                    if(ans>count) {
                        ans = count;
                    }
                    count = 0;
                    //�Ͼ�� ä�� �ְ�
                    for(int l=0; l<=i;l++) count += M-fre[l][1];
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}