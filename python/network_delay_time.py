import heapq
class Solution(object):
    # O(E * log(V)) time | O(V + E) space
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        """
        adj = {}
        for i in range(1, n + 1):
            adj[i] = []
        
        for time in times:
            s = time[0]
            d = time[1]
            w = time[2]
            adj[s].append([d, w])
        
        minheap = [(0, k)]
        costs = [float("infinity")] * (n + 1)
        costs[k] = 0
        visited = set()
        
        maxTime = 0
        print(adj)
        while minheap:
            w1, n1 = heapq.heappop(minheap)
            if n1 in visited:
                continue
            visited.add(n1)
            maxTime = max(maxTime, w1)

            neighbors = adj[n1]
            print(neighbors)
            for nei in neighbors:
                n2 = nei[0]
                w2 = nei[1]
                if w1 + w2 < costs[n2]:
                    costs[n2] = w1 + w2
                    heapq.heappush(minheap, (w1 + w2, n2))
        
        return maxTime if len(visited) == n else -1

times = [[2,1,1],[2,3,1],[3,4,1]]
n = 4
k = 2

solution = Solution()
print(solution.networkDelayTime(times, n, k))

