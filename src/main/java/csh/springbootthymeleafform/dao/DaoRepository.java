package csh.springbootthymeleafform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import csh.springbootthymeleafform.entity.User;

public interface DaoRepository extends JpaRepository<User, Integer>{

}
