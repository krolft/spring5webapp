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
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NonNull private String firstName;

  @NonNull private String lastName;

  @ToString.Exclude
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();
}
