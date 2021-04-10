package list;


import java.util.Scanner;

class t{
	int number;
}


public class test {
	public static void main(String[] args) {
		MyOwnList<t> list=new MyOwnList<t>();
		t test1=new t();
		test1.number=8;
		list.add(test1);
		
		t test2=new t();
		test2.number=200;
		list.add(test2);
		
		
		t test3=new t();
		test3.number=588;
		list.add(test3);
		
		t test4=new t();
		test4.number=12345;
		list.add(test4);
		
		//list.remove(1);	
		
		
		
		System.out.println("the length of list is "+list.size);
		
		int number;
		Scanner input =new Scanner(System.in);
		System.out.print("输入要读取的元素序号：");
		number=input.nextInt();
		
		t test=new t();
		test=list.get(number);
		if(test==null) {
			System.out.println("false,exceed size");
		}
		else{
			System.out.println("the "+number+"th number "+"in list is "+test.number);
		}
		
		
		
		System.out.println();
		
		MyOwnList<t> list2=new MyOwnList<t>();	
		t test5=new t();
		test5.number=99;
		list2.add(test5);
		t test6=new t();
		test6.number=1001;
		list2.add(test6);
		
		System.out.println("test addAll");
		System.out.println("the previous length of list2 is "+list2.size);
		
		list2.addAll(list);//将list连接到list2后面
		
		System.out.println("the length of list2 is "+list2.size);
		
		
		
		System.out.print("输入要读取的元素序号：");
		number=input.nextInt();
		t test_=new t();
		test_=list2.get(number);
		if(test_==null) {
			System.out.println("false,exceed size");
		}
		else{
			System.out.println("the "+number+"th number "+"in list2 is "+test_.number);
		}
		
		System.out.println();
		
		/*
		 * Object []tes=new t[list2.size]; tes=list2.toArray(); t []tes1=(t[])tes;
		 * 
		 * System.out.println("test toArray"); for(int i=0;i<list2.size;i++) {
		 * System.out.println("the number of tes["+i+"] is"+tes1[i].number); }
		 */
		
		
		/*System.out.println("输入要查找的数据：");
		number=input.nextInt();
		t test__=new t();
		test__.number=number;
		int find_or_not=list2.find(test__);
		if(find_or_not==-1) {
			System.out.println("在list2中没有找到该数据");
		}
		else {
			System.out.println("在list2中找到了该数据，为第"+find_or_not+"个");
		}*/
		
	}
}
