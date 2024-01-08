package com.project.mailsystem.repositories;

import com.project.mailsystem.models.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity,Long> {
    Optional<UsersEntity> findByEmailCompany(String emailCompany);
}
