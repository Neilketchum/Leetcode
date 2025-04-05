public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode traversalNode = new ListNode(0);

        ListNode head =traversalNode;
        while(list1 !=null && list2 !=null){
            if(list1.val >= list2.val){
                traversalNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                traversalNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
        }
        while(list1 !=null){
           traversalNode.next = new ListNode(list1.val);
           traversalNode = traversalNode.next;
           list1 = list1.next ;
        }
        while(list2 !=null){
            traversalNode.next = new ListNode(list2.val);
            traversalNode = traversalNode.next;
            list2 = list2.next ;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        mergeTwoLists(l1,l2);
    }
}
