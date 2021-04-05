/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *Define las acciones de las listas (contrato)
 * @author udem
 */
public interface ILists<T> {
    /**
     * Agregar un nuevo dato a la lista al inicio
     * @param d Contenido del nodo 
     */
    public void add(T d);
    /**
     * Agregar un nuevo dato a la lista al final
     * @param d 
     */
    public void addLast(T d);
    /*
    jxjdjasfg sf agfa hsdfga jkfgjasfd
    */
    /**
     * Agregar un nuevo dato a la lista despues de una dato existente
     * @param a Dato donde se va a ubicar a continunación el nuevo valor
     * @param b Nuevo dato.
     */
    public void addAfter(T a, T b); 
    /**
     * Borrar el primer elemento de la lista
     * @param d
     */
    
    public void addOrdered(T d);
    
    public void deleteFirts();
    /**
     * Borrar el últiumo elemento de la lista
     */
    public void deleteLast();    
    /**
     * Eliminar un elemento especifico de la lista
     * @param d El dato a borrar
     * @return verdadero si la borro, falso si no lo encontro
     */
    public boolean delete(T d);
    public String showData();
    public boolean isEmpty();    
    public boolean search(T d);
}
