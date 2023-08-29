package SWEA;

import java.util.Scanner;

public class start_이진수표현_10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        // testcase TC
        int TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt(); // 정수 N
            int M = sc.nextInt(); // 정수 M
            String binaryM = Integer.toBinaryString(M); // 이진수 변환
 
            String lightening = "";
            // N개만큼 켜짐
            for (int i = 0; i < N; i++) {
                lightening += "1";
            }
 
            String K = "";
            if (binaryM.length() - N < 0) {
                System.out.println("#" + tc + " OFF");
                continue;
            }
            for (int j = binaryM.length() - N; j < binaryM.length(); j++) {
                K += binaryM.charAt(j);
            }
 
            if (lightening.equals(K)) {
                System.out.println("#" + tc + " ON");
            } else {
                System.out.println("#" + tc + " OFF");
            }
        }
 
    }
 
}