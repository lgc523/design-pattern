package cn.spider.design.behavior.iterator.course;

import cn.spider.design.behavior.iterator.SimpleClient;

import java.util.ArrayList;
import java.util.List;

public class CourseAggregateImpl implements CourseAggregate {
    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void add(Course course) {
        courseList.add(course);
    }

    @Override
    public void remote(Course course) {
        courseList.remove(course);
    }

    @Override
    public SimpleClient.Iterator<Course> iterator() {
        return new IteratorImpl<>(courseList);
    }
}
