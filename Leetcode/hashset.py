class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.a=set([])


    def add(self, key: int) -> None:
        self.a = self.a | {key}


    def remove(self, key: int) -> None:
        self.a = self.a - {key}

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.a:
            return  True
        else:
            return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
