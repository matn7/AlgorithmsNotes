from collections import defaultdict
import heapq
from collections import deque

class Solution(object):
    # O(n) time | O(k) space
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        counts = defaultdict(int)

        for task in tasks:
            counts[task] += 1
        
        maxHeap = [-1 * c for c in counts.values()]
        heapq.heapify(maxHeap)

        queue = deque()
        for i in range(len(maxHeap)):
            pop = heapq.heappop(maxHeap)
            queue.appendleft([-1 * pop, 0])
        
        time = 0
        while queue:
            print(queue[-1])
            if time >= queue[-1][1]:
                curr = queue.pop()
                task = curr[0]
                avail = curr[1]
                task -= 1
                if task > 0:
                    queue.appendleft([task, avail + n + 1])
            time += 1

        return time


tasks = ["A","A","A","B","B","B"]
n = 2

solution = Solution()

print(solution.leastInterval(tasks, n))