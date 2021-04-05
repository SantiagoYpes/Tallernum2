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
public class LinkedStack<E> {

    private Node<E> head;

    public LinkedStack() {
        head = null;
    }

    public boolean empty() {
        return head == null;
    }

    public E peek() {
        return head.getData();
    }

    public E push(E item) {
        head = new Node<>(item, head);
        return item;
    }

    public E pop() {
        if (empty()) {
            return null;
        } else {
            E temp = head.getData();
            head = head.getNextNode();
            return temp;
        }
    }

    @Override
    public String toString() {
        if (empty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (Node<E> i = head; i != null; i = i.getNextNode()) {
                info = info + i.getData() + " - ";
            }
            return info;
        }
    }

}
