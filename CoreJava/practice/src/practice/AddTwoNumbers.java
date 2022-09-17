package practice;

public class AddTwoNumbers {
	int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode(sum(l1.val, l2.val));
        ListNode current = result;
        while(l1.next!=null || l2.next != null){
            if(l2.next==null){
                l1 = l1.next;
                ListNode node = new ListNode(sum(l1.val,0));
                current.next = node;
                current = node;
            }else if(l1.next==null){
                l2 = l2.next;
                ListNode node = new ListNode(sum(l2.val,0));
                current.next = node;
                current = node;
            }else{
                l1 = l1.next;
                l2 = l2.next;
                ListNode node = new ListNode(sum(l1.val, l2.val));
                current.next = node;
                current = current.next;
                
            }
        }
        if(l1.next==null && l2.next==null){
            if(carry!=0){
                ListNode node = new ListNode(carry);
                current.next = node;
            }
        }
        return result;
        
    }
    
    public int sum(int a, int b){
        int sum = a + b + carry;
        if(sum>9){
            this.carry = 1;
            sum = sum-10;
        }else{
            carry = 0;
        }
        return sum;
    }
    
    public static void main(String[] args) {
		ListNode l2 = new ListNode(9, new ListNode(9));
		ListNode l1 = new ListNode(9);
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode node = add.addTwoNumbers(l1, l2);
		System.out.print(node.val);
		while(node.next!=null) {
			ListNode current = node.next;
			System.out.print(node.next.val);
			node = current;
		}
	}
}
