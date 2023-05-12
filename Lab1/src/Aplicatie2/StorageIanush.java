package Aplicatie2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class StorageIanush implements StorageInterface {

    private int dimensionStorage;
    private Queue<Integer> depozit = new LinkedList<>();
    private Semaphore depozitFull = new Semaphore(0);
    private Semaphore depozitEmpty;

    public StorageIanush(int dimension){
        dimensionStorage = dimension;
        depozitEmpty = new Semaphore(dimensionStorage);
    }

    @Override
    public void put(int[] var1, String threadName) {
        try {
            depozitEmpty.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(Aplicatie2.Producer.planOfWork())
            return;

        depozit.add(var1[0]);

        int contor = Producer.incrementStartProduction(var1.length);
        System.out.println("Au fost produse " + contor + " elemente");

        System.out.println(threadName + " a adaugat in buffer: " + var1[0]);
        depozitFull.release();
    }


    @Override
    public int[] get(String threadName) {
        try {
            depozitFull.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int[] elemente = new int[0];

        synchronized (depozit) {
            if (!depozit.isEmpty()) {
                Integer val = depozit.poll();
                if (val != null) {
                    elemente = new int[1];
                    elemente[0] = val.intValue();
                    System.out.println(threadName + " a consumat din depozit: " + elemente[0]);
                } else {
                    System.out.println("Depozitul este gol");
                }
            } else {
                System.out.println("Depozitul este gol");
            }
        }

        int contorProduseConsumate = Consumer.incElementsConsumed(elemente.length);
        System.out.println("Au fost consumate " + contorProduseConsumate + " elemente.");
        depozitEmpty.release(elemente.length);
        return elemente;
    }
}

