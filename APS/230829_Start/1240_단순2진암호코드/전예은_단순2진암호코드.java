package SWEA;

import java.util.Arrays;
import java.util.Scanner;
 
public class start_단순2진암호코드{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        // testcase
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt(); // 세로크기 N
            int M = sc.nextInt(); // 가로크기 N
 
            // codes 담움
            char[][] codes = new char[N][M];
            for (int i = 0; i < N; i++) {
                codes[i] = sc.next().toCharArray();
            }
 
            String[] code_ = new String[10];
             
            code_[0] = "0001101";
            code_[1] = "0011001";
            code_[2] = "0010011";
            code_[3] = "0111101";
            code_[4] = "0100011";
            code_[5] = "0110001";
            code_[6] = "0101111";
            code_[7] = "0111011";
            code_[8] = "0110111";
            code_[9] = "0001011";
 
            int idx_I = -1; // row
            int idx_J = -1; //0 보다는 초기값 -1 이 낫다. (-1은 에러가 나서 바로 알수있다) 
            // 1. 반복문
            for (int i = 0; i < codes.length; i++) {
                for (int j = codes[0].length - 1; j >= 0; j--) {
                    if (codes[i][j] == '1') {
                        idx_I = i; // 7
                        idx_J = j; // 59
                        break;
                    }
                }
            }
//          System.out.println(idx_I);
//          System.out.println(idx_J);
            // 2. lastIndexOf
            String secret = "";
            String[] secretNumber = new String[8];
 
            // 56개 추출
//          for( int j = idx_J; j >= idx_J-56; j = j -7) {
//              for(int k = j; k >= idx_J-56; k-- ) {
//                  secret += codes[j][k]; 
//              }
//          }
 
            // 56개 추출
            for (int j = idx_J - 55; j <= idx_J; j++) {
                secret += codes[idx_I][j];
            }
            char[] a = secret.toCharArray();
//          System.out.println(Arrays.toString(a));
 
            String[] b = new String[8];
             
            //null 사라짐 
            for (int i = 0; i < 8; i++) {
                b[i] = "";
            }
//          
//          for (int j = 0; j < secret.length(); j = j+7) {
//              for (int row = 0; row < 8; row++) {
//                  for (int k = 0; k < 7; k++) {
//                  secretNumber[row] += a[k];
//                  }
//              }
//          }
 
            for (int i = 0; i < 8; i++) {
                for (int j = i * 7; j < i*7 + 7; j++) {
                    b[i] += a[j];
                }
            }
 
            int[] c = new int[8];
             
            for(int i = 0; i< 8; i++) {
                for(int j =0; j<10; j++) {
                    if(b[i].equals(code_[j])) {
                        c[i] = j;
                    }
                }
            }
             
            int odd = 0;
            for(int i = 0; i<8 ; i +=2) {
                odd += c[i];
            }
             
            int even = 0;
            for(int i = 1; i<8; i+=2) {
                even += c[i];
            }
             
            if( (odd*3 + even) % 10 ==0 ) {
                System.out.println("#"+tc+ " " + (odd+even));
            } else System.out.println("#"+tc+ " " + 0);
//          System.out.println(odd*3 + even);
//          System.out.println(odd + even);
//          System.out.println(Arrays.toString(c));
//          System.out.println(Arrays.toString(b));
//          System.out.println(secret);
//          System.out.println(secret.length());
        }
    }
}