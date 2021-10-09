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
}