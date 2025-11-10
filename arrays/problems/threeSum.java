private int[] merge(int[] arr1,int[] arr2){
    int i=0,j=0,k=0,m=arr1.length,n=arr2.length;
    int[] arr = new int[m+n];
    while(i<m && j<n){
        if(arr1[i]<arr2[j]) arr[k++] = arr1[i++];
        else arr[k++] = arr2[j++];
    }
    while(i<m) arr[k++] = arr1[i++];
    while(j<n) arr[k++] = arr2[j++];
    return arr;
}

private int[] mergeSort(int[] arr){
    if(arr.length==1) return arr;
    int mid = arr.length/2;
    int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
    return merge(left,right);
}
public List<List<Integer>> threeSum(int[] nums) {
    nums = mergeSort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    for(int i=0;i<n-2;i++){
        if(i>0 && nums[i]==nums[i-1]) continue; //skip as dupicate encountered
        int left = i+1,right = n-1;
        while(left<right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                while(left<right && nums[left]==nums[left+1]) left++;
                while(left<right && nums[right]==nums[right-1]) right--;
                left++;
                right--;
            }else if(sum<0) left++;
            else right--;
        }
    }
    return result;
}