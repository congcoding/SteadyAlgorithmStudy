import java.util.*;

class Solution {
    
    static class Person {
        String parent;
        int total;
        
        public Person(String parent, int total) {
            this.parent = parent;
            this.total = total;
        }
    }
    
    static HashMap<String, Person> map = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // map에 판매원과 추천인 넣기
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Person(referral[i], 0));
        }
        
        // 재귀함수로 계산하기
        for (int i = 0; i < seller.length; i++) {
            sell(seller[i], amount[i] * 100);
        }
        
        // 정답 구하기
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).total;
        }
        return answer;
    }
    
    public void sell(String seller, int price) {
        // 10%와 90% 계산해서 자신에게 90% 더해주기
        int ten = (int)Math.floor(price * 0.1);
        int ninety = price - ten;
        map.get(seller).total += ninety;

        // 추천인이 민호거나, 10%가 0원인 경우 종료
        String parent = map.get(seller).parent;
        if (!parent.equals("-") && ten != 0) {
            sell(parent, ten);
        }
    }
}
