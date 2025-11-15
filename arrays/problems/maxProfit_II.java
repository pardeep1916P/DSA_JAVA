public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i=1; i<prices.length; i++){
        //current day price is greater than previous days price
        if(prices[i]>prices[i-1]) profit += prices[i]-prices[i-1];
    }
    return profit;
}