package cn.itcast.repository;

import cn.itcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserReposity extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    public List<User> findAll();
}
