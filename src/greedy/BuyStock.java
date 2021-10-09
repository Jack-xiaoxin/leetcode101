package greedy;

public class BuyStock {

    public static void main(String[] args) {
        System.out.println(new BuyStock().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    //想的有点复杂了
    public int maxProfit(int prices[]) {
        int profit = 0;
        int buy = -1, sell = -1;
        for(int i = 0; i < prices.length; i++) {
            if(buy == -1 ) buy = i;
            else if(prices[i] < prices[buy] && ((sell != -1 && i < sell) || sell == -1)) buy = i;
            else if(sell == -1 || prices[i] > prices[sell]) sell = i;
            else {
                profit += prices[sell] - prices[buy];
                buy = i;
                sell = -1;
            }
        }
        if(buy != -1 && sell != -1) profit += prices[sell] - prices[buy];
        return profit;
    }

    //当天买，当天还可以卖，所以只要今天比昨天高，就可以卖了
    public int maxProfix2(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i-1]);
        }
        return profit;
    }
}