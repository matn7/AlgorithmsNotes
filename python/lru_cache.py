class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cache = {}
        self.capacity = capacity
        self.tail = Node(0, -1)
        self.head = Node(0, -2)
        self.tail.next = self.head
        self.head.prev = self.tail
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if not key in self.cache:
            return -1
    
        node = self.cache[key]
        # remove node
        self.removeNode(node)
        # add to front
        self.addNode(node)
        return node.value
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if key in self.cache:
            node = self.cache[key]
            self.removeNode(node)
        newNode = Node(value, key)
        self.addNode(newNode)
        self.cache[key] = newNode

        if len(self.cache) > self.capacity:
            tailNode = self.tail.next
            self.removeNode(tailNode)
            del self.cache[tailNode.key]

    def removeNode(self, node):
        prevNode = node.prev
        nextNode = node.next
        prevNode.next = nextNode
        nextNode.prev = prevNode

    def addNode(self, newNode):
        if self.tail.next == self.head:
            # list is empty
            self.tail.next = newNode
            self.head.prev = newNode
            newNode.next = self.head
            newNode.prev = self.tail
        else:
            prevNode = self.head.prev
            prevNode.next = newNode
            self.head.prev = newNode
            newNode.next = self.head
            newNode.prev = prevNode

class Node:
    def __init__(self, value, key, prev = None, next = None):
        self.value = value
        self.key = key
        self.prev = prev
        self.next = next


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