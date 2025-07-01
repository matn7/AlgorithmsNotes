
class Solution:
    # O(V + E) time | O(V) space
    def countComponents(self, n, edges):
        count = n
        unionFind = UnionFind(n)

        for edge in edges:
            if unionFind.union(edge[0], edge[1]):
                count -= 1

        return count
    
class UnionFind(object):
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n

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

n = 6
edges = [[0,1], [1,2], [2,3], [4,5]]

print(solution.countComponents(n, edges))