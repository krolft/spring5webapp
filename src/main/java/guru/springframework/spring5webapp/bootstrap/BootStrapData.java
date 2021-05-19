package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {

  private final PublisherRepository publisherRepository;
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootStrapData(
      PublisherRepository publisherRepository,
      AuthorRepository authorRepository,
      BookRepository bookRepository) {
    this.publisherRepository = publisherRepository;
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    val publisher =
        new Publisher("Computer Books", new Address("drive way", "city", "state", "1234"));

    val eric = new Author("Eric", "Evans");
    val ddd = new Book("Domain Driven Design", "12345", publisher);
    ddd.getAuthors().add(eric);
    eric.getBooks().add(ddd);

    val rod = new Author("Rod", "Johnson");
    val noEJB = new Book("J2EE development without EJB", "54321", publisher);
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    publisher.getBooks().add(ddd);
    publisher.getBooks().add(noEJB);

    publisherRepository.save(publisher);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    log.info("publishers {}", publisherRepository.count());
    log.info("authors {}", authorRepository.count());
    log.info("books {}", bookRepository.count());

    publisherRepository.findAll().forEach(p -> log.info("publisher: {}", p));
    authorRepository.findAll().forEach(a -> log.info("author: {}", a));
    bookRepository.findAll().forEach(b -> log.info("book: {}", b));
  }
}
