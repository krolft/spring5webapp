package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NonNull
  private String title;

  @NonNull
  private String isbn;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;

  @ToString.Exclude
  @ManyToMany
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();
}
