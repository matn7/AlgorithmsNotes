class Solution(object):
    # O(n) time | O(n) space
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        origToNew = {}
        curr = head

        while curr:
            origToNew[curr] = Node(curr.val)
            curr = curr.next
        
        print(origToNew)
        curr = head
        while curr:
            currNext = curr.next
            currRandom = curr.random

            newCurr = origToNew[curr]
            newCurrNext = origToNew[currNext] if currNext else None
            newCurrRandom = origToNew[currRandom] if currRandom else None

            newCurr.next = newCurrNext
            newCurr.random = newCurrRandom

            curr = curr.next
        
        return origToNew[head] if head else None


class Node(object):
    def __init__(self, val, next = None, random = None):
        self.val = val
        self.next = next
        self.random = random
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res
    
node7 = Node(7)
node13 = Node(13)
node11 = Node(11)
node10 = Node(10)
node1 = Node(1)

node7.next = node13
node13.next = node11
node11.next = node10
node10.next = node1

node7.random = None
node13.random = node7
node11.random = node1
node10.random = node11
node1.random = node7

solution = Solution()
print(solution.copyRandomList(node7))