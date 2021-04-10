package list;

public class MyOwnList<T> {
	// private �������������ⲿ�ֻ࣬�������ڲ��ࣨҲ��������Ƕ�׵��࣬�����ⲿ��ֱ�ӱ���
	//��һ���ڲ���ʹ����private���κ�ֻ���ڸ�����ⲿ���ڲ�ʹ��
	class Node{
		//���� ������������  Java�еķ��ͣ�ֻ�ڱ���׶���Ч
		//����ֻ��**ֻ�ܴ����������ͣ�������ԭʼ����**��ԭʼ������byte/short/int/long �����ͣ�float.double �ַ���char �����ͣ�boolean
		//����������ԭʼ���͵�����������Ȼ���߱�����ջ�У���ԭʼ���ͱ������ʵ��ֵ�����������ͱ������һ��������ڴ��ַ��
		T data;
		Node next;
	}
	Node head;//ָ�����ĵ�һ��Node
	Node tail;
	//this.��������   ָ���Ƿ������еĳ�Ա�������������ֳ�Ա�����;ֲ��������������⣩
	//static����  static����Ҳ��Ϊ��̬���������ھ�̬�������������κζ���Ϳ���ֱ�ӷ���
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
	
	public boolean add(int index,T e) {//��index����Node��Ϊ�¼ӵ�
		if(index>this.size+1) {
			return false;
		}
		else if(index==1) {//��λ
			Node n=new Node();
			n.data=e;
			n.next=head;
			head=n;
			this.size++;
			return true;
		}
		else if(index==this.size+1) {//ĩλ
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

	public void addAll(MyOwnList<T> list) {//ֱ�ӽ�list����ԭ����ĺ���
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
		T []array=(T[])new Object[this.size];//��ò�Ҫ�÷��ʹ�������
		Node temp=this.head;
		for(int i=0;i<this.size;i++) {
			array[i]=head.data;
			temp=temp.next;
		}
		return array;
	}
}
