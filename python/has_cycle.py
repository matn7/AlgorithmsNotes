class Solution(object):
    # O(n) time | O(1) space
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        dummy = ListNode(0)
        dummy.next = head
        slow = dummy
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True
        
        return False


class ListNode(object):
    def __init__(self, val, next):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res

head = ListNode(3, None)
head.next = ListNode(2, None)
head.next.next = ListNode(0, None)
head.next.next.next = ListNode(4, None)
head.next.next.next.next = head.next

solution = Solution()
print(solution.hasCycle(head))