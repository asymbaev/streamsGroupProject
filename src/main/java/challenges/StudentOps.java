package challenges;

import domain.Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentOps {
    //  1. Filter Students by Gender: Write a method to filter a list of students by their gender.

    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }

    //2. Sort Students by Age: Sort the list of students by their age (based on date of birth).
    public static List<Student> sortStudentsByAge(List<Student> students) {
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return  students.stream()
                    .sorted(Comparator.comparing(Student::getAge))
                    .toList();
        }
    //3
    public static List<Student> sortByDob (List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparing(Student::getDob))
                .toList();

    }
    //3.Calculate Average Age: Calculate the average age of all students.
    public static double averageAge(List<Student> students) {
       return students
                .stream()
                .map(Student::getDob)
                .mapToDouble(LocalDate::getYear)
                .average()
                .orElse(0.0);
    }
    //4.Print Student Names: Print the full names of all students.
    public static List<String> printNames (List<Student> students) {
        return students
                .stream()
                .map(student -> student.getFirst_name() + " " + student.getLast_name())
                .toList();



    }
    //5 Group Students by Gender: Group the students by gender.

    public static Map<String, List<Student>> groupByGender(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    //6 Find Maximum Age: Find the maximum age among all students.

    public static int maxAge(List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getAge)
                .max()
                .orElse(0);
    }

    // 7 Transform to Map: Convert the list
    // of students into a map where the key
    // is the student ID and the value is the student object.

    public static Map<Integer, Student> toMap (List<Student> students) {
        return students
                .stream()
                .collect(Collectors.toMap(Student::getId,s -> s));
    }

    // 8 Get Student Emails: Retrieve a list of student emails.
    public static List<String> emails (List<Student> students) {
        return students
                .stream()
                .map(Student::getEmail)
                .toList();
    }

    // 9 Check if Any Student is Adult: Check if any student is an adult (age 18 or older).
    public static List<Student> adult (List<Student> students) {
        return students
                .stream()
                .filter(s -> s.getAge() >= 18)
                .toList();

    }

    // 10 Count Students by Gender: Count the number of students for each gender.
    public static Map<String, List<Student>> numGender(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

    }

    // 11 Find Youngest Female Student: Find the youngest female student.
    public static Student youngFem (List<Student> students) {
        return students
                .stream()
                .filter(x -> x.getGender().equalsIgnoreCase("female"))
                .min(Comparator.comparing(Student::getAge))
                .orElse(null);
    }
    // 12 Join Student Names: Join the first names of all students into a single string.
    public static String joinName (List<Student> students) {
        StringBuilder nameString = new StringBuilder();
        students.stream().forEach(x -> nameString.append(x.getFirst_name()).append(" "));
        return nameString.toString();

    }

    // 13 Calculate Age Sum: Calculate the sum of ages for all students.
    public static int sumAge (List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getAge).sum();


    }
    // 14 Check if All Students are Adults: Check if all students are adults (age 18 or older).





}
