import random
class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value = []
        self.indexes = {}
        

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if not val in self.value:
            self.value.append(val)
            self.indexes[val] = len(self.value)-1
            return True
        return False
    '''
    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.value:
            self.value.remove(val)
            return True
        return False        
    '''
    def remove(self, val):
        if val not in self.indexes:
            return False
        
        index = self.indexes[val]
        last = self.value[-1]
        self.value[index] = last
        self.indexes[last] = index
        self.value.pop()
        self.indexes.pop(val, 0)
        return True
    def getRandom(self):
            """
            Get a random element from the set.
            :rtype: int
            """
            return random.choice(self.value)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()