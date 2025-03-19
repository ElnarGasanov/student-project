package lern.javacourse.studentOrder.validator;

import lern.javacourse.studentOrder.domain.Child;
import lern.javacourse.studentOrder.domain.register.AnswerCityRegister;
import lern.javacourse.studentOrder.domain.register.CityRegisterCheckerResponse;
import lern.javacourse.studentOrder.domain.StudentOrder;
import lern.javacourse.studentOrder.exception.CityRegisterException;
import lern.javacourse.studentOrder.validator.register.CityRegisterChecker;
import lern.javacourse.studentOrder.validator.register.FakeCityRegisterChecker;

import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {
    public String hostName;
    public String login;
    public String password;
    protected int port;

    private CityRegisterChecker personChecker; //CityRegisterChecker - интерфейс, а его переиспользование это полиморфизм


    /*
    В конструкторе присвоили personChecker значение(создали объект)
     */
    public CityRegisterValidator(){
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());

            List<Child> children = so.getChildren();

            /*
            Проходимся по списку с помощью цикла for:

            for (int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChildren().get(i));
            }
             */

            /*
            Проходимся по списку с помощью Iterator:

            for (Iterator<Child> it = children.iterator(); it.hasNext(); ) {
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
             */

            /*
            Проходимся по списку с помощью цикла for each:

            for(Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
             */

            for(Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }


        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}