package Arrays.day06;

/**
 * @author sunchuanjia
 * @Description 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *

 * @create 2021-03-11 9:45
 */
public class exercise45 {

    //贪心算法 法1：从后往前寻找，假设多个位置能一步跳到最后一个位置，那么倒数第一个位置的最大值离目标位置最远，即下标i最小(从左往右遍历)，然后我们再
    //以i为终点，往前寻找下一个离他最远的点，直到找到起始点。
    public int jump(int[] nums) {
        int position = nums.length - 1;//终点位置
        int step = 0;
        while (position > 0)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(i + nums[i] >= position){
                    position = i;//找到了离终点最远的点i    ---->>>   反向查找
                    step++;
                    break;
                }
            }
        }

        return  step;
    }

    //法2 正向查找，选择每次出发点能经过一次跳跃能到的最远位置，并从该位置出发再次跳跃，直到最终位置。
    //每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！

    /*

        题目说明：假设你总是可以到达数组的最后一个位置。
        即一定存在一条路线能够到达最后一个位置，而不是说中间没有 0 ，只是存在可以越过 0 的路线

        贪心算法：找能跳的最远的
        使用 k 记录目前能够跳到的最高位置  --->>> maxPosition
        使用 end 记录这次跳跃的边界，到达边界就跳跃次数 + 1

        过程解析：
        最开始遍历 i = 0, end = 0,因此 step 会进行 step ++，我们可以认为，这是开始起跳，因为必定会落下，因此跳跃次数 + 1
        而 nums[0] 这个数限制了你只能在落脚在某个范围内，假如 nums[0] = 4，那么你只能选择落脚在 [1, 4] 位置，而如果到了边界，那么肯定是一次新的起跳，因此次数需要再 + 1

        从 0 位置开始起跳，你落脚的必定是 [1, 4] 位置中能够跳得更远的，因为根据贪心思想，这样做能够尽可能的减少跳跃次数，因为更加接近最后一个位置
        而在这个过程遍历 [1, 4] 过程中一直记录着最远位置 k，而你落地在 [1, 4] 之间，落地的那个点也就是 [1, 4] 之间最能够跳得远的那个位置，因此当到达边界的时候，将 end 更新为 k

        注意：[1, 4] 跳得最远的位置必定不会在 [1, 4] ，因为如果在 [1, 4] ，那么表示根本就出不去 [1, 4] 这个圈
        当然不会是 [4,1,1,1,0,1,2] 这种的，因为如果是这种的，压根过不去这个 0，因此必定第一次起跳必定能够跳出 [1, 4] 这个范围，比如 [4,1,1,1,1,1,0]
        */
    public int jump1(int[] nums){
        int lenngth = nums.length;
        int end = 0;// 记录跳跃的边界，到达边界跳跃一次
        int maxPosition = 0;// 目前能跳到的最远位置
        int step = 0;
        for(int i=0;i<lenngth-1;i++)
        {
            //找目前能跳的最远的
            maxPosition = Math.max(maxPosition,nums[i]+i);

            if( i == end)//遇到边界，可以跳范围内最远的那一次，就更新边界，并且步数加一
            {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }

    //复习贪心算法
    public int jump2(int[] nums)
    {
        int length = nums.length;
        int end = 0;//设置的每一次跳跃范围最大距离边界，达到边界即可在该范围内跳一次
        int maxPosition = 0;
        int step=0;
        for(int i=0;i<length;i++)
        {
            maxPosition = Math.max(maxPosition,i+nums[i]);//每个位置的最大跳跃范围
            if(i==end)
            {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    //从后往前遍历，往前找能跳到最后位置最远的点，看能否回到原点,
    public int jump3(int[] nums)
    {
        int step = 0;
        int length = nums.length;
        int position = length - 1;
        while (position>0)
        {
            for(int i=0;i<length;i++)
            {
                if( i + nums[i] >= position)
                {
                    position = i;//将离终点最远的位置重新作为新的终点，直到返回原点为止
                    step ++;
                    break;
                }
            }
        }

        return step;

    }


}
