package com.muhammedokumus.part3;


public class MyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;



    private static class Node<E>{
        private E data;             /** Reference to the data */
        private Node<E> next;       /** Reference to the next node */
        private Node<E> prev;   /** Reference to the previous node */


        public E getData() {
            return data;
        }

        //Constructor
        /**
         * Creates a new Node with another Node reference in next and previous
         * @param data The data stored
         * @param next Reference of the next Node
         * @param prev Reference of the previous Node
         */
        private Node(E data, Node<E> next, Node<E> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Gives size of list
     * @return size as integer
     */
    public int size() { return size; }


    /**
     *
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty(){ return size == 0; }

    /**
     * Add item to the head of list
     * @param item to be added
     */
    public void add(E item){
        addFirst(item);
    }

    private void addFirst(E element){
        Node newNode = new Node(element,head,null);

        if(isEmpty()){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        }

        else{
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }

        size++;
    }

    /**
     * Prints list iterating backwards
     */
    public void printList(){
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    /**
     * removes element at the given index
     * @param index of the item
     * @return true if index is in range, false otherwise.
     */
    public boolean remove(int index) {
       Node temp = head;
       for(int i = 0; i < index; i++)
           temp = temp.next;

       if(temp != null){
           if(temp.prev == null){ //If first item is being removed
               head = temp.next;
               if(!isEmpty())
                   head.prev = null;
           }
           else if(temp.next == null){ //If last item is being removed
               tail = temp.prev;
               if(!isEmpty())
                   tail.next = null;
           }
           else{
               temp.prev.next = temp.next;
               temp.next.prev = temp.prev;
           }
           size--;
       }
       return temp != null;
    }
}
