import heapq
class MedianFinder(object):

    def __init__(self):
        self.smaller = []   
        self.larger = []

    # O(m * log(n)) time | O(n) space
    def addNum(self, num):
        """
        :type num: int
        :rtype: None
        """
        if len(self.smaller) == 0:
            heapq.heappush(self.smaller, -1 * num)
        else:
            peek = -self.smaller[0]
            if num > peek:
                heapq.heappush(self.larger, num)
            else:
                heapq.heappush(self.smaller, -1 * num)

        self.rebalance()
        
    def rebalance(self):
        if len(self.smaller) > len(self.larger) + 1:
            small = heapq.heappop(self.smaller)
            heapq.heappush(self.larger, -1 * small)
        elif len(self.larger) > len(self.smaller) + 1:
            large = heapq.heappop(self.larger)
            heapq.heappush(self.smaller, -1 * large)


    # O(m) time
    def findMedian(self):
        """
        :rtype: float
        """
        if len(self.smaller) > len(self.larger):
            return -self.smaller[0]
        elif len(self.larger) > len(self.smaller):
            return self.larger[0]
        else:
            return (-self.smaller[0] + self.larger[0]) / 2.0
    
solution = MedianFinder()

solution.addNum(1)
solution.addNum(2) 

print(solution.findMedian())

solution.addNum(3)
print(solution.findMedian())