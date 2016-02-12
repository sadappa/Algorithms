package Solutions;


public class AddTwoList {
	public static ListNode addTwoLists(ListNode A, ListNode B) {
		
		ListNode dummy = new ListNode(0, null);
		int carry = 0;
		int sum = 0;
		
		ListNode result = dummy;
		while(A != null || B!= null) {
			sum = carry;
			if (A != null) {
				sum += A.value;
				A= A.next;
			}
			if (B != null) {
				sum += B.value;
				B= B.next;
			}
			
			carry = sum/10;
			sum = sum % 10;
			result.next = new ListNode(sum, null);
			result = result.next;
		}
		
		if (carry == 1) {
			result.next = new ListNode(carry, null);
		}
		return dummy.next;		
	}
}
