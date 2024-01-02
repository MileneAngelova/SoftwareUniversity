package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.models.etities.Author;
import bg.softuni.bookshopsystem.models.etities.Book;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import bg.softuni.bookshopsystem.services.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedAuthors();
//        this.seedService.seedCategories();
//        this.seedService.seedBooks();
//        this.seedService.seedAll();

//        printAllBooksAfter2000();
//        printAuthorsByBooksBefore1990();
//        printAuthorsByBooksCount();
        printAllBooksByAuthor();

    }

    private void printAllBooksByAuthor() {
        Author author = authorRepository.findAuthorByFirstNameAndLastName("Christina", "Jordan");
          List<Book> booksByGeorgePowell = bookRepository.getBooksByAuthorOrderByReleaseDateDescTitleAsc(author);

        if (!booksByGeorgePowell.isEmpty()) {
            booksByGeorgePowell.stream().forEach(b -> System.out.printf("%s %ty-%tm-%td %d%n", b.getTitle(), b.getReleaseDate(), b.getReleaseDate(), b.getReleaseDate(), b.getCopies()));
        }
    }

    private void printAuthorsByBooksCount() {
        List<Author> authorsByBooksCount = authorRepository.findAll();
        authorsByBooksCount.stream().sorted((a, b) -> b.getBooks().size() - a.getBooks().size())
                .forEach(a -> System.out.printf(" %s %s - %d%n", a.getFirstName(), a.getLastName(), a.getBooks().size()));
    }

    private void printAuthorsByBooksBefore1990() {
        LocalDate before1990 = LocalDate.of(1990, 01, 01);
        List<Author> booksBefore1990 = authorRepository.findDistinctAuthorByBooksReleaseDateBefore(before1990);
        if (!booksBefore1990.isEmpty()) {
            booksBefore1990.forEach(a -> System.out.println(a.getFirstName() + a.getLastName()));
        }
    }

    private void printAllBooksAfter2000() {
        LocalDate after2000 = LocalDate.of(2000, 12, 31);
        List<Book> booksAfter2000 = bookRepository.findAllByReleaseDateAfter(after2000);
        if (!booksAfter2000.isEmpty()) {
            booksAfter2000.forEach(b -> System.out.println(b.getTitle()));
//            int count = bookRepository.countAllByReleaseDateAfter(after2000);
            System.out.println(booksAfter2000.size());
        }

    }
}
