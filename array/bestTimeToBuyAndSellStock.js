/**
 * @param prices: Given an integer array
 * @return: Maximum profit
 */

 // dynamic programming
var num = [3,2,3,1,2];

const maxProfit = function (prices) {
    if (prices === null || prices.length <= 1) {
      return 0;
    }

    // 1. state definition
    var f = [];
    var result = 0;
    // 2. state initialization
    f[0] = 0;
    for (let i = 1; i < prices.length; i++) {
      f[i] = -Infinity;
    }
  
    // 3. state transition
    for (let i = 1; i < prices.length; i++) {

      for (let j = 0; j < i; j++) {
        f[i] = Math.max(f[i], prices[i] - prices[j]);
      }
    }
    console.log(f);
    // 4. get the maximum profit
    for (let ele of f) {
      result = Math.max(ele, result);
    }
    return result;
}

console.log(maxProfit(num));


// version 2 two pointer xiangxiangxing
const maxProfit = function (prices) {
    if (prices === null || prices.length === 0) {
        return 0;
    }
    // var min = Number.MAX_VAULE;
    var min = Infinity; // --> left pointer
    var profit = 0;	    // --> ele is right pointer
    for (let ele of prices) {
    	min = Math.min(min, ele); // get the current min
    	profit = Math.max(profit, ele - min);
    }

    return profit;
}

// version 3
const maxProfit = function (prices) {
    if (prices === null || prices.length <= 1) {
      return 0;
    }

    // 1. state definition
    var f = [];
    var result = 0;
    // 2. state initialization
    f[0] = 0;
    // for (let i = 1; i < prices.length; i++) {
    //   f[i] = -Infinity;
    // }
  
    // 3. state transition
    var min = prices[0];
    for (let i = 1; i < prices.length; i++) {
    	min = Math.min(min, prices[i]);
    	f[i] = Math.max(f[i - 1], prices[i] - min);
    }
    // console.log(f);
    // 4. get the maximum profit
    for (let ele of f) {
      result = Math.max(ele, result);
    }
    return result;
}