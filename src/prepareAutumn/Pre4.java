package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-10 22:51
 */
public class Pre4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1){
            int midIndex = len / 2;
            return getKthElement(nums1, nums2, midIndex);
        }else{
            int midIndex1 = len / 2 - 1;
            int midIndex2 = len / 2;
            return (getKthElement(nums1, nums2, midIndex1) + getKthElement(nums1, nums2, midIndex2)) / 2.0;
        }

    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while (true){
            //边界情况
            if (index1 == len1){
                return nums2[index2 + k - 1];
            }
            if (index2 == len2){
                return nums1[index1 + k - 1];
            }
            if (k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    /**
     * practice
     * */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] tempArr = new int[len];
        int ind1 = 0, ind2 = 0;
        for (int i = 0; i < len; i++){
            if (ind1 >= m){
                tempArr[i] = nums2[ind2++];
            }else if (ind2 >= n){
                tempArr[i] = nums1[ind1++];
            }else if (nums1[ind1] < nums2[ind2]){
                tempArr[i] = nums1[ind1++];
            }else{
                tempArr[i] = nums2[ind2++];
            }
        }
        if (len % 2 == 0){
            return (tempArr[len / 2] + tempArr[len / 2 - 1]) / 2.0;
        }else{
            return tempArr[len / 2];
        }
    }
}
