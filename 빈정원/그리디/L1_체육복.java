import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> l = new HashSet<>();        
        HashSet<Integer> r = new HashSet<>();        
        for (int num : lost)
            l.add(num);
        // 여벌 & 도난인 경우 제외
        for (int num : reserve) {
            if (l.contains(num))
                l.remove(num);
            else
                r.add(num);
        }
        
        for (int num : r) {
            if (l.contains(num - 1))
                l.remove(num - 1);
            else if (l.contains(num + 1))
                l.remove(num + 1);
        }
        return n - l.size();
    }
}
