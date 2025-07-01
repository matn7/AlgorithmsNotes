class Solution(object):
    # O(V + E) time | O(V) space
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        unionFind = UnionFind(len(edges))
        for edge in edges:
            if not unionFind.union(edge[0], edge[1]):
                return edge
        return []

class UnionFind(object):
    def __init__(self, n):
        self.parent = list(range(n + 1))
        self.rank = [1] * (n + 1)
    
    def find(self, n):
        p = n
        while self.parent[p] != p:
            self.parent[p] = self.parent[self.parent[p]]
            p = self.parent[p]
        return p

    def union(self, n1, n2):
        p1 = self.find(n1)
        p2 = self.find(n2)

        if p1 == p2:
            return False

        if self.rank[p1] >= self.rank[p2]:
            self.parent[p2] = p1
            self.rank[p1] += 1
        else:
            self.parent[p1] = p2
            self.rank[p2] += 1
        return True
        
solution = Solution()
edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]

print(solution.findRedundantConnection(edges))
