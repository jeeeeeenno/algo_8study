package 보물상자비밀번호;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수
        for(int test = 1; test <= T; test++){
            // 입력
            int N = scanner.nextInt(); // 숫자의 개수 (4의 배수, 8이상 28이하)
            int K = scanner.nextInt(); // 크기 순서
            int len = N/4;
            String hex = scanner.next(); // 16진수 암호
            hex += hex.substring(0,len);
            // 계산
            HashSet<String> password = new HashSet<>();
            for(int i = 0; i < N; i++){
                password.add(hex.substring(i, i+len));
            }
            String[] arr = password.toArray(new String[0]);
            Arrays.sort(arr);
            int ans = Integer.valueOf(arr[arr.length-K], 16);
            // 출력
            System.out.printf("#%d %d\n", test, ans);
        }
    }
}
