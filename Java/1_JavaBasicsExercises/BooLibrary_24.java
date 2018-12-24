package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BooLibrary_24 {

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
        private LocalDate releaseDate;
        private String isbn;
        private Double price;

        public Book(String title, String author, String publisher, LocalDate releaseDate, String isbn, Double price) {
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

        public LocalDate getReleaseDate() {
            return releaseDate;
        }

        private void setReleaseDate(LocalDate releaseDate) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

//        List<Library> libraries = new ArrayList<>();
        Library library = new Library("book1");

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

            Book book = new Book(info[0], info[1], info[2], LocalDate.parse(info[3], formatter), info[4], Double.parseDouble(info[5]));
            library.addBooks(book);
        }

        HashMap<String, Double> result = new HashMap<>();

        library.getBooks().stream().forEach(e -> {
            if (!result.containsKey(e.getAuthor())) {
                result.put(e.getAuthor(), e.getPrice());
            } else {
                result.put(e.getAuthor(), result.get(e.getAuthor()) + e.getPrice());
            }
        });

        result.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))

                .forEach(e -> {
                    System.out.printf("%s -> %.2f\n", e.getKey(), e.getValue());
                });

    }
}
