package com.Reboot.Minty.chat.entity;

import com.Reboot.Minty.member.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
public class messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(name = "Message_text")
    private String Message;

    @Column(name = "Message_from")
    private Long fId;
    @Column(name = "Message_to")
    private Long tId;

    @Column(updatable = false, nullable = false)
    private Date createDateTime;



}
