package Arrays.day26;

/**
 * @author sunchuanjia
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2

 * @create 2021-04-01 14:54
 */
public class exercise4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newArr = new int[ m + n];
        int i = 0, j = 0,cur = 0;
        while(i < m && j < n)
        {
            if(nums1[i] < nums2[j])
            {
                newArr[cur] = nums1[i];
                i++;
            }else if(nums1[i] >= nums2[j])
            {
                newArr[cur] = nums2[j];
                j++;
            }
            cur++;
        }
        if( i == m ){
            while(j < n)
            {
                newArr[cur++] = nums2[j++];
            }
        }else if(j == n)
        {
            while(i < m)
            {
                newArr[cur++] = nums1[i++];
            }
        }
        return 1.0*(newArr[(m + n - 1)/2] + newArr[(m + n)/2])/2;
    }

    //二分查找、分治
    public double findMedianSortedArrays1(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int left = ( n + m + 1)/2;//求两次第k小的数
        int right = ( n + m +2)/2;

        return (getKthNum(nums1,0,m-1,nums2,0,n-1,left) + getKthNum(nums1,0,m-1,nums2,0,n-1,right))*0.5;
    }

    //使用二分查找第k小的数
    private int getKthNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让len1长更小
        if(len1 > len2)return getKthNum(nums2,start2,end2,nums1,start1,end1,k);
        if(len1 == 0) return nums2[start2 + k - 1];

        if( k == 1)return Math.min(nums1[start1],nums2[start2]);

        int i = start1 + Math.min(len1, k/2) - 1;
        int j = start2 + Math.min(len2, k/2) - 1;
        if(nums1[i] > nums2[j])
        {
            return getKthNum(nums1,start1,end1,nums2, j + 1,end2,k-(j - start2 + 1));
        }else{
            return getKthNum(nums1,i + 1,end1,nums2,start2,end2,k-(i - start1 + 1));
        }
    }


    public static void main(String[] args) {
        exercise4 e = new exercise4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = e.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
