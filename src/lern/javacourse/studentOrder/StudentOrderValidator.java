package lern.javacourse.studentOrder;

import lern.javacourse.studentOrder.domain.*;
import lern.javacourse.studentOrder.domain.children.AnswerChildren;
import lern.javacourse.studentOrder.domain.register.AnswerCityRegister;
import lern.javacourse.studentOrder.domain.student.AnswerStudent;
import lern.javacourse.studentOrder.domain.wedding.AnswerWedding;
import lern.javacourse.studentOrder.validator.ChildrenValidator;
import lern.javacourse.studentOrder.validator.CityRegisterValidator;
import lern.javacourse.studentOrder.validator.StudentValidator;
import lern.javacourse.studentOrder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        System.out.println("1. Запускаю sov.checkAll");
        sov.checkAll();
    }

    public void checkAll() {
        List<StudentOrder> soList = readStudentOrders();

        //fori
//        for (int i = 0; i < soArray.length; i++) {
//            System.out.println();
//            checkOneOrder(soArray[i]);
//        }

        //for-each
        for (StudentOrder so : soList){
            System.out.println();
            checkOneOrder(so);
        }
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        StudentOrder so = new StudentOrder();
        return soList;
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
        AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childAnswer = checkChildren(so);
        AnswerStudent studentAnswer = checkStudent(so);
        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        System.out.println("send mail");
    }

}
