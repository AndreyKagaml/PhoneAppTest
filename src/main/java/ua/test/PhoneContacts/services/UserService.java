package ua.test.PhoneContacts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.test.PhoneContacts.models.User;
import ua.test.PhoneContacts.repositories.UserRepository;
import ua.test.PhoneContacts.validators.UserValidator;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    @Autowired
    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findOne(int id){
        userValidator.validate(id, userRepository.findAll());
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(User user){
        userValidator.validate(user, userRepository.findAll());
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser){
        userValidator.validate(id, userRepository.findAll());
        userValidator.validate(updatedUser, userRepository.findAll());

        updatedUser.setId_user(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }

}
