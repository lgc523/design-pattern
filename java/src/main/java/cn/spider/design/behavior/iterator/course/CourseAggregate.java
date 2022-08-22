package cn.spider.design.behavior.iterator.course;

import cn.spider.design.behavior.iterator.SimpleClient;

public interface CourseAggregate {
    void add(Course course);

    void remote(Course course);

    SimpleClient.Iterator<Course> iterator();
}
