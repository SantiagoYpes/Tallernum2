/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 */
public class LinkedQueue<E> {
    
    private Node<E> head;
    private Node<E> tail;

    public LinkedQueue() {
        head = tail = null;
    }
    
    public void offer(E e){
        Node<E> newNode = new Node<>(e);
        if(empty()){
            head = tail = newNode;
        }else{
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }
    
    public boolean empty(){
        return head==null;
    }
    
    
    @Override
    public String toString() {
        if (empty()) {
            return "Cola vacia";
        } else {
            String info = "[";
            for (Node<E> i = head; i.getNextNode() != null; i = i.getNextNode()) {
                info = info + i.getData() + " - ";
            }
            info += tail.getData()+"]";
            return info;
        }
    }
}
