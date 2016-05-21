package java5.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Veterinarian extends Thread{

    protected final BlockingQueue<Appointment<Pet>> appointments;
    protected final int restTime;
    private boolean shutdown = false;

    public Veterinarian(BlockingQueue<Appointment<Pet>> appointments, int pause) {
        this.appointments = appointments;
        this.restTime = pause;
    }

    public synchronized void shutdown(){
        this.shutdown = true;
    }


    @Override
    public void run() {
        while (!shutdown){
            seePatient();
            try {
                Thread.sleep(this.restTime);
            } catch (InterruptedException e) {
                this.shutdown = true;
            }
        }
    }

    private void seePatient() {
        try {
            Appointment<Pet> appt = appointments.take();
            Pet patient = appt.getPatient();
            patient.examine();
        } catch (InterruptedException e) {
            this.shutdown = true;
        }
    }

    public void setPatientAppointment(Appointment<Pet> appointment) {
        try {
            appointments.put(appointment);
            System.out.printf("Appointment has been set [%s]\n", appointment.getPatient().name);
        } catch (InterruptedException e) {
            this.shutdown = true;
        }
    }
}
