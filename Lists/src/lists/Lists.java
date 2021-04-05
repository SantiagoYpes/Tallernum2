/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Stack;

/**
 *
 * @author samaniw
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
        ExampleNode n1 = new ExampleNode();
        ExampleNode n2 = new ExampleNode();
        ExampleNode n3 = new ExampleNode();
        ExampleNode n4 = new ExampleNode();
        ExampleNode n5 = new ExampleNode();
        ExampleNode n6 = new ExampleNode();
        ExampleNode n7 = new ExampleNode();
        ExampleNode n8 = new ExampleNode();
        n1.setData(99);
        n2.setData(88);
        n3.setData(77);
        n4.setData(66);
        n5.setData(55);
        n6.setData(44);
        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n3.setNextNode(n4);
        n4.setNextNode(n5);
        n5.setNextNode(n6);
//        System.out.println("Dato del primer nodo");//avanzar dos nodos y obtener el dato
//        System.out.println(n1.getNextNode().getNextNode().getData());
//        System.out.println("--------");
        System.out.println("");
        //Instaciación de clase con dato genérico
        Box<Integer> bbb = new Box<>();
        bbb.Experiment();
        bbb.Experiment(99);
        bbb.Experiment(88, 44);
        Box<Double> ccc = new Box<>();

        Box<String> ddd = new Box<>();
        //Ejemplo de inserción de datos en lista simple
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.addOrdered(88);
        sll.addOrdered(99);
        sll.addOrdered(101);
        sll.addOrdered(109);
        sll.addOrdered(77);
        sll.addOrdered(109);
        sll.addOrdered(109);
        sll.addOrdered(11);
        sll.addOrdered(122);

        System.out.println(sll.showData());
        System.out.println(sll.delete(109));
//        sll.add(55);
//        sll.add(66);
//        sll.add(77);
//        sll.add(88);
//        sll.add(99);
//        sll.add(22);
//        sll.add(33);
//        sll.add(715);
//        sll.add(8888);
        System.out.println(sll.showData());

        /*Toda validación retorna falso o verdadero
        int a=55,b=66;
        System.out.println(a!=b);*/
        //Pruebas de lista doble
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.addLast(33);
        dll.addLast(44);
        dll.addLast(88);
        dll.addLast(66);
        dll.addLast(99);

        System.out.println("Resultados de la lista dobble");
        System.out.println(dll.showData());
        //Falta evitar un NullPointerException al buscar el último dato...
        //dll.addAfter(99,11);
        //System.out.println(dll.showDataDesc());        
//        dll.deleteLast();
//        dll.deleteLast();
//        dll.deleteFirts();

        System.out.println(dll.showData());

        //Pruebas para lista circular simple
        CircularSingleLinkedList<Integer> csl = new CircularSingleLinkedList<>();
        csl.add(11);
        csl.add(77);
        csl.add(88);
        csl.add(101);
        csl.add(33);
        csl.add(44);
        csl.add(55);
        System.out.println("Búsqueda de dato: " + csl.search(99));
        System.out.println("Datos de la lista circular simple");
        System.out.println(csl.showData());

        CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList<>();
        cdll.add(22);
        cdll.add(33);
        cdll.add(44);
        cdll.add(55);
        System.out.println("Datos de la lista circular doble: " + cdll.showData());

        //Pruebas de pila con arreglo
        ArrayStack as = new ArrayStack(6);
        as.push(44);
        as.push(33);
        as.push(55);
        as.push(22);
        System.out.println(as);

        //pruebas de pila con nodos
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(11);
        ls.push(99);
        ls.push(22);
        ls.push(88);
        ls.push(33);
        System.out.println(ls);
        ls.pop();
        System.out.println(ls);

        //Pruebas para verificar el balance de una expresión
        String expresion = "(5 +(5 * 5))/55";
        System.out.println("Verificar parentesis: " + checkParentheses(expresion));

        //Pruebas de conversión a binario
        System.out.println("Convetir a binario: " + toBinary(1));
        
        //pruebas de cola
        
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        lq.offer(22);
        lq.offer(33);
        lq.offer(44);
        lq.offer(66);
        lq.offer(11);
        lq.offer(99);
        System.out.println("Datos de la cola: "+lq);
//        Stack<Integer> testStack = new Stack<>();
//        testStack.push(22);
//        testStack.push(33);
//        testStack.push(44);
//        testStack.push(55);
//        testStack.push(66);
//        System.out.println(testStack);
//        System.out.println(testStack.search(22));
        String aa = "2";
        String bb = "1";
        System.out.println("Resultados de compareTo");
        System.out.println(aa.compareTo(bb));

    }
//Ejemplo de genérico
//https://docs.oracle.com/javase/tutorial/java/generics/types.html

    public static class Box<E> {

        private E[] object;

        public void Experiment() {
            System.out.println("Experiment 1");
        }

        public void Experiment(int x) {
            System.out.println("Experiment " + x);
        }

        public void Experiment(int x, int y) {
            System.out.println("Experiment " + x + y);
        }

        public void set(E[] object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }

    //Verificar si una expresión esta balanceada
    public static boolean checkParentheses(String exp) {

        LinkedStack<String> checkBalance = new LinkedStack<>();
        char[] arrayExp = exp.toCharArray();
        for (int i = 0; i < arrayExp.length; i++) {
            if (arrayExp[i] == '(') {
                checkBalance.push("(");
            } else if (arrayExp[i] == ')') {
                if (checkBalance.empty()) {
                    return false;
                } else {
                    checkBalance.pop();
                }
            }
        }
        return checkBalance.empty();
    }

    //convertir de decimal a binario
    public static String toBinary(int n) {
        LinkedStack<Integer> residue = new LinkedStack<>();
        String binary ="";
        while (n>0) {            
            residue.push(n % 2);
            n /= 2;
        }
        while (!residue.empty()) {            
            binary+=residue.pop();
        }
        return binary;
    }

}
