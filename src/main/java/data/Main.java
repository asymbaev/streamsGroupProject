package data;

import challenges.CarOps;
import challenges.StudentOps;
import domain.Car;
import domain.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static challenges.CarOps.*;
import static data.FetchData.getCarList;
import static data.FetchData.getStudentList;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Car> cars = getCarList();
        List<Student> students = getStudentList();
        System.out.println("Question1: +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        getCarList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++");
        getStudentList().stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Question2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Student> sortedStudents = StudentOps.sortStudentsByAge(students);

        if (sortedStudents != null) {
            sortedStudents.forEach(student -> {
                System.out.println(student.getFirst_name() + ": " + student.getAge());
            });
        }

//        System.out.println("Question21 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        List<Car> SpecificMake = carWithSpecificMake(cars);
//        System.out.println(SpecificMake);

//




        System.out.println("Question31 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Map<String, Long> carCountsByMake = CarOps.countCarsByMake(cars);

        carCountsByMake.forEach((make, count) -> {
            System.out.println(make + ": " + count);
        });

        System.out.println("Question32 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        double avgPrice = averagePriceOfCars(cars);
        System.out.println("The average of car price is " + avgPrice);


        System.out.println("Question33 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        double sumOfPrice = sumOfPriceOfCars(cars);
        System.out.println("The sum of price of cars is " + sumOfPrice);

        System.out.println("Question34 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        boolean isBlueCar = carsWithBlueColor(cars);
        System.out.println("is there a blue car ? " + isBlueCar);

        System.out.println("Question35 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        boolean isExpensive = isAllCarExpensive(cars);
        System.out.println("is there very expensive car ? "+ isExpensive);

        System.out.println("Question36 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        boolean isItMatch = isThisConditionMatch(cars);
        System.out.println("is Sonata a match ? " + isItMatch);

        System.out.println("Question37 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Car> skippedCar = skippingTheFirst5Cars(cars, 5);
        System.out.println(skippedCar);

        System.out.println("Question38 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Car> limitCar = limitingTheFirstNCars(cars, 10);
        System.out.println(limitCar);

        System.out.println("Question39 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<String> distinct = listOfDistinctCarColor(cars);
        System.out.println("The distinct car colors are " + distinct);

        System.out.println("Question40 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<String> concatenate = concatenatingMakeAndModel(cars);
        System.out.println(concatenate);

        System.out.println("Question41 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Optional<Car> findFirst = findTheFirstCar(cars);
        System.out.println(findFirst);

        System.out.println("Question42 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Optional<Car> findAny = findAnyCar(cars);
        System.out.println(findAny);

        System.out.println("Question43 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Car> removeDuplicates = removeDuplicateCars(cars);
        System.out.println(removeDuplicates);
        System.out.println(removeDuplicates.size());


        System.out.println("Question44 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Map<Boolean, List<Car>> price = highPriceAndLowPrice(cars, 50000);
        System.out.println(price);
        System.out.println(price.size());

        System.out.println("Question45 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Map<String, Double> calculatePrice = calculateTotalPriceByMake(cars);
        System.out.println(calculatePrice);

        System.out.println("Question46 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String joinCarName = joinCarsByNames(cars);
        System.out.println(joinCarName);

        System.out.println("Question47 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        printCarDetails(cars);

        System.out.println("Question48 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Map<String, Double> averagePrice = averagePriceOfCarsByMake(cars);
        System.out.println(averagePrice);

        System.out.println("Question49 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        String concat = concatenateAllCarDetails(cars);
        System.out.println(concat);

        List<Car> theNewestCar = newestCarFromTheList(cars);
        System.out.println("The newest car are: " + theNewestCar);

        System.out.println("++++++++++++++++++++++++++++++++++++++=");
        //3

        StudentOps.sortByDob(students)
                        .stream()
                                .limit(50)
                                        .forEach(System.out::println);
        System.out.println(StudentOps.averageAge(students));



        //4
        StudentOps.printNames(students)
                .stream()
                .limit(50)
                .forEach(System.out::println);
        System.out.println(StudentOps.printNames(students));


        //5
        StudentOps.groupByGender(students);
        System.out.println(StudentOps.groupByGender(students));


        //6
        System.out.println(StudentOps.maxAge(students));

        //7
        System.out.println(StudentOps.toMap(students));

        // 8
        System.out.println(StudentOps.emails(students));

        // 9
        System.out.println(StudentOps.adult(students));

        //10
        StudentOps.numGender(students)
                .forEach((x,y) -> System.out.println(x+" " + y.stream().count()));

        // 11
        System.out.println(StudentOps.youngFem(students));

        // 12
        System.out.println(StudentOps.joinName(students));

        //13
        System.out.println(StudentOps.sumAge(students));

        //14
        System.out.println(StudentOps.adultStudent(students));

        // 15
        System.out.println(StudentOps.oldStudent(students));

        // 16
        System.out.println(StudentOps.upperCase(students));

        // 17
        System.out.println(StudentOps.findId(students, 50));
        // 18
        StudentOps.countSt(students)
                .forEach((age,count) -> System.out.println(age + " " + count));
        // 19
        StudentOps.studentAge(students)
                .forEach((age, studentList) -> System.out.println(age + " " + studentList));
        // 20
        System.out.println(StudentOps.deviationAge(students));

        //22
        System.out.println(carWithSpecificYear(cars));
        // 23
        System.out.println(carWithPriceRange(cars, 155431, 200245));

        // 24
        System.out.println(carModelNames(cars));

        //25
        System.out.println(carUpperMakes(cars));

        // 26
        System.out.println(carSortedYear(cars));


    }

}
