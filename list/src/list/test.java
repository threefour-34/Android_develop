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
		test2.number=2;
		list.add(test2);
		
		
		t test3=new t();
		test3.number=5;
		list.add(test3);
		
		t test4=new t();
		test4.number=6;
		list.add(test4);
		
		
		System.out.println("the length of list is "+list.size);
		
		int number;
		Scanner input =new Scanner(System.in);
		System.out.print("输入要读取的元素序号：");
		number=input.nextInt();
		
		
		//list.remove(1);	
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
		
		
		
		list2.addAll(list);
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
		
		
	}
}
