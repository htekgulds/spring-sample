package tr.gov.tuik.spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.gov.tuik.spring.domain.User;
import tr.gov.tuik.spring.repository.UserRepository;
import tr.gov.tuik.spring.service.UserService;
import tr.gov.tuik.spring.service.exception.UserAlreadyExistsException;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Hasan on 1.6.2015.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(final User user) {
        User existing = repository.findOne(user.getId());
        if (existing != null) {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id=%s", user.getId()));
        }
        return repository.save(user);
    }

    @Override
    public List<User> getList() {
        return null;
    }
}
