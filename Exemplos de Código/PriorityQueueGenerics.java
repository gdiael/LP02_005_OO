
import java.util.ArrayList;
import java.util.Comparator;

class ElementWithPriority {
	public int priority;
}

public class PriorityQueueGenerics <E> {
	
	public static void main(String[] args) {
		PriorityQueueGenerics <Integer> p = new PriorityQueueGenerics<>((x,y)->x.compareTo(y));
		p.add(10);
		p.add(30);
		p.add(20);
		p.add(15);
		p.remove();
		p.add(40);
		System.out.println(p); //Todo print
		System.out.println(p.get()); //Todo print
	}

	
	protected ArrayList <E> list;
	protected Comparator <E> comparator;
	
	public PriorityQueueGenerics(Comparator <E> comparator){
		list = new ArrayList<>();
		this.comparator = comparator;
	}
	
	// adicionar um elemento na lista onde sua prioridade é o seu valor
	public boolean add(E value){
		return list.add(value);
	}
	
	private int indexOfMax(){
		int index = -1;
		for(int i=0;i<list.size();i++){
			if(index == -1 || comparator.compare(list.get(i), list.get(index)) > 0){
				index = i;
			}
		}
		return index;
	}
	
	// remove o elemento de maior prioridade e o retorna
	public E remove(){
		if(list.isEmpty()){
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = indexOfMax();
		return list.remove(index);
	}
	
	// retorna o elemento de maior prioridade sem remover
	public E get(){
		if(list.isEmpty()){
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = indexOfMax();
		return list.get(index);
	}
	
	// modifica a prioridade de um elemento
	public void update(E current, E newElement){
		if(list.isEmpty()){
			throw new IndexOutOfBoundsException("The list is empty.");
		}
		int index = -1;
		for(int i=0;i<list.size();i++){
			if(comparator.compare(list.get(i), current) == 0){
				index = i;
				break;
			}
		}
		if(index != -1){
			list.set(index, newElement);
		} else {
			throw new IndexOutOfBoundsException("The element (" + current + ") does not exist.");
		}
	}
	
	public String toString() {
		return list.toString();
	}
}
