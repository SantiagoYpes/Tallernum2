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
public class ExampleNode {
    private int data;
    private ExampleNode nextNode;
    private ExampleNode previousNode;

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the nextNode
     */
    public ExampleNode getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(ExampleNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * @return the previousNode
     */
    public ExampleNode getPreviousNode() {
        return previousNode;
    }

    /**
     * @param previousNode the previousNode to set
     */
    public void setPreviousNode(ExampleNode previousNode) {
        this.previousNode = previousNode;
    }
    
}
