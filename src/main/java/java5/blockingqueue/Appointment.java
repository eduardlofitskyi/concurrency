package java5.blockingqueue;

public class Appointment<T> {
    private final T toBeSeen;

    public Appointment(T toBeSeen) {
        this.toBeSeen = toBeSeen;
    }

    public T getPatient() {
        return toBeSeen;
    }
}
