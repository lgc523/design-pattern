package cn.spider.design.behavior.iterator.course;

import cn.spider.design.behavior.iterator.SimpleClient;

import java.util.List;

public class IteratorImpl<E> implements SimpleClient.Iterator<E> {
    private List<E> list;
    private int cursor;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.println("当前位置" + cursor + ": ");
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return cursor <= list.size() - 1;
    }
}
