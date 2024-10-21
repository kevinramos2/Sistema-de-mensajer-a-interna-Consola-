package ListaDoble;

import Pack.Usuario;

public class DoubleList {
	//Atributos
	private DoubleNode head;
	private DoubleNode tail;
	private int size;
	
	//Constructor vacío
	public DoubleList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	//Métodos
	
	//retorna el tamaño de la lista
	public int size() {
		return size;
	}
	
	//Verificamos si la lista está o no vacía
	public boolean isEmpty() {
		if (size ==0) {
			return true;
		}else {
			return false;
		}
	}
	
	//retorna la primera posicion de la lista
	public DoubleNode first() {
		return head;
	}
	
	//retorna la última posición de la lista
	public DoubleNode last() {
		return tail;
	}
	
	//Añadimos un nuevo elemento en la primera posición
	public void addFirst(Object e) {
		DoubleNode n = new DoubleNode(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}else {
			n.setNext(head);
			head.setPrev(n);
			head = n;
		}
		size ++;
	}
	
	//Añadimos un nuevo elemento en la última posición 
	public void addLast(Object e) {
		DoubleNode n = new DoubleNode(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
		}
		size ++;
	}
	
	//Eliminamos el primer elemento de la lista
	public Usuario removeFirst(Object object) {
		if (isEmpty()) {
			return null;
		}else {
			DoubleNode temp = head;
			head = temp.getNext();
			temp.setNext(null);
			head.setPrev(null);
			size --;
			return (Usuario) temp.getData();
		}
	}
	
	//Eliminamos la última posición de la lista
	public Usuario removeLast(Object object) {
		if (isEmpty()) {
			return null;
		}else {
			DoubleNode temp = tail;
			tail = temp.getPrev();
			temp.setPrev(null);
			tail.setNext(null);
			size --;
			return (Usuario) temp.getData();		}
	}
	
	//Eliminar algún elemento
	public Usuario remove(DoubleNode n) {
		if (n == null) {
			return null;
		}
		if (n == head) {
			return removeFirst(n.getData());
		}else if (n == tail) {
			return removeLast(n.getData());
		}else {
			Usuario e = (Usuario) n.getData();
			DoubleNode p = n.getPrev();
			DoubleNode nx = n.getNext();
			p.setNext(nx);
			nx.setPrev(p);
			n.setNext(null);
			n.setPrev(null);
			size --;
			return e;
		}
	}
	
	//Añadir antes de un elemento
	public void addBefore(DoubleNode n, Usuario e) {
		if (n == head) {
			addFirst(e);
		}else {
			DoubleNode m = new DoubleNode(e);
			DoubleNode p = n.getPrev();
			p.setNext(m);
			m.setPrev(p);
			m.setNext(n);
			n.setPrev(m);
			size ++;
		}
	}
	
	//Añadir después de un elemento
	public void addAfter(DoubleNode n, Usuario e) {
		if (n == tail) {
			addLast(e);
		}else {
			DoubleNode m = new DoubleNode(e);
			DoubleNode nx = n.getNext();
			
				n.setNext(m);
				m.setPrev(n);
				m.setNext(nx);
				nx.setPrev(m);
				size ++;
			
		}
	}
	public static void imprimirDatos(DoubleList lista) {
		DoubleNode temp = lista.head;
		while (temp != null) {
				System.out.println(((Usuario) temp.getData()).toString3());
				temp = temp.getNext();
			}	
	}






}
