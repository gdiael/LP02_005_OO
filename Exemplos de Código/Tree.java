package tree;

public interface Tree {

	public boolean add(int value);

	public boolean contains(int value);

	public int height();

	public int size();

	public boolean isFull();

	public boolean isComplete();

	public boolean isEmpty();

	public void inOrder(Visitor<Integer> visitor);

	public void preOrder(Visitor<Integer> visitor);

	public void posOrder(Visitor<Integer> visitor);

	public void itePreOrder(Visitor<Integer> visitor);

	public void levelOrder(Visitor<Integer> visitor);
}
