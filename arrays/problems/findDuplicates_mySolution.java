//my approach using merge sort
private int[] merge(int[] arr1,int[] arr2){
    int i=0,j=0,k=0,m=arr1.length,n=arr2.length;
    int[] arr = new int[m+n];
    while(i<m && j<n){
        if(arr1[i]<=arr2[j]) arr[k++] = arr1[i++];
        else arr[k++] = arr2[j++];
    }
    while(i<m) arr[k++] = arr1[i++];
    while(j<n) arr[k++] = arr2[j++];
    return arr;
}

private int[] mergeSort(int[] arr){
    if(arr.length == 1) return arr;
    int mid = arr.length/2;
    int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
    return merge(left,right);
}
public List<Integer> findDuplicates(int[] nums) {
    nums = mergeSort(nums);
    List<Integer> duplicates = new ArrayList<>();
    int i = 1;
    while(i<nums.length){
        if(nums[i] == nums[i-1]){
            duplicates.add(nums[i]);
            while(i<nums.length && nums[i] == nums[i-1]) i++;
        }
        else i++;
    }
    return duplicates;
}