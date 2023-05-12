package Aplicatie3;

import java.util.*;
import java.util.concurrent.locks.Lock;

class Writer extends Thread {
    String name;
    ArrayList<String> bookList = new ArrayList<>(Arrays.asList("The Sacred Romance", "Crime and Punishment", "The World is Flat", "Atlas Shrugged","Born to Run", "Les Miserables", "Living with a SEAL", "Tools of Titans ", "The Bible" ));

    public final Lock writeLock = Library.writeLock;
    ArrayList<String> library = Library.library;
    ArrayList<String> writtenBooks = new ArrayList<>();
    static int count = 0;

    public Writer (String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while(library.size() < Library.books){
            try {
                writeLock.lock();
                if (library.size() < Library.books){
                    String randomBook = bookList.get(count);
                    if (!library.contains(randomBook)){
                        sleep(1000);
                        library.add(randomBook);
                        writtenBooks.add(randomBook);
                        System.out.println(name + " wrote " + randomBook);
                        count++;
                        sleep(100);
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                writeLock.unlock();
            }
            if (library.size() == Library.books){
                System.out.println(name + " book list: \n" + writtenBooks);
            }
        }

    }
}

