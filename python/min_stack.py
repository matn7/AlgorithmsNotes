class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if len(self.minStack) != 0:
            currMin = self.minStack[-1]
            if val < currMin:
                self.minStack.append(val)
            else:
                self.minStack.append(currMin)
        else:
            self.minStack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        if len(self.stack) == 0:
            raise RuntimeError('Stack is empty')
        self.stack.pop()
        self.minStack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            raise RuntimeError('Stack is empty')
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.minStack) == 0:
            raise RuntimeError('Min Stack is empty')
        return self.minStack[-1]


solution = MinStack()
solution.push(-2)
solution.push(0)
solution.push(-3)
print(solution.getMin())
solution.pop()
print(solution.top())
print(solution.getMin())