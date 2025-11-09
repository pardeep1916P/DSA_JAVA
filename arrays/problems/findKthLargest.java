private int[] merge(int[] arr1,int[] arr2){
    int[] arr = new int[arr1.length+arr2.length];
    int i=0,j=0,k=0;
    while(i<arr1.length && j<arr2.length){
        if(arr1[i]<arr2[j]) arr[k++] = arr1[i++];
        else arr[k++] = arr2[j++];
    }
    while(i<arr1.length) arr[k++] = arr1[i++];
    while(j<arr2.length) arr[k++] = arr2[j++];
    return arr;
}
private int[] mergeSort(int[] arr){
    if(arr.length == 1) return arr;
    int mid = arr.length/2;
    int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
    return merge(left,right);
}
public int findKthLargest(int[] nums, int k) {
    if(nums.length==0||k==0) return 0;
    return mergeSort(nums)[nums.length-k];
}