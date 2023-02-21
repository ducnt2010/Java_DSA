package Day9;

public class MainTest {
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        printLisst(n0); //

        // how to find the element with index=4 -> expect => n4 (val=4)

//        System.out.println(elementAt(n0, 3));

//        Node newHead = insertAtHead(n0, 1000);
        printList(deleteAt(n0, 0));
    }

    private static void insert(Node head, int index, int valOfNewNode) {
        // find the previous node of indexNode
        // link the previous node to newNode
        // link newNode to nextNode of previous node
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                Node newNode = new Node(valOfNewNode);
                newNode.next = current.next;
                current.next = newNode;
                break;
//                Node nextBackup = current.next; // save next Node
//                current.next = newNode; // break connection between previous and next
//                newNode.next = nextBackup;
            }
            count++;
            current = current.next;
        }
    }

    private static Node deleteAt(Node head, int index) {
        if (index == 0) {
            head = head.next;
            return head;
        }
        // find element at index-1
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                // link previous element to next of index element
                current.next = current.next.next;
                break;
            }
            count++;
            current = current.next;
        }
        return head;
    }


    private static Node insertAtHead(Node head, int val) {
        // create new node
        Node newNode = new Node(val);
        // link newNode to head
        newNode.next = head;
        // assign head to new node
        return newNode; // new head
    }

    private static Node insertAtTail(Node head, int val) {
        // check case list is empty
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        // similar insert at middle
        // find the last element (node.next==null)
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        // link last element to newNode
        current.next = newNode;
        return head;
    }

    private static int elementAt(Node head, int index) {
        Node current = head; // n0
        int count = 0;
        while (current != null /*&& count < index*/) {
            if (count == index) {
                return current.val;
            }
            current = current.next;
            count++;
        }
        return -1; // coi -1 la truong hop ko hop le
    }

    private static void printList(Node head) {
        Node current = head; // current point to the head of List
        while (current != null) {
            // process current node
            System.out.print(current.val + "->");
            ///////////////// process current note complete

            // move to next node
            current = current.next;
        }
    }

    static class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
;