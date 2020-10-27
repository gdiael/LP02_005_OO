package tree;

public class BinarySearchTreeWithRemove extends BinarySearchTree {

	private Node getNode(Node node, int value) {
		if (value < node.value && node.hasLeft()) {
			return getNode(node.left, value);
		} else if (value > node.value && node.hasRight()) {
			return getNode(node.right, value);
		} else {
			return node;
		}
	}
	
	public boolean add(int value) {
		if (isEmpty()) {
			root = new NodeWithParent(null, value);
		} else {
			NodeWithParent node = (NodeWithParent) getNode(root, value);
			if (value < node.value) {
				node.left = new NodeWithParent(node, value);
			} else if (value > node.value) {
				node.right = new NodeWithParent(node, value);
			} else {
				return false;
			}
		}
		return true;
	}

	private void replace(NodeWithParent old, NodeWithParent newNode) {
		if (!old.hasParent()) {
			root = newNode;
		} else if (old.parent.left == old) {
			old.parent.left = newNode;
		} else {
			old.parent.right = newNode;
		}
		if (newNode != null) {
			newNode.parent = old.parent;
		}
	}

	private NodeWithParent minimumNode(NodeWithParent node) {
		if (!node.hasLeft()) {
			return node;
		} else {
			return minimumNode((NodeWithParent) node.left);
		}
	}

	public boolean remove(int value) {
		if (isEmpty()) {
			return false;
		}
		NodeWithParent node = (NodeWithParent) getNode(root, value);
		if (node.value != value) {
			return false;
		}
		if (!node.hasLeft()) {
			replace(node, (NodeWithParent) node.right);
		} else if (!node.hasRight()) {
			replace(node, (NodeWithParent) node.left);
		} else {
			NodeWithParent minimum = minimumNode((NodeWithParent) node.right);
			if (minimum.parent != node) {
				replace(minimum, (NodeWithParent) minimum.right);
				minimum.right = node.right;
				minimum.right.parent = minimum;
			}
			replace(node, minimum);
			minimum.left = node.left;
			minimum.left.parent = minimum;
		}
		return true;
	}
}
