package lern.javacourse.studentOrder.validator.register;

import lern.javacourse.studentOrder.domain.Child;
import lern.javacourse.studentOrder.domain.register.CityRegisterResponse;
import lern.javacourse.studentOrder.domain.Person;
import lern.javacourse.studentOrder.domain.Adult;
import lern.javacourse.studentOrder.exception.CityRegisterException;
import lern.javacourse.studentOrder.exception.TransportException;


/*
FakeCityRegisterChecker implements(реализует) CityRegisterChecker(интерфейс) и по этому у него обязательно должен быть метод checkPerson
 */

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public static final String GOOD_1 = "1000";
    public static final String GOOD_2 = "2000";
    public static final String BAD_1 = "1001";
    public static final String BAD_2 = "2001";
    public static final String ERROR_1 = "1002";
    public static final String ERROR_2 = "2002";
    public static final String ERROR_T_1 = "1003";
    public static final String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {

        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult) {
            //person instanceof Adult - является ли PERSON объектом типа ADULT(true)
            Adult t = (Adult) person; //приведение к типу данных
            String ps = t.getPassportSeria();
            if (ps.equals(GOOD_1) || ps.equals(GOOD_2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }
            if (ps.equals(BAD_1) || ps.equals(BAD_2)) {
                res.setExisting(false);
            }
            if (ps.equals(ERROR_1) || ps.equals(ERROR_2)) {
                CityRegisterException ex =
                        new CityRegisterException("400","GRN ERROR" + ps);
                throw ex;
            }
            if (ps.equals(ERROR_T_1) || ps.equals(ERROR_T_2)) {
                TransportException ex =
                        new TransportException("Transport ERROR" + ps);
                throw ex;
            }
        }
        if (person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);

        return res;
    }
}
