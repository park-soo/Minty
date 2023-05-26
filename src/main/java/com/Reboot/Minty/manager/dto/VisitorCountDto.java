package com.Reboot.Minty.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class VisitorCountDto {
    private LocalDate visitDate;
    private int count;
}

