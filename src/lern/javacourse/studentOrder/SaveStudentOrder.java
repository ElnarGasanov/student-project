package lern.javacourse.studentOrder;

import lern.javacourse.studentOrder.dao.StudentOrderDao;
import lern.javacourse.studentOrder.dao.StudentOrderDaoImpl;
import lern.javacourse.studentOrder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
//        List<Street> d = new DictionaryDaoImpl().findStreets("Садовая");
//        List<PassportOffice> d1 = new DictionaryDaoImpl().findPassportOffices("010010000000");
//        List<RegisterOffice> d2 = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        //-----
//        List<CountryArea> co = new DictionaryDaoImpl().findAreas("");
//        List<CountryArea> co1 = new DictionaryDaoImpl().findAreas("020000000000");
//        List<CountryArea> co2 = new DictionaryDaoImpl().findAreas("020010000000");
//        List<CountryArea> co3 = new DictionaryDaoImpl().findAreas("020010010000");
//
//        for(Street s:d) {
//            System.out.print(s.getStreetCode() + " ");
//            System.out.println(s.getStreetName());
//        }
//
//        for(PassportOffice po:d1) {
//            System.out.print(po.getPassportOfficeId() + ": ");
//            System.out.print(po.getPassportOfficeAreaId() + ": ");
//            System.out.println(po.getPassportOfficeName());
//        }
//
//        for(RegisterOffice ro:d2) {
//            System.out.print(ro.getRegisterOfficeId() + ": ");
//            System.out.print(ro.getRegisterOfficeAreaId() + ": ");
//            System.out.println(ro.getRegisterOfficeName());
//        }
//
//        for(CountryArea ca:co) {
//            System.out.print(ca.getAreaId() + ": ");
//            System.out.println(ca.getAreaName());
//        }
//
//        for(CountryArea ca:co1) {
//            System.out.print(ca.getAreaId() + ": ");
//            System.out.println(ca.getAreaName());
//        }
//
//        for(CountryArea ca:co2) {
//            System.out.print(ca.getAreaId() + ": ");
//            System.out.println(ca.getAreaName());
//        }
//
//        for(CountryArea ca:co3) {
//            System.out.print(ca.getAreaId() + ": ");
//            System.out.println(ca.getAreaName());
//        }
//        StudentOrder s = buildStudentOrder(0);
        StudentOrderDao dao = new StudentOrderDaoImpl();
//        Long id = dao.saveStudentOrder(s);
//        System.out.println(id);

        List<StudentOrder> soList = dao.getStudentOrders();
        for(StudentOrder so : soList){
            System.out.println(so.getStudentOrderId());
        }
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        return 0;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(1L, "FirstStreet");
        Address address = new Address("195000", street, "12", "", "142");

        //МУЖ
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1998, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (1000000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(1L, ""));

        //ЖЕНА
        Adult wife = new Adult("Педрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (2000000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));;

        //РЕБЕНОК1
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro1 = new RegisterOffice(2L, "", "");
        child1.setIssueDepartment(ro1);
        child1.setAddress(address);

        //РЕБЕНОК2
        Child child2 = new Child("Петров", "Олег", "Викторович", LocalDate.of(2019, 8, 23));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2019, 9, 19));
        RegisterOffice ro2 = new RegisterOffice(3L, "", "");
        child2.setIssueDepartment(ro2);
        child2.setAddress(address);

        so.setMarriageCertificateId("22032" + id);
        so.setMarriageDate(LocalDate.of(2020, 8, 10));

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}
