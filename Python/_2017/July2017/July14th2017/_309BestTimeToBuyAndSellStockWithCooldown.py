class Solution(object):
    def maxProfit(self, prices):
        waitToBuy, waitToSell, wait= float("-inf"), 0, 0
        for x in prices:
            waitToBuy, waitToSell, wait= max(waitToBuy, waitToSell - x), max(waitToSell, wait), waitToBuy + x
        return max(waitToBuy, max(waitToSell, wait))