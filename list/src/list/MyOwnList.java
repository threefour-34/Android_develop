package list;

//˫������

public class MyOwnList<T> {
	// private �������������ⲿ�ֻ࣬�������ڲ��ࣨҲ��������Ƕ�׵��࣬�����ⲿ��ֱ�ӱ���
	//��һ���ڲ���ʹ����private���κ�ֻ���ڸ�����ⲿ���ڲ�ʹ��
	class Node{
		//���� ������������  Java�еķ��ͣ�ֻ�ڱ���׶���Ч
		//����ֻ��**ֻ�ܴ����������ͣ�������ԭʼ����**��ԭʼ������byte/short/int/long �����ͣ�float.double �ַ���char �����ͣ�boolean
		//����������ԭʼ���͵�����������Ȼ���߱�����ջ�У���ԭʼ���ͱ������ʵ��ֵ�����������ͱ������һ��������ڴ��ַ��
		T data;
		Node next;
		Node last;
	}
	Node head;//ָ�����ĵ�һ��Node
	Node tail;
	//this.��������   ָ���Ƿ������еĳ�Ա�������������ֳ�Ա�����;ֲ��������������⣩
	//static����  static����Ҳ��Ϊ��̬���������ھ�̬�������������κζ���Ϳ���ֱ�ӷ���
	int size;
	
	
	public boolean isEmpty() {
		if(size == 0) {
			return false;
		}
		return true;
	}
	public void add(T e) {
		Node n=new Node();
		n.data=e;
		if(this.size==0) {
			head=n;
			tail=n;
			n.next=null;
			n.last=null;
			this.size++;
		}
		else {
			tail.next=n;
			n.last=tail;
			n.next=null;
			this.size++;
			tail=n;
		}	
	}
	
	public boolean add_at(int index,T e) {//��index����Node��Ϊ�¼ӵ�
		if(index>this.size+1||index<1) {
			return false;
		}
		else if(index==1) {//��λ
			Node n=new Node();
			n.data=e;
			n.next=head;
			head.last=n;
			n.last=null;
			head=n;
			this.size++;
			return true;
		}
		else if(index==this.size+1) {//ĩλ
			Node n=new Node();
			n.data=e;
			n.next=null;
			n.last=tail;
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
			n.last=temp;
			n.next.last=n;
			this.size++;
			return true;
		}
	}

	public void addAll(MyOwnList<T> list) {//ֱ�ӽ�list����ԭ����ĺ���
		this.tail.next=list.head;
		list.head.last=this.tail;
		this.tail=list.tail;
		this.size+=list.size;
	}

	public boolean remove(int index) {
		if(index>this.size||index<1) {
			return false;
		}
		else if(index==1) {
			this.head=this.head.next;
			this.head.last=null;
			this.size--;
			return true;
		}
		else{
			Node temp=this.head;
			for(int i=0;i<index-2;i++) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
			temp.next.last=temp;
			if(index==this.size) {
				tail=temp;
			}
			this.size--;
			return true;
		}
	}
	public T get(int index) {
		if(index>this.size||index<1) {
			return null;
		}
		else if(index==this.size) {
			return this.tail.data;
		}
		else if(index==1) {
			return this.head.data;
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
	
	/*
	 * public int find(T t) { Node temp=this.head; for(int i=0;i<this.size;i++) {
	 * if(t.equals(temp.data)) { return i+1; } temp=temp.next; } return -1; }
	 */
	
	
	
	
	//����ʵ��toArray
	public T[] toArray() {
		if(this.size==0) {
			return null;
		}
		T []array=(T[])new Object[this.size];//��ò�Ҫ�÷��ʹ�������
		Node temp=this.head;
		for(int i=0;i<this.size;i++) {
			array[i]=head.data;
			temp=temp.next;
		}
		return array;
	}
}
