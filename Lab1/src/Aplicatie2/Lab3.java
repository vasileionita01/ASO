package Aplicatie2;

import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {

        System.out.println("Alegeti varianta de realizare:");
        System.out.println("1. Fortuna");
        System.out.println("2. Ceban");
        System.out.println("3. Ionita");

        System.out.print("Alegeti un utilizator: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                StorageIanush storageIanush = new StorageIanush(9);

                Producer producer1 = new Producer(storageIanush, "Producer #1", 1);
                Producer producer2 = new Producer(storageIanush, "Producer #2", 1);
                Producer producer3 = new Producer(storageIanush, "Producer #3", 1);
                Producer producer4 = new Producer(storageIanush, "Producer #4", 1);

                Consumer consumer1 = new Consumer(storageIanush, "Consumer #1");
                Consumer consumer2 = new Consumer(storageIanush, "Consumer #2");
                Consumer consumer3= new Consumer(storageIanush, "Consumer #3");


                producer1.start();
                producer2.start();
                producer3.start();
                producer4.start();

                consumer1.start();
                consumer2.start();
                consumer3.start();
                break;
            case 2:
                StorageIon storageIon = new StorageIon(9);

                Producer producer5 = new Producer(storageIon, "Producer #5", 1);
                Producer producer6 = new Producer(storageIon, "Producer #6", 1);
                Producer producer7 = new Producer(storageIon, "Producer #7", 1);
                Producer producer8 = new Producer(storageIon, "Producer #8", 1);

                Consumer consumer4 = new Consumer(storageIon, "Consumer #4");
                Consumer consumer5 = new Consumer(storageIon, "Consumer #5");
                Consumer consumer6= new Consumer(storageIon, "Consumer #6");


                producer5.start();
                producer6.start();
                producer7.start();
                producer8.start();

                consumer4.start();
                consumer5.start();
                consumer6.start();
                break;
            case 3:
                StorageVasile storageVasile = new StorageVasile(9);

                Producer producer9 = new Producer(storageVasile, "Producer #9", 1);
                Producer producer10 = new Producer(storageVasile, "Producer #10", 1);
                Producer producer11 = new Producer(storageVasile, "Producer #11", 1);
                Producer producer12 = new Producer(storageVasile, "Producer #12", 1);

                Consumer consumer7 = new Consumer(storageVasile, "Consumer #7");
                Consumer consumer8 = new Consumer(storageVasile, "Consumer #8");
                Consumer consumer9= new Consumer(storageVasile, "Consumer #9");


                producer9.start();
                producer10.start();
                producer11.start();
                producer12.start();

                consumer7.start();
                consumer8.start();
                consumer9.start();
                break;
            default:
                System.out.println("Asa numar de optiune nu exista");
        }
    }
}
