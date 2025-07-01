from collections import deque

class Solution(object):
    # O(n) time | O(n) space
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        res = []
        if not root:
            return res
        
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            res.append(q[-1].val)

            for i in range(size):
                pop = q.popleft()
                if pop.left:
                    q.append(pop.left)
                
                if pop.right:
                    q.append(pop.right)

        return res

class TreeNode(object):
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        result = str(self.val)
        result += str(self.left) if self.left else ''
        result += str(self.right) if self.right else ''
        return result 


root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.left.left = TreeNode(5)

solution = Solution()
print(solution.rightSideView(root))

