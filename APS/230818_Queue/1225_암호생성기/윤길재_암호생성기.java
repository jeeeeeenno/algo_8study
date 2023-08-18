import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int t=1; t<=10; t++) {
            Queue<Integer> que = new LinkedList<Integer>();
            int T = sc.nextInt();
            for(int i=0; i<8; i++) {
                que.add(sc.nextInt());
            }
             
            outer: while(true) {
                for(int i=1; i<=5;i++) {
                    if(que.peek()-i<=0) {
                        que.poll();
                        que.offer(0);
                        break outer;
                    }else {
                        que.offer(que.poll()-i);
                    }
                }
            }
            System.out.print("#"+t+" ");
            for(int x: que) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}