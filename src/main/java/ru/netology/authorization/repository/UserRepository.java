package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.exception.InvalidCredentials;
import ru.netology.authorization.exception.UnauthorizedUser;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        registerUser(new User("admin", "admin", true));
        registerUser(new User("Oleg", "1234"));
    }

    public List<Authorities> getUserAuthorities(String userName, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();

        if (users.containsKey(userName)) {
            if (users.get(userName).getPass().equals(password)) {
                if (users.get(userName).isAdmin()) {
                    authoritiesList.add(Authorities.WRITE);
                    authoritiesList.add(Authorities.DELETE);
                }
                authoritiesList.add(Authorities.READ);
            } else {
                throw new UnauthorizedUser("Неверная пара логин-пароль!");
            }
        } else {
            throw new InvalidCredentials("Пользователя с таким именем не существует!");
        }

        return authoritiesList;
    }

    private void registerUser(User user) {
        if (!users.containsKey(user.getName())) {
            this.users.put(user.getName(), user);
        }
    }
}
