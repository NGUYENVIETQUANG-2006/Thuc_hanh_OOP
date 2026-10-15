package B10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    private String id, name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {return this.id;}
    public String getName() {return this.name;}

    public abstract String getInfo();
}

class Book extends MediaItem {
    private String Author;
    private int numberOfPages;

    public Book(String id, String name, String Author, int numberOfPages) {
        super(id, name);
        this.Author = Author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {return this.Author;}
    public int getNumberOfPages() {return this.numberOfPages;}

    @Override
    public String getInfo() {
        return this.getName() + " - " + this.getAuthor() + " - " + this.getNumberOfPages();
    }
}

class DVD extends MediaItem {
    private String Director;
    private int Length;

    public DVD(String id, String name, String Director, int Length) {
        super(id, name);
        this.Director = Director;
        this.Length = Length;
    }

    public String getDirector() {return this.Director;}
    public int getLength() {return this.Length;}

    @Override
    public String getInfo() {
        return this.getName() + " - " + this.getDirector() + " - " + this.getLength();
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items;

    public LibrarySection() {
        this.items = new ArrayList<>();
    }

    public void addDocument(T item) {
        items.add(item);
    }

    public void removeDocument(T item) {
        items.remove(item);
    }

    public void showInventory() {
        for(T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> DVDSection = new LibrarySection<>();

        for(int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            String name = scanner.next();
            if (type.equalsIgnoreCase("B")) {
                String author = scanner.next();
                int pages = scanner.nextInt();
                bookSection.addDocument(new Book(id, name, author, pages));
            }
            if (type.equalsIgnoreCase("D")) {
                String director = scanner.next();
                int length = scanner.nextInt();
                DVDSection.addDocument(new DVD(id, name, director, length));
            }
        }

        System.out.println("Khu vực Sách:");
        bookSection.showInventory();
        System.out.println();
        System.out.println("Khu vực DVD:");
        DVDSection.showInventory();

        scanner.close();
    }
}
