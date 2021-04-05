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
public class CircularDoubleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private DoubleNode<T> head;

    public CircularDoubleLinkedList() {
        head = null;
    }

    @Override
    public void add(T d) {
        if (isEmpty()) {
            DoubleNode<T> newNode = new DoubleNode<>(d);
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        }else{
            DoubleNode<T> newNode = new DoubleNode<>(head.getPreviousNode(),d,head);
            newNode.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            head = newNode;
        }
    }

    @Override
    public void addLast(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAfter(T a, T b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrdered(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFirts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            return showDataRecursive(head);
        }
    }

    private String showDataRecursive(DoubleNode currentNode) {
        if (currentNode == head.getPreviousNode()) {
            return currentNode.getData().toString();
        } else {
            return currentNode.getData() + " - " + showDataRecursive(currentNode.getNextNode());
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    //PUNTO 9 DEL TALLER 2
    @Override
    public boolean search(T d) {
       if(isEmpty()){
            return false;
        }else{
            return searchR(d,head);
        }
    }   
    private boolean searchR(T d, DoubleNode<T> head) {
        //casos base de la recursividad.
        if(currentNode==tail && !currentNode.getData().equals(d)){
            return false;
        }else if(currentNode.getData().equals(d)){
            return true;
        }else{
            return searchR(d, currentNode.getNextNode());
        }
    }
}

