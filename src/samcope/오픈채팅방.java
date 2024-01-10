package samcope;

import java.util.*;

class Record{
    String id;
    String action;

    public Record(String id, String action) {
        this.id = id;
        this.action = action;
    }
}
public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer;

        Map<String, String> map = new HashMap<>();
        Deque<Record> deque = new ArrayDeque<>();

        for (int i = 0; i < record.length ; i++) {
            String[] recordSplit = record[i].split(" ");
//            System.out.println("-----------------------");
//            for(String splitStr : recordSplit) {
//                System.out.println(splitStr);
//            }
//            System.out.println("-----------------------");

            //Enter
            // recordSplit[0] : Enter, recordSplit[1] : uid1234, recordSplit[2] : Muzi
            if(recordSplit[0].equals("Enter")) {
                map.put(recordSplit[1], recordSplit[2]);
                deque.addLast(new Record(recordSplit[1], recordSplit[0]));
            }
            //Leave
            // deque에 출입 정보 add
            else if(recordSplit[0].equals("Leave")) {
                deque.addLast(new Record(recordSplit[1], recordSplit[0]));
            }
            //Change
            //Map 해당 id에 nickName 정보 Upate
            //출입한 것이 아니기 때문에 deque에 출입 정보 add할 필요 X
            else {
                map.put(recordSplit[1], recordSplit[2]);
            }
        }

        //결과 출력
        int index=0;
        answer = new String[deque.size()];
        while(!deque.isEmpty()){
            Record rec = deque.removeFirst();
            if(rec.action.equals("Enter")){
                answer[index] = map.get(rec.id) + "님이 들어왔습니다.";
            }
            else if(rec.action.equals("Leave")){
                answer[index] = map.get(rec.id) + "님이 나갔습니다.";
            }
            index++;
        }

        for(String str : answer){
            System.out.println(str);
        }
    }
}
