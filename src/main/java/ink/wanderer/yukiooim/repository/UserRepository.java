package ink.wanderer.yukiooim.repository;

import ink.wanderer.yukiooim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
