package Arrays.day11;

/**
 * @author sunchuanjia
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]

 * @create 2021-03-17 14:00
 */
public class exercise88 {
    //法1 从后往前合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1,p2 = n - 1;
        int length = nums1.length;
        int p=m + n - 1 ;
        while(p1>=0 && p2>=0)
        {
            nums1[p--] = (nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--]);
        }
        while (p1>=0)
        {
            nums1[p--] = nums1[p1--];
        }
        while (p2>=0)
        {
            nums1[p--] = nums2[p2--];
        }
    }
}
