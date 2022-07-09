package softuni.books.service;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;
import softuni.books.models.dto.AuthorDTO;
import softuni.books.models.dto.BookDTO;
import softuni.books.models.entities.BookEntity;
import softuni.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BookDTO> getBookById(Long bookId) {

        return bookRepository.findById(bookId)
                .map(this::map);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private BookDTO map(BookEntity bookEntity) {

        return new BookDTO()
                .setId(bookEntity.getId())
                .setTitle(bookEntity.getTitle())
                .setIsbn(bookEntity.getIsbn())
                .setAuthor(new AuthorDTO().setName(bookEntity.getAuthor().getName()));
    }
}
