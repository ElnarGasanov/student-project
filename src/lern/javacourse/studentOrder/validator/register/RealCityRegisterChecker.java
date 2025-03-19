package lern.javacourse.studentOrder.validator.register;

import lern.javacourse.studentOrder.domain.register.CityRegisterCheckerResponse;
import lern.javacourse.studentOrder.domain.Person;
import lern.javacourse.studentOrder.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker {

    @Override
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException {
        return null;
    }
}
