class Solution(object):
    # O(v + e) time | O(v) space
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None
        
        origToNew = {}

        queue = []
        queue.append(node)
        visited = set()

        while queue:
            curr = queue.pop()
            if curr not in origToNew:
                origToNew[curr] = Node(curr.val)
            if curr.val in visited:
                continue
            visited.add(curr.val)

            newCurr = origToNew[curr]
            for nei in curr.neighbors:
                if nei not in origToNew:
                    origToNew[nei] = Node(nei.val)
                newCurr.neighbors.append(origToNew[nei])
                queue.append(nei)
        
        return origToNew[node]


class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)

node1.neighbors.append(node2)
node1.neighbors.append(node4)
node2.neighbors.append(node1)
node2.neighbors.append(node3)
node3.neighbors.append(node2)
node3.neighbors.append(node4)
node4.neighbors.append(node3)
node4.neighbors.append(node1)

solution = Solution()
print(solution.cloneGraph(node1))