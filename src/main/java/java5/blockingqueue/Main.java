package java5.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    /**
     *Shows that queue will block if try to put when full till has free space
     */
//    public static void main(String[] args) {
//        BlockingQueue<Appointment<Pet>> queue = new LinkedBlockingDeque<>(3);
//        Veterinarian veterinarian = new Veterinarian(queue, 5_000);
//        veterinarian.setPatientAppointment(new Appointment<Pet>(new Cat("Liza")));
//        veterinarian.setPatientAppointment(new Appointment<Pet>(new Dog("Kolt")));
//        veterinarian.setPatientAppointment(new Appointment<Pet>(new Dog("Rex")));
//        veterinarian.setPatientAppointment(new Appointment<Pet>(new Cat("Tiffany")));
//    }

    /**
     * Shows that queue will block if try to get when empty till queue won't empty
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Appointment<Pet>> queue = new LinkedBlockingDeque<>(3);
        Veterinarian veterinarian = new Veterinarian(queue, 5_000);
        Thread.sleep(10_000);
        veterinarian.setPatientAppointment(new Appointment<Pet>(new Dog("Rex")));
        Thread.sleep(500);
        veterinarian.setPatientAppointment(new Appointment<Pet>(new Cat("Tiffany")));
        veterinarian.start();
    }
}
