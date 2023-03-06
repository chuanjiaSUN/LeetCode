package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 12:51
 */
public class Exe4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            int midIdx = totalLen / 2;
            double median = getKthElement(nums1, nums2, midIdx + 1);
            return median;
        } else {
            int midIdx1 = totalLen / 2 - 1, midIdx2 = totalLen / 2;
            double median = (getKthElement(nums1, nums2, midIdx1 + 1) + getKthElement(nums1, nums2, midIdx2 + 1)) / 2.0;
            return median;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int KthElement = 0;

        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIdx1 = Math.min(index1 + half, len1) - 1;
            int newIdx2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIdx1], pivot2 = nums2[newIdx2];
            if (pivot1 <= pivot2) {
                k -= (newIdx1 - index1 + 1);
                index1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - index2 + 1);
                index2 = newIdx2 + 1;
            }
        }
    }

    //划分数组
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int median1 = 0, median2 = 0;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 0) {
            int left = len / 2 - 1;
            int right = len / 2;
            return (getKthNum(nums1, nums2, left + 1) + getKthNum(nums1, nums2, right + 1)) / 2.0;
        } else {
            int index = len / 2;
            return getKthNum(nums1, nums2, index + 1);
        }
    }

    private double getKthNum(int[] nums1, int[] nums2, int kTh) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ind1 = 0, ind2 = 0;
        while (true) {
            if (ind1 == len1){
                return nums2[ind2 + kTh - 1];
            }else if (ind2 == len2){
                return nums1[ind1 + kTh - 1];
            }
            if (kTh == 1){
                return Math.min(nums1[ind1], nums2[ind2]);
            }
            int half = kTh / 2;
            int newInd1 = Math.min(ind1 + half, len1) - 1;
            int newInd2 = Math.min(ind2 + half, len2) - 1;
            if (nums1[newInd1] > nums2[newInd2]){
                kTh -= (newInd2 - ind2 + 1);
                ind2 = newInd2 + 1;
            }else{
                kTh -= (newInd1 - ind1 + 1);
                ind1 = newInd1 + 1;
            }
        }
    }
}
