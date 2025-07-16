class Solution {
    public int maximumLength(int[] nums) {
        int odd=0,even=0,oddEven=0;
        boolean odde;
        if(nums[0]%2==0){ odde=false;even++;}
        else {odde=true;odd++;}
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2==1) odd++;
            else even++;
            if(odde && nums[i]%2==0){
                oddEven++;
                odde=false;
            }else if(!odde && nums[i]%2==1){
                oddEven++;
                odde=true;
            }
        }
        return Math.max(odd,Math.max(even,oddEven+1));
    }
}
