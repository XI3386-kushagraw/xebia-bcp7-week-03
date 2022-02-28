
public class LinkedlistReverse {

	private int value;
	private LinkedlistReverse next;
	
	
	//Getter method
	public int getValue() {
		return value;
	}
	public LinkedlistReverse getNext() {
		return next;
	}
	
	//Constructor
	public LinkedlistReverse(int value) {
		this.value=value;
	}
	
	//Setter Method
	public void setNext(LinkedlistReverse next) {
		this.next=next;
	}
	
	public LinkedlistReverse iReverse() {
		LinkedlistReverse curr,prev,next,head=null;
		
		prev=this;
		curr=prev.getNext();
		prev.setNext(null);
		while(curr != null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	
	// recursive reversal of linked list
	public LinkedlistReverse rReverse(LinkedlistReverse head) {
		
		LinkedlistReverse newHead=head.getNext();
		if(head==null || newHead==null) return head;
		head.setNext(null);
		LinkedlistReverse val=rReverse(newHead);
		newHead.setNext(head);
		return val;
	}

	
	
	
	// converts array to linked list - return head
	private static LinkedlistReverse convertArrayToLinkedList(Integer arrToList[]){
		
		int i=0;
		LinkedlistReverse head=new LinkedlistReverse(arrToList[0]), curr=null, next=null;
		curr=head;
		for(int x=1;x<(arrToList.length);x++) {
			Integer num=arrToList[x];
			next=new LinkedlistReverse(num);
			curr.setNext(next);
			curr=next;
		}
		curr.setNext(null);
		return head;
	}

	private void printContents() {
		
		LinkedlistReverse curr=this;
		while(curr != null) {
			System.out.print(" " + curr.getValue());
			curr=curr.getNext();
		}
		System.out.println(" ]");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Example 01:  74,37,11,45,61
		// Example 02:  45,38,12,62,42
		Integer arrToList[] = new Integer[] { 74,37,11,45,61 };
		
		// linked list as object - oop call
		LinkedlistReverse head=convertArrayToLinkedList(arrToList);
		System.out.println("==============================================================");
		System.out.print("Linked List Contents: [");
		head.printContents();
		head=head.iReverse();
		System.out.print("Linked List Contents: [Iterative Reversal]: [");
		head.printContents();
		head=head.rReverse(head);
		System.out.print("Linked List Contents: [Recursive Reversal]: [");
		head.printContents();
		System.out.println("==============================================================");

	}

}
