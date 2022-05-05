package Intersection;//import java.util.LinkedList;
import java.util.Scanner;

public class Intersection {

    public static void main(String[] args) {

        //list1
        Node<Integer> n1=new Node<Integer>(1);
        Node<Integer> n2=new Node<Integer>(2);
        Node<Integer> n3=new Node<Integer>(3);
        Node<Integer> n4=new Node<Integer>(4);
        Node<Integer> n5=new Node<Integer>(5);
        Node<Integer> n6=new Node<Integer>(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;


        //list2
        Node<Integer> n7=new Node<Integer>(2);
        n7.next=n4;

        Node<Integer> head=n1;
        Node<Integer> head2=n7;

        Node<Integer> intersectingNode= getIntersectionNode(head,head2);
        System.out.println(intersectingNode.data);
        //print(head);
    }

    private static Node<Integer> getIntersectionNode(Node<Integer> head, Node<Integer> head2) {


        Node<Integer> t1=head;
        Node<Integer> t2=head2;


        int headlen=0;
        while (t1!=null){
            headlen++;
            t1=t1.next;
        }

        int head2len=0;
        while (t2!=null){
            head2len++;
            t2=t2.next;
        }
        int diff=Math.abs(headlen-head2len);

        if(headlen>head2len){
            //not needed
            t1=head;
            while(diff!=0){
                t1=t1.next;
                diff--;
            }

            //check the intersection
            t2=head2;
            while(t1!=null && t2!=null){
                if(t1==t2){
                    return t1;
                }


                t1=t1.next;

                t2=t2.next;
            }
        }else{

            t2=head2;
            while(diff!=0){
                t2=t2.next;
                diff--;
            }


            //check the intersection
            t1=head;
            while(t1!=null && t2!=null){
                if(t1==t2){
                    return t1;
                }


                t1=t1.next;

                t2=t2.next;
            }

        }
        return null;
    }

//    private static void print(Node<Integer> head) {
//    }

    private static Node<Integer> createlist() {

        Scanner sc= new Scanner(System.in);
        int data=sc.nextInt();


        Node<Integer> head=null;
        Node<Integer> tail=null;
        while(data!=-1){
            Node<Integer> newNode= new Node<Integer>(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;

            }
            data=sc.nextInt();
        }
        return head;

    }
}
