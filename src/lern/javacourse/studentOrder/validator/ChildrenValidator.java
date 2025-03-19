package lern.javacourse.studentOrder.validator;

import lern.javacourse.studentOrder.domain.children.AnswerChildren;
import lern.javacourse.studentOrder.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
