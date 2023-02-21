package newstep.progression.leet;

public class BestTimeToBuyAndSellStock_121_Easy {
    public int maxProfit(int[] prices) {
        int minProfit = prices[0];
        int maxProfit = 0;

        for (int i = 0; i< prices.length; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }

        return maxProfit;
    }
}
