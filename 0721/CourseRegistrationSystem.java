import java.util.ArrayList;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();

        addCourse(courses, new Course("CS101", "Java 程式設計", 2));
        addCourse(courses, new Course("CS102", "資料結構", 30));

        enrollCourse(courses, "CS101");
        enrollCourse(courses, "CS101");
        enrollCourse(courses, "CS101"); // 測試額滿

        dropCourse(courses, "CS102"); // 測試無人退選

        System.out.println("\n--- 系統統計資料 ---");
        printSummary(courses);
    }

    public static Course findCourse(ArrayList<Course> courses, String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    public static void addCourse(ArrayList<Course> courses, Course course) {
        if (findCourse(courses, course.getCode()) == null) {
            courses.add(course);
            System.out.println("成功新增課程：" + course.getName());
        } else {
            System.out.println("新增失敗：課程代碼重複。");
        }
    }

    public static void enrollCourse(ArrayList<Course> courses, String code) {
        Course c = findCourse(courses, code);
        if (c == null) {
            System.out.println("選課失敗：找不到課程。");
        } else if (c.enroll()) {
            System.out.println("選課成功：" + c.getName());
        } else {
            System.out.println("選課失敗：" + c.getName() + " 已額滿！");
        }
    }

    public static void dropCourse(ArrayList<Course> courses, String code) {
        Course c = findCourse(courses, code);
        if (c == null) {
            System.out.println("退選失敗：找不到課程。");
        } else if (c.drop()) {
            System.out.println("退選成功：" + c.getName());
        } else {
            System.out.println("退選失敗：" + c.getName() + " 目前無人修課。");
        }
    }

    public static void removeCourse(ArrayList<Course> courses, String code) {
        Course c = findCourse(courses, code);
        if (c != null) {
            courses.remove(c);
            System.out.println("課程已刪除：" + code);
        } else {
            System.out.println("刪除失敗：找不到課程。");
        }
    }

    public static void printSummary(ArrayList<Course> courses) {
        int totalEnrolled = 0;
        ArrayList<String> fullCourses = new ArrayList<>();

        for (Course c : courses) {
            totalEnrolled += c.getEnrolled();
            if (c.isFull()) {
                fullCourses.add(c.getName());
            }
            System.out.println(c);
        }

        System.out.println("--------------------");
        System.out.println("總課程數：" + courses.size());
        System.out.println("總選課人次：" + totalEnrolled);
        System.out.println("已額滿課程：" + (fullCourses.isEmpty() ? "無" : fullCourses));
    }
}