package lern.javacourse.studentOrder.validator;

import lern.javacourse.studentOrder.domain.student.AnswerStudent;
import lern.javacourse.studentOrder.domain.StudentOrder;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student`s check is running");

        return new AnswerStudent();
    }
}
