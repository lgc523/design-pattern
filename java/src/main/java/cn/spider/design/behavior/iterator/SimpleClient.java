package cn.spider.design.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class SimpleClient {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("s");
        aggregate.add("p");
        aggregate.add("i");
        aggregate.add("d");
        aggregate.add("e");
        aggregate.add("r");
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }

    public interface Iterator<E> {
        E next();

        boolean hasNext();
    }

    interface Aggregate<E> {
        boolean add(E element);

        boolean remove(E element);

        Iterator<E> iterator();
    }

    static class ConcreteIterator<E> implements Iterator<E> {
        private List<E> list;
        private int cursor = 0;

        public ConcreteIterator(List<E> list) {
            this.list = list;
        }

        public E next() {
            return this.list.get(this.cursor++);
        }

        public boolean hasNext() {
            return this.cursor < this.list.size();
        }
    }

    static class ConcreteAggregate<E> implements Aggregate<E> {
        private List<E> list = new ArrayList<E>();

        @Override
        public boolean add(E element) {
            return this.list.add(element);
        }

        @Override
        public boolean remove(E element) {
            return this.list.remove(element);
        }

        @Override
        public Iterator<E> iterator() {
            return new ConcreteIterator<E>(this.list);
        }
    }
}
