package Aplicatie2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StorageIon implements StorageInterface {
    private int dimensionStorage;
    private Queue<Integer> depozit = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition depozitFull = lock.newCondition();
    private final Condition depozitEmpty = lock.newCondition();

    public StorageIon(int dimension) {
        dimensionStorage = dimension;
    }

    @Override
    public void put(int[] var1, String threadName) {
        lock.lock();
        try {
            while (depozit.size() == dimensionStorage) {
                depozitFull.await();
            }
            if (Aplicatie2.Producer.planOfWork())
                return;

            depozit.add(var1[0]);

            int contor = Producer.incrementStartProduction(var1.length);
            System.out.println("Au fost produse " + contor + " elemente");

            System.out.println(threadName + " a adaugat in buffer: " + var1[0]);
            depozitEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int[] get(String threadName) {
        lock.lock();
        try {
            while (depozit.size() == 0) {
                depozitEmpty.await();
            }
            int[] elemente = new int[0];
            if (Aplicatie2.Consumer.getElementsConsumed() == 34) {
                elemente = new int[1];
                elemente[0] = depozit.poll();
                System.out.println(threadName + " a consumat din depozit: " + elemente[0]);
            } else {
                elemente = new int[1];
                elemente[0] = depozit.poll();

                System.out.println(threadName + " a consumat din depozit: " + elemente[0]);
            }
            int contorProduseConsumate = Consumer.incElementsConsumed(elemente.length);
            System.out.println("Au fost consumate " + contorProduseConsumate + " elemente.");
            depozitFull.signalAll();
            return elemente;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
