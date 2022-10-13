package dev.ifrs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Channel {

    private String hash;
    private List<Message> messages;

    @JsonBackReference
    private List<User> users;

}
