public int maxProfit(int[] prices) {
    if(prices.length == 0) return 0;
    int min=0,max=0;
    for(int i=0;i<prices.length;i++){
        if(prices[i]<prices[min]) min = i;
        else{
            int profit = prices[i]-prices[min];
            max = (profit>max)? profit : max;
        }
    }
    return max;
}