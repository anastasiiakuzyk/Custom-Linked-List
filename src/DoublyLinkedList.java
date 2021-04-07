public class DoublyLinkedList<T> extends SinglyLinkedList<T> {

    private DoublyNode<T> head = null;
    private DoublyNode<T> tail = null;

    public void add(T value) {
        DoublyNode<T> objectDoublyNode = new DoublyNode<>(value);
        if (head == null) {
            head = objectDoublyNode;
            tail = objectDoublyNode;

            head.setPrev(null);

            tail.setNext(null);
        } else {
            tail.setNext(objectDoublyNode);
            objectDoublyNode.setPrev(tail);
            tail = objectDoublyNode;
            tail.setNext(null);
        }
    }

    public void remove(int index) {
        if (head == null || index <= 0)
            return;

        DoublyNode<T> current = head;

        for (int i = 1; current != null && i < index; i++) {
            current = current.getNext();
        }

        if (head == null || current == null) {
            return;
        }

        if (head == current) {
            head = current.getNext();
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }
    }

    public boolean contains(T value) {
        DoublyNode<T> current = head;
        boolean flag = false;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                if (current.getValue() == value) {
                    flag = true;
                    break;
                }
                current = current.getNext();
            }
        }
        return flag;
    }

    public int find(T value) {
        DoublyNode<T> current = head;
        int currentIndex = 0;
        if (contains(value)) {
            while (current != null) {
                if (value == current.getValue()) {
                    return currentIndex;
                }
                current = current.getNext();
                currentIndex++;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String result = "";
        DoublyNode<T> current = head;
        do {
            result = result.concat(current.toString() + " ");
            current = current.getNext();
        } while (current != null);
        return result;
    }
}

class DoublyNode<T> {
    private T value;
    private DoublyNode<T> prev;
    private DoublyNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public DoublyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public DoublyNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

