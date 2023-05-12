package Aplicatie2;

public interface StorageInterface{
    void put(int[] var1, String threadName);
    int[] get(String threadName);

}
