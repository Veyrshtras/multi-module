package org.example.repositories.jpa;

import org.example.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseJpaRepository<User, String> {
}
