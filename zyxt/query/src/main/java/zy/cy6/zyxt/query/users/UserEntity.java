package zy.cy6.zyxt.query.users;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import zy.cy6.zyxt.api.users.UserAccount;
import zy.cy6.zyxt.api.users.UserPassword;
import zy.cy6.zyxt.common.domain.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userEntity")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
@Slf4j
public class UserEntity extends AbstractEntity {
//  public class UserEntity extends AbstractEntity implements UserAccount, Serializable {

  @Column(name = "identifier")
  private String identifier;
  @Column(name = "username")
  private String username;  //库房名称
  @Column(name = "password")
  private String password;

}
