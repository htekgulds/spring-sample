package tr.gov.tuik.spring.service;

import tr.gov.tuik.spring.domain.User;

import java.util.List;

/**
 * Created by Hasan on 1.6.2015.
 */
public interface UserService {
    User save(User user);
    List<User> getList();
}
