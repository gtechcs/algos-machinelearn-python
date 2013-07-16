package inclass.proj4.GenericLinkedBag;

public class GNode<E> {
  private E item;
  private GNode<E> next;

  public GNode(E newItem) {
    item = newItem;
    next = null;
  } // end constructor

  public GNode(E newItem, GNode<E> nextNode) {
    item = newItem;
    next = nextNode;
  } // end constructor

  public void setItem(E newItem) {
    item = newItem;
  } // end setItem

  public E getItem() {
    return item;
  } // end getItem

  public void setNext(GNode<E> nextNode) {
    next = nextNode;
  } // end setNext

  public GNode<E> getNext() {
    return next;
  } // end getNext
} // end class Node
