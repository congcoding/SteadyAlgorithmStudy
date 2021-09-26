import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).toArray(String[]::new);
        return arr[0].equals("0") ? "0" : String.join("", arr);
    }
}
