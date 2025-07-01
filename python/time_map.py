class TimeMap(object):

    def __init__(self):
        self.times = {}        

    def set(self, key, value, timestamp):
        """
        :type key: str
        :type value: str
        :type timestamp: int
        :rtype: None
        """
        if key not in self.times:
            self.times[key] = []
        self.times[key].append([value, timestamp])
        

    def get(self, key, timestamp):
        """
        :type key: str
        :type timestamp: int
        :rtype: str
        """
        if key not in self.times:
            return ""
        pairs = self.times[key]
        l = 0
        r = len(pairs) - 1
        value = ""
        while l <= r:
            m = l + (r - l) // 2
            if pairs[m][1] == timestamp:
                return pairs[m][0]
            if pairs[m][1] < timestamp:
                value = pairs[m][0]
                l = m + 1
            else:
                r = m - 1
        return value
        