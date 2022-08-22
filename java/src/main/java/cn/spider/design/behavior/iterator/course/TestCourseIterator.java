package cn.spider.design.behavior.iterator.course;

import cn.spider.design.behavior.iterator.SimpleClient;

public class TestCourseIterator {
    public static void main(String[] args) {
        Course cp = new Course("cp");
        Course cpp = new Course("cpp");
        Course carbon = new Course("carbon");
        CourseAggregateImpl courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(cp);
        courseAggregate.add(cpp);
        courseAggregate.add(carbon);

        System.out.println("course list -----");
        printCourse(courseAggregate);
        courseAggregate.remote(cpp);
        System.out.println("course new list-----");
        printCourse(courseAggregate);
    }

    private static void printCourse(CourseAggregateImpl courseAggregate) {
        SimpleClient.Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            System.out.println("<" + course.getName() + ">");
        }
    }
}
