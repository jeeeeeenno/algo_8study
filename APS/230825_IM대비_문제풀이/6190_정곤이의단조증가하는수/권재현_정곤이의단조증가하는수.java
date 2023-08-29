package IM대비_문제풀이.정곤이의_단조_증가하는_수_6190;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int n = 0; n < N; n++) {
                arr[n] = sc.nextInt();
            }
             
            List<Integer> target = new ArrayList<>();
             
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    boolean flag = true;
                    int num = arr[i] * arr[j];
                    while (num > 0) {
                        int d1 = num % 10;
                        num /= 10;
                        int d2 = num % 10;
                        if (d1 < d2) {
                            flag = false;
                            break;
                        }
                    }
                     
                    if (flag) target.add(arr[i] * arr[j]);
                     
                }
            }
             
            int ans;
            if (target.size() < 1) ans = -1;
            else {
                Collections.sort(target, Collections.reverseOrder());
                ans = target.get(0);
            }
            System.out.println(String.format("#%d %d", t, ans));
        }
         
        sc.close();
    }
 
}