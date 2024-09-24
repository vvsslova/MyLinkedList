package com.github.vvsslova;

import lombok.Data;

import java.util.Arrays;

/**
 * Класс описывает структуру двусвязного списка.
 *
 * @param <T> тип, которым параметризуются элементы класса.
 */
@Data
public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    MyLinkedList() {
    }

    /**
     * Добавление элемента в начало списка.
     *
     * @param element добавляемый элемент.
     */
    private void addFirst(T element) {
        final Node<T> oldFirstNode = first;
        final Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = newNode;
        } else {
            first = newNode;
            newNode.setNext(oldFirstNode);
            oldFirstNode.setPrev(newNode);

        }
    }

    /**
     * Добавление элемента в конец списка.
     *
     * @param element добавляемый элемент.
     */
    private void addLast(T element) {
        final Node<T> oldLastNode = last;
        final Node<T> newNode = new Node<T>(element);
        if (last == null) {
            last = newNode;
            first.next = last;
            last.prev = first;
        } else {
            last = newNode;
            oldLastNode.next = newNode;
            newNode.prev = oldLastNode;
        }
    }

    /**
     * Добавление элемента.
     *
     * @param index   индекс, куда добавляется элемент.
     * @param element добавляемый элемент.
     * @throws IndexOutOfBoundsException в случае, если индекс выходит за пределы размера списка.
     */
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            final Node<T> newNode = new Node<>(element);
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            newNode.next = node;
            newNode.prev = node.getPrev();
            node.getPrev().next = newNode;
            node.prev = newNode;

        }
        size++;
    }

    /**
     * Получение элемента.
     *
     * @param index индекс элемента.
     * @throws IndexOutOfBoundsException в случае, если индекс выходит за пределы размера списка.
     */
    public void get(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            System.out.println(node.item);
        }
    }

    /**
     * Удаление элемента.
     *
     * @param index индекс элемента.
     * @throws IndexOutOfBoundsException в случае, если индекс выходит за пределы размера списка.
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> node = first;
            for (int i = 0; i < index - 1; i++) {
                node = node.getNext();
            }
            Node<T> prevNode = node.getPrev();
            Node<T> nextNode = node.getNext();
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    /**
     * Возвращает элементы списка по их значениям.
     */
    public void getElements() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> node = first; node != null; node = node.next)
            result[i++] = node.item;
        System.out.println(Arrays.toString(result));
    }

    /**
     * Возвращает элементы списка по их значениям в обратном порядке.
     */
    public void getReversedOrderElements() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = last; x != null; x = x.prev)
            result[i++] = x.item;
        System.out.println(Arrays.toString(result));
    }

    /**
     * Класс описывает структуру узла.
     *
     * @param <E> тип, которым параметризуются элементы класса.
     */
    @Data
    static class Node<E> {
        private final E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item) {
            this.item = item;
        }
    }
}
