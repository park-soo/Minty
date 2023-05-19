package com.Reboot.Minty.member.repository;

import com.Reboot.Minty.member.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    long countByUserId(Long userId);
}
