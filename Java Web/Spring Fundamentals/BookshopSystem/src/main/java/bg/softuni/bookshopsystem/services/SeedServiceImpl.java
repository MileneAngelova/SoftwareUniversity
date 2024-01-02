package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.models.enums.AgeRestriction;
import bg.softuni.bookshopsystem.models.enums.EditionType;
import bg.softuni.bookshopsystem.models.etities.Author;
import bg.softuni.bookshopsystem.models.etities.Book;
import bg.softuni.bookshopsystem.models.etities.Category;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private static final String RESOURCE_PATH = "src/main/resources/files";
    private static final String AUTHORS_FILE_PATH = RESOURCE_PATH + "/authors.txt";
    private static final String CATEGORY_FILE_PATH = RESOURCE_PATH + "/categories.txt";
    private static final String BOOK_FILE_PATH = RESOURCE_PATH + "/books.txt";

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final BookRepository bookRepository;

    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository, AuthorService authorService, CategoryRepository categoryRepository, CategoryService categoryService, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream().filter(a -> !a.isBlank())
                .map(names -> names.split("\\s+"))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORY_FILE_PATH))
                .stream().filter(c -> !c.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOK_FILE_PATH))
                .stream().filter(b -> !b.isBlank())
//                .map(line -> line.split("\\s+"))
                .map(this::getBook)
                .forEach(bookRepository::save);
    }

    private Book getBook(String data) {
        String[] info = data.split(" ");
        int editionTypeIndex = Integer.parseInt(info[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];
        LocalDate publishDate = LocalDate.parse(info[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(info[2]);
        BigDecimal price = new BigDecimal(info[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(info[4])];
        String title = Arrays.stream(info).skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
       Set<Category> categories = categoryService.getRandomCategories();

        return new Book(title, editionType, price, copies, publishDate, ageRestriction, author, categories);
    }
}
