public class _PriorityQueue {

	public static void main(String[] args) {
		_PriorityQueue p = new _PriorityQueue();
		p.add(10);
		p.add(30);
		p.add(20);
		p.add(15);
		p.remove();
		p.add(40);
		System.out.println(p); //Todo print
		System.out.println(p.get()); //Todo print
	}

	protected int[] elements;
	protected int size;
	protected int capacity;

	public _PriorityQueue(int capacity) {
		size = 0;
		this.capacity = capacity;
		elements = new int[capacity];
	}

	public _PriorityQueue() {
		this(100);
	}

	// adicionar um elemento na lista onde sua prioridade eh o seu valor
	public boolean add(int value) {
		if (size < capacity) {
			elements[size] = value;
			size += 1;
			return true;
		}
		return false;
	}

	private int indexOfMax() {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (index == -1 || elements[i] > elements[index]) {
				index = i;
			}
		}
		return index;
	}

	// remove o elemento de maior prioridade e o retorna
	public int remove() {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = indexOfMax();
		int element = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size -= 1;
		return element;
	}

	// retorna o elemento de maior prioridade sem remover
	public int get() {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = indexOfMax();
		return elements[index];
	}

	// modifica a prioridade de um elemento
	public void update(int value, int newValue) {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i] == value) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			elements[index] = newValue;
		} else {
			throw new IndexOutOfBoundsException("The element (" + value + ") does not exist.");
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < size; i++) {
			str.append(elements[i]);
			str.append(" ");
		}
		return str.toString();
	}
}
