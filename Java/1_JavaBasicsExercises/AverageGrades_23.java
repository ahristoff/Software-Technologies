package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AverageGrades_23 {

    static class Student {
        private String name;
        private ArrayList<Double> grades;

        public Student(String name) {
            this.setName(name);
            this.grades = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public List<Double> getGrades() {
            return Collections.unmodifiableList(this.grades);
        }

        public void addGrade(Double grade) {
            this.grades.add(grade);
        }

        public double averageGrade() {
            return this.grades.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String info = reader.readLine();

            String name = info.substring(0, info.indexOf(" "));
            String[] grades = info.substring(info.indexOf(" ")).trim().split(" ");

            Student student = new Student(name);

            for (String grade : grades) {
                student.addGrade(Double.parseDouble(grade));
            }
            students.add(student);
        }

        students.stream().filter(e -> e.averageGrade() >= 5.00)
                .sorted((e1, e2) -> Double.compare(e2.averageGrade(), e1.averageGrade()))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(e -> {
                    System.out.printf("%s -> %.2f\n", e.getName(), e.averageGrade());
                });
    }
}
