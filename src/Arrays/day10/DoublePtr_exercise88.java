package Arrays.day10;

/**
 * @author sunchuanjia
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
 * @create 2021-03-16 14:21
 */
public class DoublePtr_exercise88 {
    //法1 双指针 从后往前移动
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int p = m + n - 1,p1 = m -1,p2 = n -1;
       while(p1>=0 && p2>=0)
       {
           if(nums1[p1]>nums2[p2])
           {
               nums1[p] = nums1[p1];
               p--;
               p1--;
           }else{
               nums1[p] = nums2[p2];
               p--;
               p2--;
           }
       }
    }

    //双指针。从前往后移动,需要空间存放nums1数组元素
    public void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        int[] arr = new int[m];
        for(int i=0;i<m;i++)
        {
            arr[i] = nums1[i];
        }
        int p1=0,p2=0,p=0;
        while(p1<m && p2<n)
        {
            nums1[p++] = arr[p1]<nums2[p2]?arr[p1++]:nums2[p2++];
        }
        if(p1<m){
            for(int i=p1;i<m;i++)
            {
                nums1[p++] = arr[i];
            }
        }
        if(p2<n)
        {
            for(int i=p2;i<n;i++)
            {
                nums1[p++] = nums2[i];
            }
        }

    }


    public static void main(String[] args) {
        int[] nums1= {1,2,3,0,0,0};
        int[] nums2 ={2,5,6};
        DoublePtr_exercise88 e = new DoublePtr_exercise88();
        e.merge1(nums1,3,nums2,3);
        for(int i:nums1)
        {
            System.out.println(i);
        }
    }
}
