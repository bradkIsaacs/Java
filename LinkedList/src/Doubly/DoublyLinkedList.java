package Doubly;
/*
 * @Author :Gayani Gupta 
 * @Description : CS2050 Doubly Linked Lists
 */

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	/***
	 * this class keeps track of each element information
	 * 
	 **/
	private class Node {
		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
		}
	}

	/**
	 * returns the size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * return whether the list is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * adds element at the starting of the linked list
	 * 
	 * @param element
	 */
	public void addFirst(E element) {
		Node tmp = new Node(element, head, null);
		if (head != null) {
			head.prev = tmp;
		}
		head = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * adds element at the end of the linked list
	 * 
	 * @param element
	 */
	public void addLast(E element) {

		Node tmp = new Node(element, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size++;
		System.out.println("adding: " + element);
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½ï¿½* this method walks forward through the linked list
	 * ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	public void iterateForward() {
		System.out.println("iterating forward..");
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½ï¿½* this method walks backward through the linked list
	 * ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	public void iterateBackward() {

		System.out.println("iterating backword..");
		Node tmp = tail;
		while (tmp != null) {
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½ï¿½* this method removes element from the start of the linked
	 * list ï¿½ï¿½ï¿½ï¿½ï¿½* @return ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	public E removeFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: " + tmp.element);
		return tmp.element;
	}

	/**
	 * this method removes element from the end of the linked list
	 * 
	 * @return
	 */
	public E removeLast() {
		if (size == 0)
			throw new NoSuchElementException();
		Node tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: " + tmp.element);
		return tmp.element;
	}

	public static void main(String a[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		// dll.removeLast();
		dll.iterateBackward();
	}
}