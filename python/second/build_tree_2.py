class Solution(object):
    # O(n) time | O(n) space
    idx = 0
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if self.idx == len(preorder) or len(inorder) == 0:
            return None
        
        nodeVal = preorder[self.idx]

        newNode = TreeNode(nodeVal)

        i = 0
        while inorder[i] != nodeVal:
            i += 1
        
        leftIn = inorder[0:i]
        rightIn = inorder[i+1:]

        self.idx += 1
        newNode.left = self.buildTree(preorder, leftIn)
        newNode.right = self.buildTree(preorder, rightIn)

        return newNode


class TreeNode(object):
    def __init__(self, val, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right