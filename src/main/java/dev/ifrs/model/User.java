package dev.ifrs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name;

    private List<Message> messages;

    @JsonManagedReference
    private List<Channel> channels;

}
