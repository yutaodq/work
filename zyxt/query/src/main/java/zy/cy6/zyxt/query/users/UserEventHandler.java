package zy.cy6.zyxt.query.users;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.cy6.zyxt.api.users.UserCreatedEvent;
import zy.cy6.zyxt.query.users.repositories.UserQueryRepository;

@Service
@ProcessingGroup("queryModel")
@Slf4j
public class UserEventHandler {
  private final UserQueryRepository repository;

  @Autowired
  public UserEventHandler(UserQueryRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(UserCreatedEvent event) {
    UserEntity userEntry = new UserEntity();
    userEntry.setIdentifier(event.getUserId().getIdentifier());
    userEntry.setUsername(event.getUsername().getName());
    userEntry.setPassword(event.getUserPassword().getPassword());
    repository.save(userEntry);
  }

}
