/**
 * Class for a DoubleChainedList
 *
 * @author Nico Gruschke
 * @version 0.1
 */
import java.util.*;

public class DoubleChainedList<T> implements java.util.List<T>{
    
    private int size;
    private Node first;
    private Node last;
    
    
    /**
     * DoubleChainedList Constructor
     *
     */
    public DoubleChainedList(){
        this.size = 0;
        this.first = new Node(null, null, null);
        this.last = new Node(null, null, first);
    }
    
    private class Node{
        T value;
        Node next;
        Node prev;
        
        /**
         * Node Constructor
         *
         * @param value of the Node
         * @param next what is after the value
         * @param prev what is before the value
         */
        public Node(T value, Node next, Node prev){
            setValue(value);
            setNext(next);
            setPrev(prev);
        }
        
        /**
         * Method setValue
         *
         * @param value A parameter
         */
        public void setValue(T value){
            this.value = value;
        }
        
        /**
         * Method set previous
         *
         * @param prev is a Node
         */
        public void setPrev(Node prev) {
            this.prev = prev;
            
        }

        
        /**
         * Method getNext
         *
         * @return the next value
         */
        public Node getNext(){
            return next;
        }
        
        /**
         * Method getPrev
         *
         * @return the previous value
         */
        public Node getPrev(){
            return prev;
        }
        
        /**
         * Method set Next
         *
         * @param next is a Node
         */
        public void setNext(Node next){
            this.next = next;
        }
    }

    /**
     * Method give the size of the List
     *
     * @return the size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method see if the list is empty
     *
     * @return if the list is empty or not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Method see if the list contains the object o
     *
     * @param o is a object
     * @return if o is in the list or not
     */
    @Override
    public boolean contains(Object o) {
        Node y = first.next;
        for(int i = 0; i< size; i++){
            if(y.value.equals(o)){ 
                return true;
            }
            y = y.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Method toArray return the array
     *
     * @param a is a type array
     * @return the array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        T[] numArray = (T[])new Object[size];
        for(int i = 0; i< size(); i++){
            numArray[i] = (T)get(i);
        }
        return numArray;
    }

    /**
     * Method add a element
     *
     * @param e is a element
     * @return the adding is done
     */
    @Override
    public boolean add(T e) {
        Node lastInList = last.prev;
        Node toAdd = new Node(e, last, lastInList);
        lastInList.next = toAdd;
        last.prev = toAdd;
        size++;
        return true;
    }

    /**
     * Method remove a object o
     *
     * @param o is a object
     * @return if the object is removed or not
     */
    @Override
    public boolean remove(Object o) {
        if(this.contains(o)){
            int i = indexOf(o);
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Method addAll element of a new list
     *
     * @param c is a type
     * @return true
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arrayToAdd = (T[]) c.toArray();
        for (int i = 0; i < arrayToAdd.length; i++) {
            this.add(arrayToAdd[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Method clear the list
     *
     */
    @Override
    public void clear() {
        int  leng = size;  
        for(int i = 0; i < leng; i++){       
            set(i, null);
            size--;
        }
        
    }

    /**
     * Method get the ielement in a index 
     *
     * @param index is a int
     * @return te value of the element
     */
    @Override
    public T get(int index) {
        if(index >= size){
            return null;
        }
        Node x = first.next;
        for(int i = 0; i< index; i++){
            x = x.next;
        }
        return x.value;
    }

    /**
     * Method set a new object in a specific place
     *
     * @param index
     * @param element
     * @return The element
     */
    @Override
    public T set(int index, T element) {
         Node x = first.next;
            for (int j = 0; j < index; j++) {
                x = x.next;
            }
            x.setValue(element);
            return element;
    }

    /**
     * Method add an element in a index
     *
     * @param index is the place to add the element
     * @param element 
     */
    @Override
    public void add(int index, T element) {
        Node toAdd = new Node(element, (Node)get(index + 1), (Node)get(index - 1));
        for(int j = index; j < size; j++){
            set(j, get(j+1));
        } 
        
    }

    /**
     * Method remove the element of a specific place
     *
     * @param index is the place of the type we want to remove
     * @return the list
     */
    @Override
    public T remove(int index) {
         T result = get(index);
            this.size--;
            for(int j = index; j < size; j++){
                set(j, get(j+1));
            }    
            return result;
    }

    /**
     * Method giv the index of an object o
     *
     * @param o is a object
     * @return The index of o
     */
    @Override
    public int indexOf(Object o) {
         int result = -1;
            for(int i = 0; i < size; i++){
                Node ix = (Node)get(i);
                if (ix.value.equals(o)){
                    result = i;
                }
            }
            return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new java.lang.UnsupportedOperationException();
    }

}
