class Codec:
    # O(n) time | O(n) space
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        return self.preOrder(root)
    
    def preOrder(self, node):
        if not node:
            return "#"
        
        return str(node.val) + " " + self.preOrder(node.left) + " " + self.preOrder(node.right)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        values = iter(data.split(" "))

        def helper():
            nextVal = next(values)
            if nextVal == "#":
                return None
            node = TreeNode(nextVal)
            node.left = helper()
            node.right = helper()
            return node

        return helper()
        
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
root.right.left = TreeNode(4)
root.right.right = TreeNode(5)

codec = Codec()
serialized = codec.serialize(root)

print(serialized)

deserialized = codec.deserialize(serialized)

print(deserialized)
