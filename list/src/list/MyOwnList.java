package list;

public class MyOwnList<T> {
	// private 不能用来修饰外部类，只能修饰内部类（也就是类中嵌套的类，修饰外部类直接报错）
	//当一个内部类使用了private修饰后，只能在该类的外部类内部使用
	class Node{
		//泛型 即参数化类型  Java中的泛型，只在编译阶段有效
		//泛型只能**只能代表引用类型，不能是原始类型**，原始类型有byte/short/int/long 浮点型：float.double 字符型char 布尔型：boolean
		//引用类型与原始类型的区别在于虽然二者保存在栈中，但原始类型保存的是实际值，而引用类型保存的是一个对象的内存地址。
		T data;
		Node next;
	}
	Node head;//指向插入的第一个Node
	Node tail;
	//this.属性名称   指的是访问类中的成员变量，用来区分成员变量和局部变量（重名问题）
	//static修饰  static方法也成为静态方法，由于静态方法不依赖于任何对象就可以直接访问
	int size;
	public void add(T e) {
		Node n=new Node();
		n.data=e;
		if(this.size==0) {
			head=n;
			tail=n;
			n.next=null;
			this.size++;
		}
		else {
			tail.next=n;
			this.size++;
			tail=n;
		}	
	}
	
	public boolean add(int index,T e) {//第index处的Node改为新加的
		if(index>this.size+1) {
			return false;
		}
		else if(index==1) {//首位
			Node n=new Node();
			n.data=e;
			n.next=head;
			head=n;
			this.size++;
			return true;
		}
		else if(index==this.size+1) {//末位
			Node n=new Node();
			n.data=e;
			n.next=null;
			tail.next=n;
			tail=n;
			this.size++;
			return true;
		}
		else {
			Node temp=this.head;
			for(int i=0;i<index-2;i++) {
				temp=temp.next;
			}
			Node n=new Node();
			n.data=e;
			n.next=temp.next;
			temp.next=n;
			this.size++;
			return true;
		}
	}

	public void addAll(MyOwnList<T> list) {//直接将list接在原链表的后面
		this.tail.next=list.head;
		this.tail=list.tail;
		this.size+=list.size;
	}

	public boolean remove(int index) {
		if(index>this.size) {
			return false;
		}
		else if(index==1) {
			this.head=this.head.next;
			this.size--;
			return true;
		}
		else{
			Node temp=this.head;
			for(int i=0;i<index-2;i++) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
			if(index==this.size) {
				tail=temp;
			}
			this.size--;
			return true;
		}
	}
	public T get(int index) {
		if(index>this.size) {
			return null;
		}
		else if(index==this.size) {
			return this.tail.data;
		}
		else {
			Node temp=this.head;
			for(int i=0;i<index-1;i++) {
				temp=temp.next;
			}
			return temp.data;
		}
	}
	public int size() {
		return this.size;
	}
	public T[] toArray() {
		if(this.size==0) {
			return null;
		}
		T []array=(T[])new Object[this.size];//最好不要用泛型创建数组
		Node temp=this.head;
		for(int i=0;i<this.size;i++) {
			array[i]=head.data;
			temp=temp.next;
		}
		return array;
	}
}
