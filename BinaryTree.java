import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree<T> implements Iterable<T>{
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() {}

    public BinaryTree(T t) {
        data = t;
    }

    public void addLeftChild(BinaryTree<T> left) {
        this.left = left;
    }

    public void addRightChild(BinaryTree<T> right) {
        this.right = right;
    }

    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator<>(this);
    }

    private class BinaryTreeIterator<T> implements Iterator<T> {
        private Queue<BinaryTree<T>> queue = new LinkedList<>();

        BinaryTreeIterator(BinaryTree<T> tree) {
            if (tree.data != null)
                queue.add(tree);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            BinaryTree<T> tree = queue.remove();
            if (tree.left != null)
                queue.add(tree.left);
            if (tree.right != null)
                queue.add(tree.right);
            return tree.data;
        }
    }
}