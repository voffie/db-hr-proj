package se.iths.statistics;

public record CoursePerEducator(String name, long count) {
        @Override
        public String toString() {
            return "CoursesPerEducator {" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
