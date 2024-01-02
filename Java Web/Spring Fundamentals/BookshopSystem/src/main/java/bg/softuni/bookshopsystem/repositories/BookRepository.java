package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.models.etities.Author;
import bg.softuni.bookshopsystem.models.etities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> getBooksByAuthorOrderByReleaseDateDescTitleAsc(Author author);
    //  Optional<Author> countAuthorsByBooksBefore(LocalDate releaseDate);


//  int countAllByReleaseDateAfter(LocalDate releaseDate);
}
