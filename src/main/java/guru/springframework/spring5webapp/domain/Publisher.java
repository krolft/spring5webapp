package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NonNull private String name;

  @Embedded @NonNull private Address address;

  @OneToMany(mappedBy = "publisher")
  @ToString.Exclude
  private Set<Book> books = new HashSet<>();
}
