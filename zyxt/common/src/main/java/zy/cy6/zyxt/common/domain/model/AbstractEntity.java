package zy.cy6.zyxt.common.domain.model;

import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity implements Identifiable<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Long getId() {
    return id;
  }

  public AbstractEntity(){}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AbstractEntity)) return false;
    AbstractEntity that = (AbstractEntity) o;
    return Objects.equals(getId(), that.getId());
  }
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
