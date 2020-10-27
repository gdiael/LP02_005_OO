package tree;

public class NodeWithParent extends Node {

	protected NodeWithParent parent;

	public NodeWithParent(NodeWithParent parent, int value) {
		super(value);
		this.parent = parent;
	}

	public boolean hasParent() {
		return parent != null;
	}
}
