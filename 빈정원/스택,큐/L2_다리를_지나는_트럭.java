import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] pos = new int[truck_weights.length];
        int answer = 1;
        int curWeight = 0;
        int start = 0;
        int end = 0;
        int len = truck_weights.length;
        while (start < len) {
            if (end < len && weight >= curWeight + truck_weights[end])
                curWeight += truck_weights[end++];
            for (int i = start; i < end; i++)
                pos[i]++;
            while (start < len && pos[start] == bridge_length)
                curWeight -= truck_weights[start++];
            answer++;
        }
        return answer;
    }
}
