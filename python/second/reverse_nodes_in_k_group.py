class Solution(object):
    # O(n) time | O(1) space
    def reverseKGroup(self, head, k):
        """
        :type head: Optional[ListNode]
        :type k: int
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0, None)
        groupPrev = dummy
        curr = head

        while curr:
            kth = self.getKth(curr, k - 1)
            if not kth:
                break

            groupNext = kth.next
            kth.next = None

            reversed = self.reverse(curr) 

            revHead = reversed[0]
            revTail = reversed[1]

            groupPrev.next = revHead
            if not dummy.next: 
                dummy.next = revHead
            
            revTail.next = groupNext
            curr = groupNext
            groupPrev = revTail
        
        return dummy.next
    
    def reverse(self, node):
        prev = None
        curr = node
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return (prev, node)

    def getKth(self, curr, k):
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr
        


class ListNode(object):
    def __init__(self, val, next = None):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res


head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))

solution = Solution()
print(solution.reverseKGroup(head, 2))
