class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
      
        int prev11=0;
        int prev12=0;

        int prev01=0;
        int prev02=0;
        for(int i=1; i<nums.length; i++){
            
            int temp1=prev11;
            prev11=Math.max(prev12+nums[i],prev11);
            prev12=temp1;
            
            int temp2=prev01;
            prev01=Math.max(prev02+nums[i-1],prev01);
            prev02=temp2;
        }
        return Math.max(prev01,prev11);
    }
}