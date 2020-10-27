package tree;

public class BinarySearchTree extends BinaryTree {

	private Node getNode(Node node, int value) {
		if (value < node.value && node.hasLeft()) {
			return getNode(node.left, value);
		} else if (value > node.value && node.hasRight()) {
			return getNode(node.right, value);
		} else {
			return node;
		}
	}

	@Override
	public boolean add(int value) {
		if (isEmpty()) {
			root = new Node(value);
		} else {
			Node node = getNode(root, value);
			if (value < node.value) {
				node.left = new Node(value);
			} else if (value > node.value) {
				node.right = new Node(value);
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(int value) {
		Node node = getNode(root, value);
		return node == null ? false : node.value == value;
	}

	private boolean isComplete(Node node, int index, int size) {
		if (node == null) {
			return true;
		}
		if (index >= size) {
			return false;
		}
		int count = 2 * size + 1;
		return isComplete(node.left, count, size) && isComplete(node.right, count + 1, size);
	}

	@Override
	public boolean isComplete() {
		return isComplete(root, 0, size());
	}

}
