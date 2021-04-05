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
public class SingleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private Node<T> head;

    public SingleLinkedList() {
        head = null;
    }

    @Override
    public void add(T d) {
        //1. Crear un nuevo nodo
        Node<T> newNode = new Node<>(d);
        //2. Modificar el siguiente del nuevo nodo(cabeza)
        newNode.setNextNode(head);
        //3. Cambiar la cabeza de la lista(nuevo nodo)
        head = newNode;
    }
    
    //PUNTO 2 DEL TALLER 2
    @Override
    public void addLast(T d) {
        //1.Se recorre la lista hasta llegar al elemento null
        Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                if (currentNode.getNextNode().getData() == null){
                    //2.Se crea el nuevo nodo
                    Node<T> newNode = new Node<>(d);
                    //3.Lo insertamos antes del elemento null
                    newNode.setNextNode(currentNode);
                }
                currentNode = currentNode.getNextNode();
            }
    }
    // PUNTO 1 DEL TALLER 2
    public int Cantidad(T d) {
        //1.Se crea la variable cantidad
        int cant = 0;
        //2. Se recorre la lista
        Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                //3.Se incrementa la cantidad por cada nodo recorrido
                cant++;
                currentNode = currentNode.getNextNode();
            }
        return cant;
    }
    
    
    //PUTNO 3 DEL TALLER 2
    @Override
    public void addAfter(T a, T b) {
         //1.Se recorre la lista hasta llegar al elemento especifico
        Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                if (currentNode.getNextNode().getData() == b){
                    //2.Se crea el nuevo nodo
                    Node<T> newNode = new Node<>(a);
                    //3.Lo insertamos después del elemento indicado
                    newNode.setNextNode(currentNode.getNextNode());
                }
                currentNode = currentNode.getNextNode();  
            }
    }

    @Override
    public void deleteFirts() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            //cambiar cabeza
            //la nueva cabeza será el siguiente de la cabeza actual
            head = head.getNextNode();
        }
    }
    //PUNTO 4 DEL TALLER 2
    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            Node<T> currentNode = head;
            //Recorremos la lista y encontramos el ultimo dato que es null
            while (currentNode.getNextNode()!= null) {
                // Verificar si el dato del siguiente nodo es nulo
                if (currentNode.getNextNode().getData() == null) {
                    //Cambiar el siguiene del actual para que se ubique dos pasos adelante
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                }
            currentNode = currentNode.getNextNode();      
            }    
        }
    }

    @Override
    public boolean delete(T d) {
        boolean checkDeleted = false;
        //1. Validar si el dato a borrar esta en la cabeza
        if (head.getData() == d) {
            deleteFirts();
            checkDeleted = true;            
        } else {
            //2. Recorrer toda la estructura
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                //3. Verificar si el dato se encuentra en el siguiente nodo
                if (currentNode.getNextNode().getData() == d) {
                    //4.Cambiar el siguiene del actual para que se ubique dos pasos adelante
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                    checkDeleted = true;                   
                } //5. Avanzar un nodo
                else if (currentNode.getNextNode() != null) {
                    currentNode = currentNode.getNextNode();
                }
                //System.out.println("");
            }
        }
        return checkDeleted;

    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (Node<T> i = head; i != null; i = i.getNextNode()) {
                info = info + i.getData() + " - ";
            }

            //forma tradicional de recorrer lista con Mientras
            /*Node<T> currentNode = head;
            while (currentNode!=null) {
                info = info + currentNode.getData();
                currentNode = currentNode.getNextNode();
            }*/
            return info;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;/*
        if (head == null) {
            return true;
        } else {
            return false;
        }*/

    }

    @Override
    public boolean search(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrdered(T d) {
        //Crear un nodo para el nuevo dato.
        Node<T> newNode = new Node<>(d);
        /*Si la lista esta vacía, o el valor del primer elemento de la lista 
            es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
            de la lista y modificar la cabecera respectivamente.*/
        if (isEmpty() || newNode.getData().compareTo(head.getData()) == -1) {
            add(d);
        } /*
        Si no se cumple el caso anterior, buscar el lugar adecuado 
        para la inserción: recorrer la lista conservando el nodo actual. 
        Inicializar nodo actual con el valor de primera posición, 
        y avanzar mientras el siguiente nodo no sea nulo y el dato que 
        contiene la siguiente posición sea menor o igual que el dato a insertar.
         */ else {
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null
                    && currentNode.getNextNode().getData().compareTo(d) < 0) {
                //avanzar
                currentNode = currentNode.getNextNode();
            }
            /*
            Con esto se seña al nodo adecuado, a continuación insertar el 
            nuevo nodo a continuación de él
             */
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }

    }

}
