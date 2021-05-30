package Arrays.day05;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author sunchuanjia
 * @Description 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * @create 2021-03-10 16:22
 */
public class exercise41 {

    // 法1 排序后找出第一个大于0的位置，从那个位置开始遍历找最小值
    public int firstMissingPositive(int[] nums) {
        //对Nums排升序
        Arrays.sort(nums);
        if(nums.length==0)
        {
            return 1;
        }
        if(nums.length == 1 && nums[0]<=0){
            return 1;
        }

        //二分查找，找出nums数组中第一个大于0的位置
        int left = 0,high = nums.length-1,mid;
        while(left<high)
        {
            mid = (left + high)/2;
            if(nums[mid]>0)
            {
                high = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] <= 0)
        {
            left = left + 1;
        }

        //从nums数组中第一个大于0的位置开始遍历，额外申请一个空间存储由1递增的元素，只要遍历过程中nums[i]>j,就返回j，表示第j个位置空缺，也是最小整数
        //如果nums数组中存在重复元素，则跳过,j不递增。
        int j = 1;
        for(int i=left;i<nums.length;i++)
        {
            if(i>left && nums[i]==nums[i-1]) continue;
            if(nums[i]>j) return j;
            j++;
        }
        return j;//到最后还未返回，说明nums数组按照由1挨个递增排列，因此返回j

    }

    // 法2  如果将数组放进做成哈希表，空间复杂度为O(n),并从1开始枚举元素是否在哈希表中，时间复杂度为O(n)
    //修改数组，并遍历数组时间复杂度为O(n),维护几个变量进行查找，空间复杂度为O(n);
    public int firstMissingPositive1(int[] nums){
        int length = nums.length;

        //将数组中小于0的数转为正数，从而好对元素打标记
        for(int i=0;i<length;i++)
        {
            if(nums[i]<=0){
                nums[i] = length+1;
            }
        }
        //将在[1,length]范围的数做标记，即若x在范围内，则将数组中x-1位置的数取为负数，因此为做标记的位置则为没有出现的数。
        for(int i=0;i<length;i++)
        {
            if(nums[i]<=length)
            {
                nums[nums[i]-1] = -nums[nums[i]-1];
            }
        }

        //搜索数组中元素大于0的第一个位置
        for(int i=0;i<length;i++)
        {
            if(nums[i]>0)
            {
                return i+1;
            }
        }

        return length + 1;//没找到，则每一个元素都在[1,length]内依次出现了

    }

    //法3 哈希数组 -->> 置换  遍历数组，若 x = nums[i] ,且x 在[1,N] 范围内，则将x-1 位置的数与nums[i]互换，将不在[1,n]的元素改为-1
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            //如果 x-1 位置元素的值与 x相等会无限循环交换，因此要跳出循环
            while(nums[i]>=1 && nums[i]<=n && nums[i] != nums[nums[i]-1])//类似一个哈希函数
            {
                int x = nums[i];
                nums[i] = nums[x -1];
                nums[x - 1] = x;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i] != i+1)
            {
                return i+1;
            }
        }
        return n;
    }

    //法4 哈希表  空间复杂度高，为O(N)
    public int firstMissingPositive3(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        for(int i=1;i<=nums.length;i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return nums.length + 1;
    }


    //写个快排
    public void QuickS(int[] nums,int low,int high)
    {
        int pivot;
        if(low < high)
        {
            pivot = getPivot(nums,low,high);

            QuickS(nums,low,pivot-1);
            QuickS(nums,pivot+1,high);
        }
    }

    public int getPivot(int[] nums,int low,int high)
    {
        int pivotKey;
        pivotKey = nums[low];
        while (low<high)
        {
            while( low<high && nums[high]>=pivotKey) {
                high--;
            }
            swap(nums,low,high);
            while (low<high && nums[low]<=pivotKey){
                low++;
            }
            swap(nums,low,high);
        }

        return low;
    }

    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


    public static void main(String[] args) {
        int[] nums = {7,2,4,8,12,6,3,75,54,23,77,1,5,89,45};
        exercise41 e = new exercise41();
        int n = nums.length;
        e.QuickS(nums,0,n-1);
        for(int i:nums){
            System.out.println(i);
        }

    }


}
