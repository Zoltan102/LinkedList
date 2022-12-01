package hu.petrik.linkedlist;

public class LinkedList<T> {
    private ListItem first;
    private ListItem last;

    public void add(T value) {
        ListItem newItem = new ListItem(value);
        newItem.setPrevious(this.last);
        if (this.first == null) {
            this.first = newItem;
        } else {
            this.last.setNext(newItem);
        }
        this.last = newItem;
    }

    public boolean contains(T value) {
        boolean contains = false;
        ListItem currentItem = this.first;
        while (currentItem != null && !contains) {
            if (currentItem.value == value) {
                contains = true;
            }
            currentItem = currentItem.next;
        }
        return contains;
    }

    public boolean containsRec(T value) {
        return first.contains(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListItem currentItem = this.first;
        if (currentItem != null) {
            builder.append(currentItem);
            currentItem = currentItem.next;
        }
        while (currentItem != null) {
            builder.append(", ").append(currentItem);
            currentItem = currentItem.next;
        }
        return builder.toString();
    }

    private class ListItem {
        private T value;
        private ListItem next;
        private ListItem previous;

        public ListItem(T value) {
            this.value = value;
        }

        public ListItem getNext() {
            return next;
        }

        public void setNext(ListItem next) {
            this.next = next;
        }

        public ListItem getPrevious() {
            return previous;
        }

        public void setPrevious(ListItem previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }

        public boolean contains(T value) {
            boolean contains = false;
                if (this.value == value) {
                    contains = true;
                } else if (this.next != null) {
                    contains = this.next.contains(value);
                }
            return contains;
        }
    }
}