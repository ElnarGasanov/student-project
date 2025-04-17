package lern.javacourse.studentOrder;

import lern.javacourse.studentOrder.domain.Address;
import lern.javacourse.studentOrder.domain.Child;
import lern.javacourse.studentOrder.domain.Adult;
import lern.javacourse.studentOrder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
        buildStudentOrder(10);

        StudentOrder so = new StudentOrder();
        long ans = saveStudentOrder(so); //внутри вызова метода нужно поместить ту переменную которую передали на вход - so

        /*
        4 типа ЦЕЛЫХ ЧИСЕЛ:
        - первый это byte число от -128 до +127
        - второе это short(2byte)
        - третье это int(4byte)
        - четвертое это long
         */

        /*
        ВЕЩЕСТВЕННЫЕ ЧИСЛА
        float
        double
         */

        /*
        СИМВОЛЫ
        char
         */

        /*
        ЛОГИЧЕСКАЯ ПЕРЕМЕННАЯ
        boolean = true/false
         */


        buildStudentOrder(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
         /*
        В методе есть 3 составных части:
        ИМЯ МЕТОДА - saveStudentOrder
        ВОЗВРАЩАЕМОЕ ЗНАЧЕНИЕ - long, но может быть и объект
        ВХОДНЫЕ ПАРАМЕТРЫ - (StudentOrder studentOrder),
            на вход метода передача данных (StudentOrder studentOrder)
                тип данных которые принимаем - StudentOrder
                и работать с данными через имя - studentOrder
         */

        return 0;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.getMarriageCertificateId("" + (1234560000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        so.setMarriageOffice("Отделение ЗАГС");

        Address address = new Address("195000", "Заневский пр.", "12", "", "142");

        //МУЖ
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1998, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел Милиции №" + id);
        husband.setStudentId("" + (1000000 + id));
        husband.setAddress(address);

        //ЖЕНА
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел Милиции №" + id);
        wife.setStudentId("" + (2000000 + id));
        wife.setAddress(address);

        //РЕБЕНОК1
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        child1.setIssueDepartment("Отдел ЗАГС №" + id);
        child1.setAddress(address);
        //РЕБЕНОК2
        Child child2 = new Child("Петров", "Олег", "Викторович", LocalDate.of(2019, 8, 23));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2019, 9, 19));
        child2.setIssueDepartment("Отдел ЗАГС №" + id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }

    static void printStudentOrder(StudentOrder stOr) {
        System.out.println(stOr.getStudentOrderId());
    }
}
