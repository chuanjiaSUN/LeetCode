package Arrays.day01;

import org.junit.jupiter.api.Test;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-06 16:36
 */
public class test {
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

//        for(int x:newNums){
//            System.out.println(x);
//        }

        for(i=2;i<size;i++){
            if(newNums[i]<newNums[i-1]){
                newNums[0] = newNums[i];
                for(j=i-1;newNums[j]>newNums[0]&&j>=0;j--){
                    newNums[j+1] = newNums[j];
                }
                newNums[j+1] = newNums[0];
            }
        }
//        for(i=1;i<newNums.length;i++){
//            System.out.println(newNums[i]);
//        }


        if((m+n)%2 == 0){
            i = (m+n)/2;
            return (double) (newNums[i]+newNums[i+1])/2;
        }else{
            i = (m+n)/2+1;
            return (double) newNums[i];
        }


    }

    @Test
    public void test(){
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }
}
