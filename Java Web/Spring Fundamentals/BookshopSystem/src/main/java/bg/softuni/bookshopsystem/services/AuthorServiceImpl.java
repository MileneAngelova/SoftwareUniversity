package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.models.etities.Author;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();
        long authorId = new Random().nextInt((int) size) + 1;

        return this.authorRepository.findById(authorId).get();
    }
}
