package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.User;
import project.model.service.UserServiceModel;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
