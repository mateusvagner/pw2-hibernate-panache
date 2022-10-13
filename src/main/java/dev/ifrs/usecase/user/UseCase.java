package dev.ifrs.usecase.user;

import dev.ifrs.model.User;

public class UseCase implements UseCaseInterface {

    @Override
    public User save(String name) {
        User user = null;
        // rule
        if (name.length() >= 3) {
            user = new User();
            user.setName(name);
        } else {
            throw new IllegalArgumentException();
        }
        return user;
    }

}
