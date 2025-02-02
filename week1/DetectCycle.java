package techm;

class Node{
	int num;
	Node next;
	Node(int num){
		this.num=num;
	}
	
	
}
public class DetectCycle {
	
	public static boolean hasCycle(Node head){
		Node tortoise=head;
		Node hare=head;
		while(hare!=null || tortoise!=null) {
			tortoise=tortoise.next;
			hare=hare.next.next;
			if(tortoise==hare) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/* Just Create a cycled or not cycled LinkedList to check
		 * The method hasCycle(Node head) will say it
		 */
		

	}

}
