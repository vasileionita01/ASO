package Aplicatie1;

import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

            System.out.println("Alegeti varianta de realizare:");
            System.out.println("1. Ionita");
            System.out.println("2. Ceban");
            System.out.println("3. Fortuna");

            System.out.print("Alegeti un utilizator: ");

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    Depozit2 depozitVasile = new Depozit2(7);

                    Producer producer1 = new Producer(depozitVasile, "Producer-1", 2);
                    Producer producer2 = new Producer(depozitVasile, "Producer-2", 2);

                    Consumer consumer1 = new Consumer(depozitVasile, "Consumer-1");
                    Consumer consumer2 = new Consumer(depozitVasile, "Consumer-2");
                    Consumer consumer3 = new Consumer(depozitVasile, "Consumer-3");
                    Consumer consumer4 = new Consumer(depozitVasile, "Consumer-4");

                    producer1.start();
                    producer2.start();

                    consumer1.start();
                    consumer2.start();
                    consumer3.start();
                    consumer4.start();

                    break;
                case 2:
                    // to do
                    break;
                case 3:
                    // to do
                    break;
                default:
                    System.out.println("Asa numar de optiune nu exista");
            }
     }
}


