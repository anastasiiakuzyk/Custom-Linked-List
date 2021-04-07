public class SinglyLinkedList<T> {

    private SinglyNode<T> head = null;

    public void add(T value) {
        SinglyNode<T> objectSinglyNode = new SinglyNode<>(value);

        if (head == null) {
            head = objectSinglyNode;
        } else {
            SinglyNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(objectSinglyNode);
        }
    }

    public void remove(int index) {
        SinglyNode<T> current = head;
        SinglyNode<T> previous = null;
        int currentIndex = 0;
        do {
            if (currentIndex == index) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
            currentIndex++;
        } while (current != null);
    }

    public T get(int index) {
        SinglyNode<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index)
                return current.getValue();
            count++;
            current = current.getNext();
        }
        return null;
    }


    public boolean contains(T value) {
        SinglyNode<T> current = head;
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
        SinglyNode<T> current = head;
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

    public int findLast(T value) {
        SinglyNode<T> current = head;
        int lastFind = 0;
        int currentIndex = 0;
        while (current != null) {
            if (value == current.getValue())
                lastFind = currentIndex;
            current = current.getNext();
            currentIndex++;
        }
        return lastFind;
    }

    public void swap(T n1, T n2) {
        SinglyNode<T> prevNode1 = null;
        SinglyNode<T> prevNode2 = null;
        SinglyNode<T> node1 = head;
        SinglyNode<T> node2 = head;

        if (head == null) {
            return;
        }

        if (n1 == n2)
            return;

        while (node1 != null && node1.getValue() != n1) {
            prevNode1 = node1;
            node1 = node1.getNext();
        }

        while (node2 != null && node2.getValue() != n2) {
            prevNode2 = node2;
            node2 = node2.getNext();
        }

        if (node1 != null && node2 != null) {
            if (prevNode1 != null)
                prevNode1.setNext(node2);
            else
                head = node2;

            if (prevNode2 != null)
                prevNode2.setNext(node1);
            else
                head = node1;

            SinglyNode<T> temp = node1.getNext();
            node1.setNext(node2.getNext());
            node2.setNext(temp);
        } else {
            System.out.println("Swapping is not possible");
        }
    }

    @Override
    public String toString() {
        String result = "";
        SinglyNode<T> current = head;
        do {
            result = result.concat(current.toString() + " ");
            current = current.getNext();
        } while (current != null);
        return result;
    }
}

class SinglyNode<T> {
    private T value;
    private SinglyNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }

    public SinglyNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

