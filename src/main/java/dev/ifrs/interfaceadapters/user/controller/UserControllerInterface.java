package dev.ifrs.interfaceadapters.user.controller;

import java.util.List;

import dev.ifrs.model.User;

public interface UserControllerInterface {

    public User save(String name);

    public List<User> listAll();

}
