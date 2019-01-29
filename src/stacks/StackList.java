package stacks;

import java.util.*;

public class StackList<E> implements Iterable<E> {
    private Node top;
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

        Node(E x, Node nxt)
        {
            data = x;
            next = nxt;
        }
    }

    public void push(E x)
    {
        top = new Node(x, top);
        size++;
    }

    public E pop()
    {
        if(size == 0)
            return null;

        E x = top.data;
        top = top.next;
        size--;
        return x;
    }

    public E peek()
    {
        if(size == 0)
            return null;

        return top.data;
    }

    public void clear()
    {
        top = null;
        size = 0;
    }

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

    public boolean isEmpty()
    {
        return top == null;
    }

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


        public StackIterator()
        {
            currentIndex = 0;
            currentNode = top;
        }

        public boolean hasNext(){return currentIndex < size;}

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
