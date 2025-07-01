class Solution:
    # O(V + E) time | O(V + E) space
    def validTree(self, n, edges):
        adj = {}
        for i in range(n):
            adj[i] = []
        
        for edge in edges:
            s = edge[0]
            d = edge[1]
            adj[s].append(d)
            adj[d].append(s)
        
        visited = set()

        def cycle(node, prev):
            if node in visited:
                return True
            
            visited.add(node)
            for nei in adj[node]:
                if nei == prev:
                    continue
                if cycle(nei, node):
                    return True
            
            return False

        if (cycle(0, -1)):
            return False

        return len(visited) == n

# n = 5
# edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

solution = Solution()
print(solution.validTree(n, edges))
        