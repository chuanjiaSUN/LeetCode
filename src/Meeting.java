import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-10-22 9:53
 */
public class Meeting {
    String name;
    char type;
    double cost;
    public Meeting(){}
    public Meeting(String name, char type, double cost){
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    static final int MAX_COST = 8;
    public void calMeeting(String[] meetings){
        if (meetings == null || meetings.length == 0){
            return;
        }
        int len = meetings.length;
        if (len % 3 != 0){
            return;
        }
        List<Meeting> source = getInputMeeting(meetings, len);
        PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.type == o2.type){
                    return (int)(o2.cost - o1.cost);
                }else{
                    return o1.type - o2.type;
                }
            }
        });
        for (Meeting meet : source){
            queue.offer(meet);
        }
        int sum = 0;
        int day = 1;
        while (!queue.isEmpty()){
            if (sum == 0){
                System.out.println("Day " + day + ":");
            }
            if (!queue.isEmpty() && sum + queue.peek().cost < MAX_COST){
                Meeting cur = queue.poll();
                sum += cur.cost;
                System.out.println(cur.name + ", " + cur.type + ", " + cur.cost);
            }else{
                sum = 0;
                day++;
            }
        }
    }

    private List<Meeting> getInputMeeting(String[] meetings, int len) {
        List<Meeting> ans = new ArrayList<>();
        for (int i = 0; i < len; i += 3){
            String name = meetings[i];
            char type = meetings[i + 1].charAt(0);
            double cost = Double.parseDouble(meetings[i + 2]);
            ans.add(new Meeting(name, type, cost));
        }
        return ans;
    }

    public static void main(String[] args) {
        Meeting test = new Meeting();
        String[] meets = {"conference1", "A","4.5","conference2", "B", "3","conference4", "C","2.5",
                "conference3", "A","2.5","conference5", "C","1.5"};
        test.calMeeting(meets);
    }
}
