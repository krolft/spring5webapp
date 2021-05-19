package guru.springframework.spring5webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
  private String addressLine1;
  private String city;
  private String state;
  private String zipcode;
}
