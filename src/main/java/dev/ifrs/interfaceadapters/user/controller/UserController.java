package dev.ifrs.interfaceadapters.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import dev.ifrs.interfaceadapters.user.repository.Repository;
import dev.ifrs.interfaceadapters.user.repository.entity.UserEntity;
import dev.ifrs.model.User;
import dev.ifrs.usecase.user.UseCase;
import dev.ifrs.usecase.user.UseCaseInterface;

@RequestScoped
@Transactional
public class UserController implements UserControllerInterface {

    private UseCaseInterface uc;
    private Repository repo;

    public UserController() {
        this.uc = new UseCase();
        this.repo = new Repository();
    }

    @Override
    public User save(String name) {
        User user = uc.save(name);
        return repo.save(user);
    }

    @Override
    public List<User> listAll() {
        List<UserEntity> users = repo.findAll().list();

        List<User> usersDomain = users.stream().map(item -> {
            User user = new User();
            user.setName(item.getName());
            return user;
        }).collect(Collectors.toList());

        return usersDomain;
    }

}
