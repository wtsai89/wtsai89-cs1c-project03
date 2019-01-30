package stacks;

import java.util.*;

/**
 * Manages items in a singly linked list where we can only push() and pop() items from one end of the stack.
 * @param <E>
 */
public class StackList<E> implements Iterable<E> {
    private Node top;               //Points to the top of the stack. Recall that elements can be added or removed from only one end of the stack.
    private String name;
    private int size;

    /**
     * Constructor
     * @param str   name
     */
    public StackList(String str)
    {
        name = str;
        top = null;
        size = 0;
    }

    /**
     * Definition of inner Node class
     */
    private class Node
    {
        Node next;
        E data;

        /**
         * Generic Node constructor
         * @param x
         * @param nxt
         */
        Node(E x, Node nxt)
        {
            data = x;
            next = nxt;
        }
    }

    /**
     * Takes a generic item as the argument and adds the item to the top of the stack
     * @param x
     */
    public void push(E x)
    {
        top = new Node(x, top);
        size++;
    }

    /**
     *  Removes the item from the top of the stack.
     * @return  Returns the generic item popped.
     */
    public E pop()
    {
        if(size == 0)
            return null;

        E x = top.data;
        top = top.next;
        size--;
        return x;
    }

    /**
     * Looks at the top of the stack and returns a generic type for the data seen at the top of the stack. The item should not be removed from the top of the stack.
     * @return
     */
    public E peek()
    {
        if(size == 0)
            return null;

        return top.data;
    }

    /**
     * Discards all object references from the linked-list to "empty" this StackList instance.
     */
    public void clear()
    {
        top = null;
        size = 0;
    }

    /**
     * Includes the name of the stack passed in by the Navigator class in addition to the number of links in the stack.
     * @return
     */
    public String toString()
    {
        String s = name + ": " + size + " links\n[";
        Iterator it = iterator();
        if(!it.hasNext())
            s += " ]\n";
        while(it.hasNext())
        {
            s += it.next();
            if(it.hasNext())
                s += ", ";
            else
                s += "]\n";
        }
        return s;
    }

    /**
     * Checks if the top of the stack is pointing to anything.
     * @return
     */
    public boolean isEmpty()
    {
        return top == null;
    }

    /**
     * Returns the number of elements in the stack.
     * @return
     */
    public int size() { return size; }

    /**
     * Iterator method
     * @return
     */
    public java.util.Iterator<E> iterator() { return new StackIterator(); }

    /**
     * Internal Iterator class
     */
    private class StackIterator implements java.util.Iterator<E>
    {
        protected Node currentNode;
        protected int currentIndex;


        /**
         * Default constructor
         */
        public StackIterator()
        {
            currentIndex = 0;
            currentNode = top;
        }

        /**
         * Checks if the stack has any more items at the current position
         * @return
         */
        public boolean hasNext(){return currentIndex < size;}

        /**
         * Iterates once
         * @return
         */
        public E next()
        {
            if( !hasNext() )
                throw new java.util.NoSuchElementException();

            Node lastNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
            return lastNode.data;
        }
    }
}
