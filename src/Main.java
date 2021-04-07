public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> stringSinglyLinkedList = new SinglyLinkedList<>();
        stringSinglyLinkedList.add("hello");
        stringSinglyLinkedList.add("my");
        stringSinglyLinkedList.add("name");
        stringSinglyLinkedList.add("is");
        stringSinglyLinkedList.add("Nastya");

        System.out.println("a)\tGiven <String> singly linked list is: \"" + stringSinglyLinkedList.toString() + "\"");

        String toDelete = "name";
        int indexSingly = stringSinglyLinkedList.find(toDelete);
        stringSinglyLinkedList.remove(indexSingly);
        stringSinglyLinkedList.swap(stringSinglyLinkedList.get(indexSingly), stringSinglyLinkedList.get(indexSingly + 1));

        System.out.println("\tAfter removing element: \"" + toDelete +
                "\" and swapping two elements after it: \"" + stringSinglyLinkedList.toString() + "\"\n");

        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        integerSinglyLinkedList.add(1);
        integerSinglyLinkedList.add(0);
        integerSinglyLinkedList.add(2);
        integerSinglyLinkedList.add(3);
        integerSinglyLinkedList.add(4);
        integerSinglyLinkedList.add(5);
        integerSinglyLinkedList.add(0);
        integerSinglyLinkedList.add(6);
        integerSinglyLinkedList.add(7);
        integerSinglyLinkedList.add(8);
        integerSinglyLinkedList.add(9);

        System.out.println("b)\tGiven <Integer> singly linked list is: \"" + integerSinglyLinkedList.toString() + "\"");

        if (integerSinglyLinkedList.contains(0)) {
            int zeroIndex = integerSinglyLinkedList.findLast(0);
            int nextAfterZero = zeroIndex + 1;
            for (int i = 0; i < 3; i++) {
                integerSinglyLinkedList.remove(nextAfterZero);
            }
        }
        System.out.println("\tAfter removing 3 elements after last zero: \"" + integerSinglyLinkedList.toString() + "\"\n");

        DoublyLinkedList<String> stringDoublyLinkedList = new DoublyLinkedList<>();
        stringDoublyLinkedList.add("Vasya");
        stringDoublyLinkedList.add("Kolya");
        stringDoublyLinkedList.add("Petya");
        stringDoublyLinkedList.add("Masha");
        stringDoublyLinkedList.add("Nastya");
        System.out.println("c)\tGiven <String> doubly linked list is: \"" + stringDoublyLinkedList.toString() + "\"");

        toDelete = "Petya";
        int indexDoubly = stringDoublyLinkedList.find(toDelete);
        stringDoublyLinkedList.remove(indexDoubly);

        System.out.println("\tAfter removing element: \"" + toDelete + "\": \"" + stringDoublyLinkedList.toString() + "\"");
    }
}