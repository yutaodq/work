package zy.cy6.zyxt.common.domain.model;

import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity implements Identifiable<Long> {
  @Id
  @GeneratedValue
  private Long id;

  public Long getId() {
    return id;
  }

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
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    AbstractEntity that = (AbstractEntity) o;
//
//    if (id != null ? !id.equals(that.id) : that.id != null) return false;
//
//    return true;
//  }
//
//  @Override
//  public int hashCode() {
//    return id != null ? id.hashCode() : 0;
//  }
}
