class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        tickets.sort()
        adj = {}
        for ticket in tickets:
            s = ticket[0]
            d = ticket[1]
            if not s in adj:
                adj[s] = []
            
            if not d in adj:
                adj[d] = []
            
            adj[s].append(d)
        
        res = []
        res.append("JFK")
        total = len(tickets) + 1

        def backtrack(node):
            if len(res) == total:
                return True
            if not node in adj:
                return False
            
            neighbors = list(adj[node])

            for i in range(0, len(neighbors)):
                nei = adj[node].pop(i)
                res.append(nei)

                if backtrack(nei):
                    return True

                adj[node].append(i, nei)
                res.pop()

            return False

        if backtrack("JFK"):
            return res
        return []
    
tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
solution = Solution()
print(solution.findItinerary(tickets))