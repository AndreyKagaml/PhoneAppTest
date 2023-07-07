package ua.test.PhoneContacts.validators;

import org.springframework.stereotype.Component;
import ua.test.PhoneContacts.models.User;


import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {


    public void validate(User user, List<User> users) {
        List<String> names = new ArrayList<>();

        for (User c : users){
            names.add(c.getName());
        }

        if (names.contains(user.getName())) {
            throw new RuntimeException("User with this name already exists");
        }
    }

    public void validate(int id, List<User> users){
        List<Integer> ids = new ArrayList<>();

        for (User c : users){
            ids.add(c.getId_user());
        }

        if (!ids.contains(id)) {
            throw new RuntimeException("User not found");
        }
    }
}
