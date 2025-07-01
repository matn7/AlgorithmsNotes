import heapq
class Solution(object):
    # O(n^2 log(n)) time | O(n^2) space
    def minCostConnectPoints(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        adj = {}
        for i in range(len(points)):
            adj[i] = []
        
        for i in range(len(points)):
            curr = points[i]
            for j in range(i, len(points)):
                other = points[j]
                dist = abs(curr[0] - other[0]) + abs(curr[1] - other[1])
                adj[i].append((dist, j))
                adj[j].append((dist, i))
        
        res = 0
        visited = set()
        minHeap = [(0, 0)]

        while minHeap:
            current = heapq.heappop(minHeap)
            d1 = current[0]
            n1 = current[1]
            if n1 in visited:
                continue
            visited.add(n1)
            res += d1

            neighbors = adj[n1]
            for nei in neighbors:
                d2 = nei[0]
                n2 = nei[1]
                if not n2 in visited:
                    heapq.heappush(minHeap, (d2, n2))
        return res

solution = Solution()
points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
print(solution.minCostConnectPoints(points))


