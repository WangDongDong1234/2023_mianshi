package niukewang.动态规划;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class C8买卖股票最佳时间仅一次买卖121 {

    public int maxProfit(int prices[]) {
        // 最低价格，初始值最大，保证了要先买
        int minprice = Integer.MAX_VALUE;
        // 最大营收
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                //当前价格小于最小的谷值时修改min_prices
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                //当前获得的利润大于最大的利润时修改max_profit
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


}
