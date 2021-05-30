package Arrays.day21;

/**
 * @author sunchuanjia
 * @Description 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * 示例1:
 *
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 * 示例2:
 *
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。

 * @create 2021-03-27 9:26
 */
public class exercise495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int answer = 0;
        int length = timeSeries.length;
        if(length == 0 || timeSeries == null) return 0;
       if(length == 1) return duration;
       for(int i=0;i<length-1;i++)
       {
           answer += Math.min(duration,timeSeries[i+1]-timeSeries[i]);
       }
        return answer + duration;
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        exercise495 e = new exercise495();
        int poisonedDuration = e.findPoisonedDuration(nums, 2);
        System.out.println(poisonedDuration);
    }
}
