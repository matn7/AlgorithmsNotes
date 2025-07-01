class Solution(object):
    # O(V + E) time | O(V + E) space
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        adj = {}
        for i in range(numCourses):
            adj[i] = []
        
        for pre in prerequisites:
            s = pre[0]
            d = pre[1]
            sNode = adj[s]
            sNode.append(d)
        
        def cycle(node):
            if node in visited:
                return False
            if node in visiting:
                return True
            
            visiting.add(node)
            neighbors = adj[node]

            for nei in neighbors:
                if cycle(nei):
                    return True

            visiting.remove(node)
            visited.add(node)
            return False


        visited = set()
        visiting = set()
        for c in range(numCourses):
            if not c in visited:
                if cycle(c):
                    return False
        return True
    
# prerequisites = [[1,2], [0, 1], [2,0], [3,1], [3,2]]   
prerequisites = [[1,0], [2,0], [3,1], [3,2]]    
numCourses = 4

solution = Solution()
print(solution.canFinish(numCourses, prerequisites))