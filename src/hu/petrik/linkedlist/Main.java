package hu.petrik.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int itemNum = 69;
        int min = 1;
        int max = 420;
        for (int i = 0; i < itemNum; i++) {
           int value = (int)(Math.random() * (max - min +1)) + min;
           list.add(value);
        }
        System.out.println(list);
        System.out.println(list.contains(420));
        System.out.println(list.containsRec(420));
    }
}
