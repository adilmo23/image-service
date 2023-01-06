package com.adilcodes.service;

import com.adilcodes.Exception.UserDetailsEmptyException;
import com.adilcodes.Exception.UserNameNotFoundException;
import com.adilcodes.entity.User;
import com.adilcodes.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) throws UserDetailsEmptyException {
        if (StringUtils.isEmpty(user.getUserName()) && StringUtils.isEmpty(user.getPassword()) && StringUtils.isBlank(user.getUserName()) && StringUtils.isBlank(user.getPassword())) {
            throw new UserDetailsEmptyException("Cannot create user details are empty");
        }
        if (user.getUserName() != null && user.getPassword() != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User getByUserName(User user) throws UserNameNotFoundException {
        if (StringUtils.isEmpty(user.getUserName()) && StringUtils.isEmpty(user.getPassword()) && StringUtils.isBlank(user.getUserName()) && StringUtils.isBlank(user.getPassword())) {
            throw new UserNameNotFoundException("Invalid username or password.");
        }
        if (user.getUserName() != null && user.getPassword() != null) {
            return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            userRepository.deleteById(id);
        }
    }


}
