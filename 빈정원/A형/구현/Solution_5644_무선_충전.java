package swea;

import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution_5644_무선_충전 {
 
    static class BC implements Comparable<BC> {
        int x;      // c
        int y;      // r
        int c;      // coverage
        int p;      // performance
        int idx;    // BC번호 (1 ~ 8)
         
        public BC(int x, int y, int c, int p, int idx) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
            this.idx = idx;
        }
 
        // Performance 내림차순으로 정렬
        @Override
        public int compareTo(BC o) {
            return o.p - this.p;
        }
         
    }
     
    static int T;
    static int M, A;    // 총이동시간 BC 개수
    static int N = 10;  // 지도 (1 ~ 10)
    static int[] aPath, bPath;
     
    static BC[] bc; // BC 정보 저장
    static LinkedList<BC> containA;
    static LinkedList<BC> containB;
     
    static int[] dr = {0, -1, 0, 1, 0}; // X상우하좌
    static int[] dc = {0, 0, 1, 0, -1};
     
    static int result;
    static int ax,ay, bx, by;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            M = sc.nextInt();   // 총 이동시간
            A = sc.nextInt();   // BC 개수
            aPath = new int[M + 1]; // 방향저장
            bPath = new int[M + 1]; 
            bc = new BC[A];     // 배터리 저장
            for (int i = 1; i <= M; i++) {
                aPath[i] = sc.nextInt();    // A방향저장
            }
            for (int i = 1; i <= M; i++) {
                bPath[i] = sc.nextInt();    // B방향저장
            }
            // 배터리 정보 저장
            for (int i = 0; i < A; i++) {
                // 배터리 정보 객체 생성
                bc[i] = new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
            }
            result = 0;
            ax = 1;
            ay = 1;
            bx = N;
            by = N;
             
            // 시간 time = 0일때도 충전 가능
            for (int time = 0; time <= M; time++) {
                // 시간마다 충전 상황 파악 => 시간마다 위치에서 충전소까지의 범위 계산
                containA = new LinkedList<>();
                containB = new LinkedList<>();
                ax += dc[aPath[time]];
                ay += dr[aPath[time]];
                bx += dc[bPath[time]];
                by += dr[bPath[time]];
                result += charging(time);
            }
            System.out.println("#" + t + " " + result);
        }
    }
 
    public static int charging(int time) {
        // 현재 위치에서 a와 b가 충전할 수 있는 BC들을 일단 모두 추가
        for (int i = 0; i < A; i++) {
            if (inRange(ax, ay, bc[i])) {
                containA.add(bc[i]);
            }
            if (inRange(bx, by, bc[i])) {
                containB.add(bc[i]);
            }
        }
         
        // 각 위치에서 최고 Performance 값을 찾기 위해 계산
        int value = 0;
        int asize = containA.size();
        int bsize = containB.size();
         
        // 한쪽의 사이즈가 0일 때는 최고 Performance로 충전하면 됨
        if (asize == 0) {
            for (int i = 0; i < bsize; i++) {
                value = Math.max(value, containB.get(i).p);
            }
        } else if (bsize == 0) {
            for (int i = 0; i < asize; i++) {
                value = Math.max(value, containA.get(i).p);
            }
        } else {
            for (int i = 0; i < asize; i++) {
                for (int j = 0; j < bsize; j++) {
                    if (containA.get(i).idx == containB.get(j).idx)    {
                        value = Math.max(value,  containA.get(i).p);
                    } else {
                        value = Math.max(value, containA.get(i).p + containB.get(j).p);
                    }
                }
            }
        }
 
        return value;
    }
 
    // 두 지점 사이의 거리가 배터리 coverage 안에 있는지 확인
    public static boolean inRange(int x, int y, BC bcharg) {
        int distance = distance(x, y, bcharg.x,bcharg.y);
        return distance <= bcharg.c;
    }
     
    // 좌표를 이용해 맨하탄 거리 구하기
    public static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
