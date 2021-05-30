package Arrays.day01;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-06 17:42
 */
public class exercise4 {

    //法1 暴力解法，合并2个数组，插排时间复杂度为(m*n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m+n+1;
        int[] newNums = new int[size];
        int i,j;
        newNums[0] = 0;
        for(i=0;i<m;i++){
            newNums[i+1] = nums1[i];
        }

        for(i=0;i<n;i++){
            newNums[m+i+1] = nums2[i];
        }

        for(i=2;i<size;i++){
            if(newNums[i]<newNums[i-1]){
                newNums[0] = newNums[i];
                for(j=i-1;newNums[j]>newNums[0]&&j>=0;j--){
                    newNums[j+1] = newNums[j];
                }
                newNums[j+1] = newNums[0];
            }
        }

        if((m+n)%2 == 0){
            return (double) (newNums[(size-1)/2]+newNums[(size-1)/2+1])/2;
        }else{
            return (double) newNums[size/2];
        }

    }

    //法2 归并排序  时间复杂度为(m+n) 空间复杂度(m+n)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums;
        nums = new int[m + n];

        if (n == 0 && m != 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
            } else {
                return nums1[m / 2];
            }
        } else if (n != 0 && m == 0) {
            if (n % 2 == 0) {
                return (nums2[m / 2 - 1] + nums2[m / 2]) / 2;
            } else {
                return nums2[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {

            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (double) (nums[count / 2 - 1] + nums[count / 2]) / 2;
        } else {
            return (double) (nums[count / 2]);
        }
    }

        //法3 找到中位数的位置k，相当于取合并后数组第k小的值，对两个数组分别折半查找，A[i]<B[i]时，抛弃A数组前K/2个，因为这时第K小的数一定在B数组里
        public double findMedianSortedArrays2(int[] nums1, int[] nums2){
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m  + 1)/2;
            int right = (n + m + 2)/2;
            //奇数和偶数合并
            return  (double) (getNumK(nums1,0,n-1,nums2,0,m-1,left)+getNumK(nums1,0,n-1,nums2,0,m-1,right))*0.5;
        }

        public int getNumK(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //让len1 的长度小于 len2,这样当len1长度被抛弃到0时,第k小的数就在nums2上
            if(len1>len2){
                return getNumK(nums2,start2,end2,nums1,start1,end1,k);
            }

            if(len1 == 0){
                return nums2[start2+k-1];
            }

            if(k==1){
                return Math.min(nums1[start1],nums2[start2]);
            }

            int i=start1+Math.min(k/2,len1)-1;//当k很大时，相当于直接抛弃一个数组的所有值
            int j=start2+Math.min(k/2,len2)-1;//Math.min计算的每次比较需要抛弃的长度

            if(nums1[i]>nums2[j]){
                //当Num1数组值更大时，说明第k个数应该在num1数组上
                return getNumK(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
            }else{
                //当Num2数组值更大时，说明第k个数应该在num2数组上,应抛弃nums1上的k/2长度的数
                return getNumK(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
            }


        }



    public static void main(String[] args) {
        exercise4 exercise4 = new exercise4();
        int[] nums1 = {1,2,3,8};
        int[] nums2 = {3,4,7};
        double medianSortedArrays1 = exercise4.findMedianSortedArrays1(nums1, nums2);
        double medianSortedArrays = exercise4.findMedianSortedArrays(nums1, nums2);
        double medianSortedArrays2 = exercise4.findMedianSortedArrays2(nums1, nums2);
        System.out.println(medianSortedArrays1);
        System.out.println(medianSortedArrays);
        System.out.println(medianSortedArrays2);
    }
}
