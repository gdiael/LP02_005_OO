package tree;

class PrintVisitor implements Visitor <Integer> {
	@Override
	public void visit(Integer element) {
		System.out.format(" " + element + " ");
	}
}

public class Main {	

	public static void main(String[] args) {
		Visitor<Integer> visitor = new PrintVisitor();

		Tree tree = new BinaryTree();
		tree.add(5);
		tree.add(1);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		
		System.out.print("Complete Tree:");
		tree.preOrder(visitor);
		System.out.println();

		tree = new BinarySearchTree();
		tree.add(5);
		tree.add(1);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		
		System.out.print("Search Tree:");
		tree.preOrder(visitor);
		System.out.println();
		
		BinarySearchTreeWithRemove delTree = new BinarySearchTreeWithRemove();
		delTree.add(5);
		delTree.add(1);
		delTree.add(7);
		delTree.add(6);
		delTree.add(8);
		delTree.add(9);
		delTree.remove(5);
		
		System.out.print("Removed Tree:");
		delTree.preOrder(visitor);
		System.out.println();
	}
}
