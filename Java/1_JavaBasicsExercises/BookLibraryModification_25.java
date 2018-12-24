package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookLibraryModification_25 {

    static class Library {
        private String name;
        private List<Book> books;

        public Library(String name) {
            this.setName(name);
            this.books = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public List<Book> getBooks() {
            return Collections.unmodifiableList(this.books);
        }

        public void addBooks(Book book) {
            this.books.add(book);
        }


    }

    static class Book {
        private String title;
        private String author;
        private String publisher;
        private Date releaseDate;
        private String isbn;
        private Double price;

        public Book(String title, String author, String publisher, Date releaseDate, String isbn, Double price) {
            this.setTitle(title);
            this.setAuthor(author);
            this.setPublisher(publisher);
            this.setReleaseDate(releaseDate);
            this.setIsbn(isbn);
            this.setPrice(price);
        }

        public String getTitle() {
            return title;
        }

        private void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        private void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        private void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public Date getReleaseDate() {
            return this.releaseDate;
        }

        private void setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getIsbn() {
            return isbn;
        }

        private void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public Double getPrice() {
            return price;
        }

        private void setPrice(Double price) {
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Library library = new Library("book1");

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            Book book = new Book(info[0], info[1], info[2], formatter.parse(info[3]), info[4], Double.parseDouble(info[5]));
            library.addBooks(book);
        }

        String searchingDate = reader.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = formatter.parse(searchingDate);

        library.getBooks().stream().filter(e -> e.getReleaseDate().after(date))
                .sorted(Comparator.comparing(Book::getTitle))
                .sorted((e1, e2) -> e1.getReleaseDate().compareTo(e2.getReleaseDate()))
                .forEach(e -> {
                    System.out.printf("%s -> %s\n", e.getTitle(), formatter.format(e.getReleaseDate()));
                });

    }
}
