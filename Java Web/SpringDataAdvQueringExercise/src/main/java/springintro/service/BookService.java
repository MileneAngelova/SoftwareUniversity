package springintro.service;

import springintro.model.entity.AgeRestriction;
import springintro.model.entity.Book;
import springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    void findBooksByAgeRestriction(AgeRestriction ageRestriction);

    void findByEditionTypeWithCopiesLessThan(EditionType editionType, int countCopies);

    void findBooksByAuthorLastName(String firstLetters);
}
