/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 * @param <T>
 */
public class DoubleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoubleLinkedList() {
        head = tail = null;
    }

    @Override
    public void add(T d) {
        //verificar si la lista esta vacia
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            //1.Crear un nuevo nodo con un siguiente apuntando a la cabeza
            DoubleNode<T> newNode = new DoubleNode<>(null, d, head);
            //2. Cambiar el anterior de la cabeza, para que sea el nuevo nodo
            head.setPreviousNode(newNode);
            //3. Actualizar la cabeza de la lista, para que sea el nuevo nodo
            head = newNode;
        }

    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            //1. Crear nuevo nodo: el anterior es la cola y el siguente es nulo
            DoubleNode<T> newNode = new DoubleNode<>(tail, d, null);
            //2. Cambiar el siguiente de la cola para que sea el nuevo nodo
            tail.setNextNode(newNode);
            //3. Actualizar la cola para que sea el nuevo nodo
            tail = newNode;
        }
    }

    @Override
    public void addAfter(T a, T b) {
        if(isEmpty()){
            System.out.println("Lista vacia");
        }else{
            //localizar y retornar del nodo
            DoubleNode<T> temp = new DoubleNode<>(null);
            for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {                
                if(i.getData().compareTo(a)==0){
                    temp = i;
                    break;                    
                }
            }
            //*************************************************************
            //Verificar si el dato no existe y evitar un nullPointerException
            //*************************************************************
            if(temp==null){
                System.out.println("No se encuentra el dato");
            }else{
                //*************************************************************
                //Verificar si el dato que se busca se encuentra al final.(nullPointerException)
                //*************************************************************
                //1. Crear un nuevo nodo con enlaces al anterior donde localizo
                //el dato, y al siguiente con el siguiente del nodo localizado
                DoubleNode<T> newNode = new DoubleNode<>(temp,b,temp.getNextNode());
                //2. En el nodo localizado previamente, cambiar el siguiente
                //al nuevo nodo
                temp.setNextNode(newNode);
                //3. Cambiar el anterior del siguiente del nuevo nuevo, 
                //para que apunte al nuevo nodo
                newNode.getNextNode().setPreviousNode(newNode);
                
            }

            
        }
    }
    //PUNTO 5 DEL TALLER 2
    @Override
    public void addOrdered(T d) {
        //Crear un nodo para el nuevo dato.
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty() || newNode.getData().compareTo(head.getData()) == -1) {
            add(d);
        }
        else {
            DoubleNode<T> currentNode = head;
            while (currentNode.getNextNode() != null
                    && currentNode.getNextNode().getData().compareTo(d) < 0) {
                //avanzar
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
    }
 
    @Override
    public void deleteFirts() {

        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } else //Verificar que si la lista tiene un solo dato
        {
            if (head == tail) {
                head = tail = null;
            } else {
                //1. Actualizar la cabeza: siguiente de la cabeza actual
                head = head.getNextNode();
                //2. Cambiar el anterior de la cabeza para que sea null
                head.setPreviousNode(null);
            }
        }

    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } else //Verificar que si la lista tiene un solo dato
        {
            if (head == tail) {
                head = tail = null;
            } else {
                //1. Actualizar la cabeza: siguiente de la cabeza actual
                tail = tail.getPreviousNode();
                //2. Cambiar el anterior de la cabeza para que sea null
                tail.setNextNode(null);
            }
        }
    }
    //PUNTO 6 DEL TALLER 2
    @Override
    public boolean delete(T d) {
        boolean checkdeleted = false;
        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } else //Verificar que si la lista tiene un solo dato
        {
            if (head == tail) {
                head = tail = null;
            checkdeleted= true;
            } else{
                //1. Recorremos la lista
                for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {
                    if (i.getData()==d){
                        i= null;
                    }
                }
            }
        }
        return checkdeleted;
    }


    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (DoubleNode<T> i = head; i != null; i = i.getNextNode()) {
                info = info + i.getData() + " - ";
            }
            return info;
        }
    }

    public String showDataDesc() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (DoubleNode<T> i = tail; i != null; i = i.getPreviousNode()) {
                info = info + i.getData() + " - ";
            }
            return info;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean search(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
