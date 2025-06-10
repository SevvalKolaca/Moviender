package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository<T> extends JpaRepository<User, UUID> {
    //User findById(UUID id);
    // zaten jpa içerisinde olduğundan tanımlamaya gerek yok
}
