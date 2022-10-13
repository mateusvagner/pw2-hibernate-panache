package dev.ifrs.interfaceadapters.user.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String text;
}
