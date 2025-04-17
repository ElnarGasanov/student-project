package lern.javacourse.studentOrder.domain.register;



public class CityRegisterCheckerResponse {
    /*
    - class CityRegisterCheckerResponse проверка ответа для CityRegisterValidator
    - private boolean existing = существует в реестре этот человек или нет
    - private Boolean temporal = т.к Boolean это объект он подчиняется правилам объектов и его можно проинициализировать как null
    -
     */

    private boolean existing;
    private Boolean temporal;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterCheckerResponse{" +
                "existing=" + existing +
                ", temporal=" + temporal +
                '}';
    }
}
