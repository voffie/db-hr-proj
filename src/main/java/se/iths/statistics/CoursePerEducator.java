package se.iths.statistics;

public record CoursePerEducator(String educatorName, long courses) {
        @Override
        public String toString() {
            return "Educator name = '" + educatorName + "', Courses=" + courses;
        }
    }
