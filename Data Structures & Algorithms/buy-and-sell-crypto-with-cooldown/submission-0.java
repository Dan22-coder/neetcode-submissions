class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();

        return solve(prices, 0, true, map);
    }

    //true = buy
    //false = sell

    public static int solve(int[] prices, int i, boolean buying, HashMap<String, Integer> map){
        if(i >= prices.length){
            return 0;
        }

        String key = i + " " + buying;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int maxProfit;

        if(buying){
            int buy = solve(prices, i + 1, false, map) - prices[i];
            int coolDown = solve(prices, i + 1, true, map);

            maxProfit = Math.max(buy, coolDown);
        }else{
            int sell = solve(prices, i + 2, true, map) + prices[i];
            int coolDown = solve(prices, i + 1, false, map);

            maxProfit = Math.max(sell, coolDown);
        }

        map.put(key, maxProfit);

        return maxProfit;
    }
}