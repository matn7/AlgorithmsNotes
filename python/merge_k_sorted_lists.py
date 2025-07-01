import heapq

class Solution(object):
    # O(n log(k)) time | O(k) space
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        heap = []

        for lst in lists:
            if lst:
                heapq.heappush(heap, NodeWrapper(lst))

        dummy = ListNode(0)
        curr = dummy

        while heap:
            wrapper = heapq.heappop(heap)
            curr.next = wrapper.node

            if wrapper.node.next:
                heapq.heappush(heap, NodeWrapper(wrapper.node.next))
            curr = curr.next
        
        return dummy.next

class NodeWrapper:
    def __init__(self, node):
        self.node = node
    
    def __lt__(self, other):
        return self.node.val < other.node.val

class ListNode(object):
    def __init__(self, val, next = None):
        self.val = val
        self.next = next
    
    def __repr__(self) -> str:
        res = str(self.val)
        if self.next:
            res += str(self.next)
        return res
    
l1 = ListNode(1, ListNode(4, ListNode(5, None)))
l2 = ListNode(1, ListNode(3, ListNode(4, None)))
l3 = ListNode(2, ListNode(6, None))

lists = [l1, l2, l3]

solution = Solution()
print(solution.mergeKLists(lists))

        
