package zy.cy6.zyxt.query.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import zy.cy6.zyxt.query.users.UserEntity;

import java.util.Optional;

public interface UserQueryRepository  extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findById(Long id);
  Optional<UserEntity> findByIdentifier(String identifier);
  Optional<UserEntity> findByUsername(String name);
}
