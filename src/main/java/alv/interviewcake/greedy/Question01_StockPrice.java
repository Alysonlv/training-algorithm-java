package alv.interviewcake.greedy;
/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

public class Question01_StockPrice {

    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

        System.out.println(getMaxProfit(stockPricesYesterday));
    }

    public static int getMaxProfit(int[] stockPricesYesterday) {
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        for (int i = 1; i < stockPricesYesterday.length; i++) {
            int potentialProfit = stockPricesYesterday[i] - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, stockPricesYesterday[i]);
        }

        return maxProfit;
    }
}
