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
public class ArrayStack {
    
    private Object[] data;
    private int top;
    private int max;

    public ArrayStack(int n){
        data = new Object[n];
        top=0;
        max=n;
    }
    
    public boolean empty(){
        return top==0;
    }
    
    public Object peek(){
        return data[top-1];
    }
    
    public Object push(Object item){
        if(top==max){
            return null;
        }else{
            data[top++] = item;
            return item;
        }
    }
    
    public Object pop(){
        if(empty()){
            return null;
        }else{
            Object temp = data[top-1];
            data[top-1] = null;
            return temp;
        }    
    }
    
    @Override
    public String toString(){
        String data = "[";
        for (int i = 0; i < max-1; i++) {
            data+=this.data[i]+", ";
        }
        data+=this.data[max-1]+"]";
        return data;
    }
    
    
    
}
