package zy.cy6.zyxt.query.users.shiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import zy.cy6.zyxt.query.users.shiro.entity.UserRole;

import java.util.Collection;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {
    List<UserRole> findAllByUserId(long userId);

    List<UserRole> findAllByUserIdIn(Collection<Long> userId);

    List<UserRole> findAllByRoleId(long roleId);

    /**
     * 清除权限
     *
     * @param userId 用户ID
     */
    int deleteByUserId(long userId);
}
