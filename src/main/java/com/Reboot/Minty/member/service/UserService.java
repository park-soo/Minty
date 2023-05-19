package com.Reboot.Minty.member.service;

import com.Reboot.Minty.member.entity.User;
import com.Reboot.Minty.member.entity.UserLocation;
import com.Reboot.Minty.member.repository.UserLocationRepository;
import com.Reboot.Minty.member.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLocationRepository userLocationRepository;

    // 회원 가입 DB 저장
    public User saveUser(User user){
        validateDuplicateMember(user);
        return userRepository.save(user);
    }

    // User의 PK 조회
    public Long getUserId(String email){
        User user = userRepository.findByEmail(email);
        return user.getId();
    }

    // 중복 회원 확인
    private void validateDuplicateMember(User user){
        User findUser = userRepository.findByEmail(user.getEmail());
        if(findUser !=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
    
    // 위치 인증 저장
    public void saveUserLocation(Long userId, String latitude, String longitude, String address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        UserLocation userLocation = new UserLocation();
        userLocation.setLatitude(latitude);
        userLocation.setLongitude(longitude);
        userLocation.setAddress(address);
        userLocation.setUser(user);

        userLocationRepository.save(userLocation);
    }

    // DB에 해당 회원이 위치 정보 값 있는지 판단
    public boolean userHasLocation(Long userId){
        long count = userLocationRepository.countByUserId(userId);
        return count > 0;
    }

    public boolean isDuplicatedEmail(String email){
        int isExistEmail = userRepository.countByEmail(email);
        if(isExistEmail==0) {return true;}
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user ==null){
            throw new UsernameNotFoundException(email);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // 패스워드도 설정해야 합니다
                .roles(user.getRole().toString())
                .build();
    }
}
