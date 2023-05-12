package Aplicatie3;

public class Lab4 {
    public static void main (String[] args) {
        final int writers = 7;
        final int readers = 12;
        final int books = 9;

        Library library = new Library (writers, readers, books);
        library.start();
    }
}
