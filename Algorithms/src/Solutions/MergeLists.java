package Solutions;

public class MergeLists {

	public static ListNode mergeLists(ListNode a, ListNode b) {
		
		ListNode dummy = new ListNode(0, null);
		ListNode result = dummy;
		while(a != null && b != null) {
			if(a.value <= b.value) {
				result.next = a;
				a = a.next;
			} else {
				result.next = b;
				b = b.next;
			}
			result = result.next;
		}
		
		if (a != null)
			result.next = a;
		else if (b != null)
			result.next = b;
		return dummy.next;
	}
}
