from collections import defaultdict
import heapq
class Solution(object):
    def isNStraightHand(self, hand, groupSize):
        """
        :type hand: List[int]
        :type groupSize: int
        :rtype: bool
        """
        if len(hand) % groupSize != 0:
            return False
        
        counts = defaultdict(int)
        for h in hand:
            counts[h] += 1

        minHeap = []

        for k,v in counts.items():
            minHeap.append([k, v])

        heapq.heapify(minHeap)

        while minHeap:
            prev = minHeap[0]
            start = prev[0]
            addback = []

            for i in range(groupSize):
                if not minHeap:
                    return False
                curr = heapq.heappop(minHeap)

                if curr[0] != i + start:
                    return False
                
                curr[1] -= 1
                if curr[1] > 0:
                    addback.append(curr)
                
            for a in addback:
                heapq.heappush(minHeap, a)
        
        return True

solution = Solution()
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
print(solution.isNStraightHand(hand, groupSize))