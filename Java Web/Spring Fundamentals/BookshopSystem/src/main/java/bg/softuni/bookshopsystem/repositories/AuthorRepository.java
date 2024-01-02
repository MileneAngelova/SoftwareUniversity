package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.models.etities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findDistinctAuthorByBooksReleaseDateBefore(LocalDate releaseDate);
    List<Author> findAll();
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
//    Optional<Author> countAuthorsByBooksBefore(LocalDate releaseDate);
}
