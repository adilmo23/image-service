package com.adilcodes.service;

import com.adilcodes.Exception.UserDetailsEmptyException;
import com.adilcodes.Exception.UserNameNotFoundException;
import com.adilcodes.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user) throws UserDetailsEmptyException;

    public User getByUserName(User user) throws UserNameNotFoundException;

    public List<User> findAllUsers();

    public void deleteById(Long id);
}
