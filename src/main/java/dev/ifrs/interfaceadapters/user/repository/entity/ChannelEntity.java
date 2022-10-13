package dev.ifrs.interfaceadapters.user.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChannelEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String hash;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_id")
    private List<MessageEntity> messages;

    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    private List<UserEntity> users;

    public ChannelEntity() {
        this.users = new ArrayList<>();
    }

}
