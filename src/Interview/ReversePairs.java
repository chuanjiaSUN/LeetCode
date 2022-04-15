package Interview;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-04-12 21:11
 */
public class ReversePairs {

    /**归并排序*/
    public int reversePairs(int[] nums){
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        int[] temp = new int[len];

        return pairs(copy, 0, len - 1, temp);
    }

    private int pairs(int[] copy, int left, int right, int[] temp) {
        if (left == right){
            return 0;
        }

        int mid = (left + right) >> 1;
        int leftPairs = pairs(copy, left, mid, temp);
        int rightPairs = pairs(copy, mid  + 1, right, temp);

        if (copy[mid] <= copy[mid + 1]){
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(temp, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++){
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++){

            if (i == mid + 1){
                nums[k] = temp[j++];
            }else if (j == right + 1){
                nums[k] = temp[i++];
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i++];
            }else{
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }

        return count;
    }

    /**树状数组*/
    public int reversePairs1(int[] nums){
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        Arrays.sort(temp);
        for (int i = 0; i < len; i++){
            nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
        }
        BIT bit = new BIT(len);
        int ans = 0;
        for (int i = len - 1; i >= 0; i--){
            System.out.println("Query " + (nums[i] - 1 ) );
            ans += bit.query(nums[i] - 1);
            bit.update(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
        int[] nums = new int[]{7, 6, 5, 4};
        int i = test.reversePairs1(nums);
        System.out.println("i: " + i);
    }

    static class BIT{
        public int[] tree;
        public int n;

        public BIT(int n){
            this.n = n;
            tree = new int[n + 1];
        }

        public static int lowBit(int x){
            return x & (-x);
        }

        public int query(int x){
            System.out.println("Query");
            int ret = 0;
            while (x != 0){
                ret += tree[x];
                System.out.println("x: " + x + " tree[" +x + "]: " + tree[x]);
                System.out.println("lowBit: " + lowBit(x));
                x -= lowBit(x);
                System.out.println("x:" + x);
            }
            System.out.println("ret: " + ret);
            return ret;
        }

        public void update(int x){
            System.out.println("update X : " + x);
            while (x <= n){
                System.out.println("tree[" + x + "]:" + tree[x] + "--update");
                ++tree[x];
                System.out.println("tree[" + x + "]" + tree[x] + "update--");
                System.out.println("lowBit: " + lowBit(x));
                x += lowBit(x);
                System.out.println("x :  " + x);
            }
        }

        @Override
        public String toString() {
            return "BIT{" +
                    "tree=" + Arrays.toString(tree) +
                    ", n=" + n +
                    '}';
        }
    }
}
