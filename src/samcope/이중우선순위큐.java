package samcope;

import java.util.*;

public class 이중우선순위큐 {
    static PriorityQueue<Integer> pQ;
    public static void main(String[] args) {
//        String[] operations =  {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = new int[2];
        pQ = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(oper.equals("I")){
                pQ.add(num); //pQ에 값 추가
                System.out.println("---------------------");
                System.out.println("num 추가 : " + num);
                System.out.println("현재 pQ");
                for(Integer n : pQ) System.out.println(n);
            }
            else {
                //num==1 : 최댓값 삭제, num==-1 : 최소값 삭제
                removeNum(num);
            }
        }

        if(pQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            PriorityQueue<Integer> pQ_rev = new PriorityQueue<>(Comparator.reverseOrder());
            for(Integer num : pQ) {
                pQ_rev.add(num);
            }
            answer[0] = pQ_rev.remove();
            answer[1] = pQ.remove();
        }

        System.out.println("["+answer[0]+", "+answer[1]+"]");
    }

    static void removeNum(int removeFlag){
        if(!pQ.isEmpty()){ // 빈 큐일 때, 데이터 삭제 불가능
            //최댓값 삭제
            if(removeFlag==1){
                System.out.println("---------------------");
                System.out.println("최대값 삭제 전 pQ");
                for(Integer num : pQ) System.out.println(num);
                PriorityQueue<Integer> pQ_rev = new PriorityQueue<>(Comparator.reverseOrder());
                for(Integer num : pQ) pQ_rev.add(num);
                int maxNum = pQ_rev.remove();
                pQ.remove(maxNum);
                System.out.println("최대값 삭제 후 pQ");
                for(Integer num : pQ) System.out.println(num);
            }
            //최소값 삭제
            else{
                System.out.println("---------------------");
                System.out.println("최소값 삭제 전 pQ");
                for(Integer num : pQ) System.out.println(num);
                pQ.remove();
                System.out.println("최소값 삭제 후 pQ");
                for(Integer num : pQ) System.out.println(num);
            }
        }
    }
}
