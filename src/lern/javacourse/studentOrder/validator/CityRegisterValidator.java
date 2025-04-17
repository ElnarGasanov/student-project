package lern.javacourse.studentOrder.validator;

import lern.javacourse.studentOrder.domain.Child;
import lern.javacourse.studentOrder.domain.Person;
import lern.javacourse.studentOrder.domain.register.AnswerCityRegister;
import lern.javacourse.studentOrder.domain.register.AnswerCityRegisterItem;
import lern.javacourse.studentOrder.domain.register.CityRegisterResponse;
import lern.javacourse.studentOrder.domain.StudentOrder;
import lern.javacourse.studentOrder.exception.CityRegisterException;
import lern.javacourse.studentOrder.exception.TransportException;
import lern.javacourse.studentOrder.validator.register.CityRegisterChecker;
import lern.javacourse.studentOrder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {
    public String hostName;
    public String login;
    public String password;
    protected int port;

    private CityRegisterChecker personChecker; //CityRegisterChecker - интерфейс, а его переиспользование это полиморфизм


    /*
    В конструкторе присвоили personChecker значение(создали объект)
     */
    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {

        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

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

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {

        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError("NO_GRN", ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError("NO_GRN", ex.getMessage());
        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);
        return ans;
    }
}