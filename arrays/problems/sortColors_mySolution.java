//my approach
public void sortColors(int[] nums) {
    int x=0,y=0,z=0; //3 pointers to count frequencies
    for(int i:nums){
        if(i==0) x++;
        else if(i==1) y++;
        else z++;
    }
    for(int i=0;i<nums.length;i++){ //update array according to the frequencies
        if(x>0){
            nums[i]=0;
            x--;
        }else if(x==0 && y>0){
            nums[i]=1;
            y--;
        }else nums[i]=2;
    }
    return;
}