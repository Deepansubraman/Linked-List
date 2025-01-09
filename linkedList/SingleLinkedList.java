import java.util.Scanner;

public class SingleLinkedList {
    public static void main(String[] args) {
        // Node head=new Node(15);
        // head.next=new Node(20);
        // head.next.next=new Node(30);
        // head.next.next.next=new Node(40);
        // Scanner sc=new Scanner(System.in);
        Node head = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of elements: ");
        int n0 = sc.nextInt();
        for(int i=0;i<n0;i++)
        {
            System.out.print("Enter the Element to Add: ");
           // head=InsertatBegin(head,sc.nextInt());
           head = insertAtEnd(head,sc.nextInt());
        }

        printSll(head);
        System.out.print("Enter the number of elements to insert first: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the element : ");
            int val = sc.nextInt();
            head =  insertAtBeginning(head, val);
            System.out.println();
        }
        printSll(head);


        System.out.print("Enter the number of elements to insert last: ");
        int n1 = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the element : ");
            int val1 = sc.nextInt();
            head =  insertAtEnd(head, val1);
            System.out.println();
        }
        printSll(head);


        System.out.println("Insert at middle: ");
        System.out.println("enter the element: ");
        int ele=sc.nextInt();
        System.out.println("enter the place to insert: ");
        int place=sc.nextInt();
        insertAtMiddle(head, ele, place);
        printSll(head);


        System.out.print("Enter the number of elements to delete at first: ");
        int n2 = sc.nextInt();
        for(int i=0;i<n2;i++)
        {
            head =  deleteAtBeginning(head);
            System.out.println();
        }
        printSll(head);


        System.out.print("Enter the number of elements to delete at end: ");
        int n3 = sc.nextInt();
        for(int i=0;i<n2;i++)
        {
            head =  deleteAtEnd(head);
            System.out.println();
        }
        printSll(head);


        System.out.print("Enter the number of elements to delete at middle: ");
        int n4 = sc.nextInt();
        for(int i=0;i<n2;i++)
        {
            int n5=sc.nextInt();
            head =  deleteAtMiddle(head,n4);
            System.out.println();
        }
        printSll(head);


        System.out.println("Enter the element to Search: ");
        int n5=sc.nextInt();
        searchingElement(head, n5);
        System.out.println("after reverse: ");
        head=reverse(head);
        printSll(head);
    }








    
    public static void printSll(Node headNode)
    {
        if(headNode==null)
        {
            System.out.println("NULL");
        }
        Node temp= headNode;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node reverse(Node headNode)
    {
        Node next=null;
        Node current=headNode;
        Node prev=null;
        while (current != null) {
            next = current.next;    
            current.next = prev;    
            prev = current;         
            current = next;
        }
        headNode=prev;
        return headNode;
    }
    
    public static Node insertAtBeginning(Node headNode,int x)
    {
        Node c=new Node(x);
        c.next=headNode;
        headNode=c;
        return headNode;
    }
    public static Node insertAtEnd(Node headNode,int y)
    {
        if (headNode == null) {
            return new Node(y);
        }
        Node temp1=headNode;
        while(temp1.next!=null)
        {
            temp1=temp1.next;
        }
        Node t=new Node(y);
        temp1.next=t;
        return headNode;
    }
    public static Node insertAtMiddle(Node headNode,int y,int place)
    {
        Node temp = headNode;
        int count = 0;
        while (temp != null && count < place - 1) {
            temp = temp.next;
            count++;
        }
        Node q=new Node(y);
        q.next=temp.next;
        // temp.next=null;
        temp.next=q;
        return headNode;
    }
    public static Node deleteAtBeginning(Node headNode)
    {
        Node temp=headNode;
        headNode = headNode.next;
        temp.next=null;
        return headNode;
    }
    public static Node deleteAtEnd(Node headNode)
    {
        Node temp=headNode;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return headNode;
    }
    public static Node deleteAtMiddle(Node headNode,int pos)
    {
        int count=0;
        Node temp=headNode;
        while (count<pos-1) {
            temp=temp.next;
            count++;
        }
        temp.next=temp.next.next;
        return headNode;
    }
    public static void searchingElement(Node headNode,int searchingElement)
    {

        Node temp=headNode;
        int count1=0;
        while (temp!=null) {
           if(temp.data==searchingElement)
           {
            System.out.println("True");
            count1++;
            break;
           } 
           temp=temp.next;
        }
        if(count1==0)
        {
            System.out.println("Not found");  
        }
    }

}
