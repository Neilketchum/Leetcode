package Samsara;

public class OddEvenList {
    private static void printList(NodeList head) {
        NodeList current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static NodeList compute(NodeList head) {
        if (head == null || head.next == null) {
            return head;
        }

        NodeList odd = head;
        NodeList even = head.next;
        NodeList evenHead = even; // Store the head of even list to attach later

        while (even != null && even.next != null) {
            odd.next = even.next; // Point odd to the next odd node
            odd = odd.next; // Move odd pointer forward
            even.next = odd.next; // Point even to the next even node
            even = even.next; // Move even pointer forward
        }

        // Connect the last odd node to the head of the even list
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        NodeList head = new NodeList(1);
        head.next = new NodeList(2);
        head.next.next = new NodeList(3);
        head.next.next.next = new NodeList(4);
        head.next.next.next.next = new NodeList(5);
        head.next.next.next.next.next = new NodeList(6);
        head.next.next.next.next.next.next = new NodeList(7);
        System.out.print("Original list: ");
        printList(head);
        NodeList modifiedHead = compute(head);
        System.out.print("Modified list: ");
        printList(modifiedHead);
    }
}
