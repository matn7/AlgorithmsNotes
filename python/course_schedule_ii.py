class Solution(object):
    # O(V + E) time | O(V + E) space
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        adj = {}
        for c in range(numCourses):
            adj[c] = []
        
        degree = [0] * numCourses

        for pre in prerequisites:
            d = pre[0]
            s = pre[1]

            adj[s].append(d)
            degree[d] += 1

        zeroDeg = []
        for i in range(len(degree)):
            if degree[i] == 0:
                zeroDeg.append(i)
        
        res = []
        while zeroDeg:
            curr = zeroDeg.pop(0)
            res.append(curr)

            neighbors = adj[curr]
            for nei in neighbors:
                degree[nei] -= 1
                if degree[nei] == 0:
                    zeroDeg.append(nei)

        return res if len(res) == numCourses else []


solution = Solution()
numCourses = 4
prerequisites = [[1,0],[2,0],[3,1],[3,2]]
print(solution.findOrder(numCourses, prerequisites))

