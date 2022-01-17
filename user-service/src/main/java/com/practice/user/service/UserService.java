package com.practice.user.service;

import com.practice.user.VO.Department;
import com.practice.user.VO.ResponseTemplateVO;
import com.practice.user.entity.User;
import com.practice.user.respository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);
        log.info("inside saveUser method of getUserWithDepartment");

        Department dep = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(dep);
        return responseTemplateVO;
    }
}
