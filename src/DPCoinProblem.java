import java.util.Arrays;

public class DPCoinProblem {
    public static void main(String[] args) {
        //13원을 만들 수 있는 최소 동전 개수
        //greedy로 풀게되면 정답을 구할 수 없음. => 최적의 글로벌 해를 보장하지 않기 떄문
        int[] coins = {1, 5, 10, 25};
        int amount = 99;

        int[] m = new int[amount+1];
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i <= amount; i++) {
            int min = amount;
            for(int c : coins){
                if(i-c < 0) continue; //f(n-a)가 0보다 작거나 같으면. f(1)이 시작임.
                if(min > m[i-c]){
                    min = m[i-c];
                }
            }
            m[i] = min+1;
        }
        System.out.println(m[13]);

        /*
        //dp 풀이
        Arrays.sort(coins);
        int[] dy = new int[amount+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
            }
        }
        System.out.println(dy[amount]);
         */
    }
}
