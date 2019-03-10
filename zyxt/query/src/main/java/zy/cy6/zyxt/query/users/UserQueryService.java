package zy.cy6.zyxt.query.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.users.Username;
import zy.cy6.zyxt.query.users.repositories.UserQueryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserQueryService {
  private final UserQueryRepository userRepository;

  @Autowired
  public UserQueryService(UserQueryRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<UserEntity> findOne(Long id) {
    return userRepository.findById(id);
  }

  public Optional<UserEntity> findByUsername(Username username) {
    String name = username.getName();
    return userRepository.findByUsername(name);
  }

  public Optional<UserEntity> findByIdentifier(String identifier) {
    return userRepository.findByIdentifier(identifier);

  }

  public List<UserEntity> findAllUsers() {
    log.info("所有的库房记录");
    return userRepository.findAll();
  }
}
