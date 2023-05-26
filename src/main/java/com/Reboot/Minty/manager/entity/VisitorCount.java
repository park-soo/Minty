package com.Reboot.Minty.manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visitorCount")
public class VisitorCount {
    @Id
    private LocalDate visitDate;

    private int count;
}
