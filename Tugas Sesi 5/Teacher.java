public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {};

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                return false;
            }
        }

        String[] newCourses = new String[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[numCourses] = course;
        courses = newCourses;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
    
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        String[] newCourses = new String[numCourses - 1];
        for (int i = 0, j = 0; i < numCourses; i++) {
            if (i != index) {
                newCourses[j++] = courses[i];
            }
        }
        courses = newCourses;
        numCourses--;
        return true;
    }

    public void printCourses() {
        if (numCourses == 0) {
            System.out.println("Dosen ini belum mengampu mata kuliah apapun.");
            return;
        }
        System.out.println("Mata kuliah yang diampu oleh " + getName() + ":");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("  " + (i + 1) + ". " + courses[i]);
        }
    }

    @Override
    public String toString() {
        return "Teacher: " + getName() + "(" + getAddress() + ")";
    }
}