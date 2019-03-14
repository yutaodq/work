package zy.cy6.zyxt.query.users.shiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zy.cy6.zyxt.query.users.shiro.entity.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    List<Role> findAllByStatus(int status);
}
