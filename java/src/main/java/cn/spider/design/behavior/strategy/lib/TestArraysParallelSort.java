package cn.spider.design.behavior.strategy.lib;

import java.util.Arrays;

public class TestArraysParallelSort {
    public static void main(String[] args) {
        Arrays.parallelSort(new String[]{"foo", "bar"}, (o1, o2) -> (o1.charAt(0)) > (o2.charAt(0)) ? 1 : -1);
    }
}
