package lern.javacourse.studentOrder.validator.register;

import lern.javacourse.studentOrder.domain.register.CityRegisterResponse;
import lern.javacourse.studentOrder.domain.Person;
import lern.javacourse.studentOrder.exception.CityRegisterException;
import lern.javacourse.studentOrder.exception.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker {

    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        return null;
    }
}
