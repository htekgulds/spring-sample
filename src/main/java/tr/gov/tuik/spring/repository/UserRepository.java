package tr.gov.tuik.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.tuik.spring.domain.User;

/**
 * Created by Hasan on 1.6.2015.
 */
public interface UserRepository extends JpaRepository<User, String> {

}
