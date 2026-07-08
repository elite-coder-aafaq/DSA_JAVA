class Solution {
    //By Aafaq Hussain
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int freq=1;
        for (int i = 0; i < n; i++) {
           

            for (int j = i+1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }
            }

            if (freq > n / 2) {
                return nums[i];
            }
            else
            {
                freq=1;
            }
        }

        // problem guarantees majority element exists
        return -1;
    }
}