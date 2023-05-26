package com.Reboot.Minty.manager.service;

import com.Reboot.Minty.manager.dto.VisitorCountDto;
import com.Reboot.Minty.manager.entity.VisitorCount;
import com.Reboot.Minty.manager.repository.VisitorCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorCountService {
    private final VisitorCountRepository visitorCountRepository;

    @Autowired
    public VisitorCountService(VisitorCountRepository visitorCountRepository) {
        this.visitorCountRepository = visitorCountRepository;
    }

    public List<VisitorCountDto> getAllVisitorCounts() {
        List<VisitorCount> visitorCounts = visitorCountRepository.findAll();
        return mapToDto(visitorCounts);
    }

    private List<VisitorCountDto> mapToDto(List<VisitorCount> visitorCounts) {
        return visitorCounts.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private VisitorCountDto mapToDto(VisitorCount visitorCount) {
        VisitorCountDto dto = new VisitorCountDto();
        dto.setVisitDate(visitorCount.getVisitDate());
        dto.setCount(visitorCount.getCount());
        return dto;
    }

    public VisitorCountDto getVisitorCountByDate(LocalDate date) {
        VisitorCount visitorCount = visitorCountRepository.findByVisitDate(date);
        return convertToDto(visitorCount);
    }

    @Transactional
    public VisitorCountDto updateVisitorCountByDate(LocalDate date) {
        VisitorCount visitorCount = visitorCountRepository.findByVisitDate(date);

        if (visitorCount == null) {
            visitorCount = new VisitorCount();
            visitorCount.setVisitDate(date);
            visitorCount.setCount(1);
            visitorCount = visitorCountRepository.save(visitorCount);
        } else {
            int count = visitorCount.getCount() + 1;
            visitorCount.setCount(count);
        }

        return convertToDto(visitorCount);
    }

    private VisitorCountDto convertToDto(VisitorCount visitorCount) {
        VisitorCountDto dto = new VisitorCountDto();
        dto.setVisitDate(visitorCount.getVisitDate());
        dto.setCount(visitorCount.getCount());
        return dto;
    }
}