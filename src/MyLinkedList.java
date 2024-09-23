public class MyLinkedList {
    private static class Node {
        Object value;
        Node next;
        Node prev;
        Node(Object value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = getNode(index);
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).value;
    }
    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Додаємо елементи
        list.add("First");
        list.add("Second");
        list.add("Third");

        // Виводимо розмір та елементи списку
        System.out.println("Size: " + list.size()); // Виведе: Size: 3
        System.out.println(list.get(0)); // Виведе: First
        System.out.println(list.get(1)); // Виведе: Second
        System.out.println(list.get(2)); // Виведе: Third

        // Видаляємо елемент за індексом 1
        list.remove(1);
        System.out.println("Size after removal: " + list.size()); // Виведе: Size after removal: 2
        System.out.println(list.get(1)); // Виведе: Third

        // Очищуємо список
        list.clear();
        System.out.println("Size after clearing: " + list.size()); // Виведе: Size after clearing: 0
    }
}
