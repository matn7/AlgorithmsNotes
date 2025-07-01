class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if len(self.stack) == 0:
            self.stack.append((val, val))
        else:
            curMin = self.stack[-1][1]
            self.stack.append((val, min(val, curMin)))
        

    def pop(self):
        """
        :rtype: None
        """
        if len(self.stack) == 0:
            raise RuntimeError()
        self.stack.pop()


    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            raise RuntimeError()
        return self.stack[-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            raise RuntimeError()
        return self.stack[-1][1]
        