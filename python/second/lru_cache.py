class LRUCache(object):
    
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.head = Node(0,0)
        self.tail = Node(0,0)
        self.head.prev = self.tail
        self.tail.next = self.head
        self.cache = {}
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.removeNode(node)
        self.addFront(node)

        return node.val
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        node = Node(key, value)
        if key in self.cache:
            nodeToReplace = self.cache[key]
            self.removeNode(nodeToReplace)
            del self.cache[key]
        self.addFront(node)
        self.cache[key] = node
        if len(self.cache) > self.capacity:
            nodeToRemove = self.tail.next
            self.removeNode(nodeToRemove)
            del self.cache[nodeToRemove.key]

    def addFront(self, node):
        if self.isEmpty():
            self.tail.next = node
            self.head.prev = node
            node.next = self.head
            node.prev = self.tail
        else:
            prev = self.head.prev
            prev.next = node
            self.head.prev = node
            node.next = self.head
            node.prev = prev


    def removeNode(self, node):
        if self.isEmpty():
            return
        
        next = node.next
        prev = node.prev

        prev.next = next
        next.prev = prev


    def isEmpty(self):
        return self.tail.next == self.head and self.head.prev == self.tail
        
class Node(object):
    def __init__(self, key, val, next = None, prev = None):
        self.key = key
        self.val = val


solution = LRUCache(2)

solution.put(1, 1)
solution.put(2, 2)
print(solution.get(1))

solution.put(3, 3)
print(solution.get(2))

solution.put(4, 4)
print(solution.get(1))
print(solution.get(3))
print(solution.get(4))

