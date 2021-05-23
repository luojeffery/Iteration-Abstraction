class BinaryTree:
    def __init__(self, data=None):
        self.__data = data
        self.left = None
        self.right = None

    def add_leftchild(self, left):
        if left.data is None:
            self.left = left
        elif not issubclass(type(left.data), type(self.data)):
            raise TypeError("Type mismatch between " + type(self.data).__name__ + " and "
                            + type(left.data).__name__)
        self.left = left

    def add_rightchild(self, right):
        if right.data is None:
            self.right = right
        elif not issubclass(type(right.data), type(self.data)):
            raise TypeError("Type mismatch between " + type(self.data).__name__ + " and "
                            + type(right.data).__name__)
        self.right = right

    @property
    def data(self):
        return self.__data

    @data.setter
    def data(self, data):
        if data is None:
            self.__data = data
        elif not issubclass(type(data), type(self.__data)):
            raise TypeError("Type mismatch between " + type(self.__data).__name__ + " and "
                            + type(data).__name__)
        self.__data = data

    def __iter__(self):
        yield self.data
        if self.left is not None:
            for d in self.left.__iter__():
                yield d
        if self.right is not None:
            for d in self.right.__iter__():
                yield d
