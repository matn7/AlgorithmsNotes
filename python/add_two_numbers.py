class Solution(object):
    # O(n) time | O(n) space
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0)
        curr = dummy
        carry = 0

        def helper(l1, l2, carry, curr):
            if not l1 and not l2:
                if carry:
                    curr.next = ListNode(carry)
                return
            
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            val = val1 + val2 + carry
            curr.next = ListNode(val % 10)
            carry = val // 10
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            curr = curr.next
            helper(l1, l2, carry, curr)

        helper(l1, l2, carry, curr)

        return dummy.next

    # O(n) time | O(n) space
    def addTwoNumbersIter(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0)
        curr = dummy
        carry = 0

        def helper(l1, l2, carry, curr):
            if not l1 and not l2:
                if carry:
                    curr.next = ListNode(carry)
                return
            val 

        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            val = val1 + val2 + carry
            carry = val // 10
            curr.next = ListNode(val % 10)

            curr = curr.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        return dummy.next


class ListNode(object):
    def __init__(self, val, next = None):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res
    
l1 = ListNode(2, ListNode(4, ListNode(3, None)))
l2 = ListNode(5, ListNode(6, ListNode(4, None)))

solution = Solution()

print(solution.addTwoNumbers(l1, l2))