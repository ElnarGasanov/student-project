package lern.javacourse.studentOrder.validator;

import lern.javacourse.studentOrder.domain.wedding.AnswerWedding;
import lern.javacourse.studentOrder.domain.StudentOrder;

public class WeddingValidator {
    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("wedding is running");

        return new AnswerWedding();
    }
}
