package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree implements Tree {

	protected Node root;

	@Override
	public boolean add(int value) {
		if (isEmpty()) {
			root = new Node(value);
		} else {
			Deque<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node node = queue.removeFirst();
				if (value == node.value) {
					return false;
				}
				if (node.hasLeft()) {
					queue.addLast(node.left);
				} else {
					node.left = new Node(value);
					return true;
				}
				if (node.hasRight()) {
					queue.addLast(node.right);
				} else {
					node.right = new Node(value);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean contains(int value) {
		if (!isEmpty()) {
			Deque<Node> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node node = queue.removeFirst();
				if (value == node.value) {
					return true;
				}
				if (node.hasLeft()) {
					queue.addLast(node.left);
				}
				if (node.hasRight()) {
					queue.addLast(node.right);
				}
			}
		}
		return false;
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	@Override
	public int height() {
		return height(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.left) + size(node.right);
		}
	}

	@Override
	public int size() {
		return size(root);
	}

	@Override
	public boolean isFull() {
		return size() == Math.pow(2, height()) - 1;
	}

	@Override
	public boolean isComplete() {
		return true;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	private void inOrder(Node node, Visitor<Integer> visitor) {
		if (node != null) {
			inOrder(node.left, visitor);
			visitor.visit(node.value);
			inOrder(node.right, visitor);
		}
	}

	@Override
	public void inOrder(Visitor<Integer> visitor) {
		inOrder(root, visitor);
	}

	private void preOrder(Node node, Visitor<Integer> visitor) {
		if (node != null) {
			System.out.print("(");
			visitor.visit(node.value);
			preOrder(node.left, visitor);
			preOrder(node.right, visitor);
			System.out.print(")");
		}
	}

	@Override
	public void preOrder(Visitor<Integer> visitor) {
		preOrder(root, visitor);
	}

	private void posOrder(Node node, Visitor<Integer> visitor) {
		if (node != null) {
			posOrder(node.left, visitor);
			posOrder(node.right, visitor);
			visitor.visit(node.value);
		}
	}

	@Override
	public void posOrder(Visitor<Integer> visitor) {
		posOrder(root, visitor);
	}

	@Override
	public void itePreOrder(Visitor<Integer> visitor) {
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.addLast(root);
		while (!stack.isEmpty()) {
			Node current = stack.removeLast();
			visitor.visit(current.value);
			if (current.hasRight()) {
				stack.add(current.right);
			}
			if (current.hasLeft()) {
				stack.add(current.left);
			}
		}
	}

	@Override
	public void levelOrder(Visitor<Integer> visitor) {
		Deque<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			visitor.visit(node.value);
			if (node.hasLeft()) {
				queue.addLast(node.left);
			}
			if (node.hasRight()) {
				queue.addLast(node.right);
			}
		}
	}
}
