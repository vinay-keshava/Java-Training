import java.util.LinkedList;

public class DemoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			LinkedList<Integer> ll=new LinkedList<Integer>();
			ll.add(20);
			ll.add(100);
			ll.add(2000);
			printTheLinkedList(ll);
			LinkedList<Integer> tmp=new LinkedList<Integer>();
			tmp.add(2000);tmp.add(239);
			ll.addFirst(78);
			ll.addLast(8888);
			System.out.println("After addFirst and addLast");
			printTheLinkedList(ll);
			ll.remove();
			System.out.println("remove() removes the first element");
			printTheLinkedList(ll);
	

			ll.remove(0);
			System.out.println("remove(0) removes the first element");
			printTheLinkedList(ll);
			

			ll.remove(8888);
			System.out.println("remove() removes the first element");
			printTheLinkedList(ll);


			//Creating LinkedList of User defined type
			LinkedList<Book> bb=new LinkedList<Book>();
			Book b1=new Book(12,"Vinay","Anjaneulu","Sapna Publisher",89);
			Book b2=new Book(1,"Keshava","MAhesh","O'reilly Publishers",9);
			bb.add(b1);
			bb.add(b2);
			
			printTheLinkedListUser(bb);
			
			
	}

	
	
	public static void printTheLinkedList(LinkedList <Integer> ll){
		for(Integer i:ll){
				System.out.print(i+" ");
		System.out.println();
		}
	}
	public static void printTheLinkedListUser(LinkedList <Book> lb){
		for(Book i:lb){
				System.out.print(i+" ");
		System.out.println();
		}
	}
}


class Book{
	int id;
	String name,author,publisher;
		int quantity;
		Book(int i,String n,String a,String p,int q){
			this.id=i;
			this.name=n;
			this.author=a;
			this.publisher=p;
			this.quantity=q;
		}
}
