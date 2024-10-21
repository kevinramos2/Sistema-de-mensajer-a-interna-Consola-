package ListaDoble;




public class DoubleNode {
	//Atributos
	private Object data;
	private DoubleNode next;
	private DoubleNode prev;
	
	//Constructor vacío
	public DoubleNode() {
		data = null;
		next = null;
		prev = null;
	}
	
	//Constructor con argumentos
	public DoubleNode(Object d) {
		data = d;
		prev = null;
		next = null;	
	}

  //sets y gets
	public void setData(Object d) {
		this.data = d;
	}
	
	public void setNext(DoubleNode n) {
		this.next = n;
	}
	
	public void setPrev(DoubleNode p) {
		this.prev = p;
	}
	
	public Object getData() {
		return data;
	}
	
	public DoubleNode getNext() {
		return next;
	}
	
	public DoubleNode getPrev() {
		return prev;
	}
	
}
