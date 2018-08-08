package com.wind.valley.provider.service;

import com.wind.valley.common.service.UserService;
import com.wind.valley.common.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("service")
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user=new User();
        user.setId(1);
        user.setName("Achelous");
        user.setAge(25);
        user.setSex("Male");
        return user;
    }

    /*@Autowired
    private UserRepository repository;

    public User insert(User user) {
        System.out.println(user.getAge());
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSex());
        return repository.save(user);
    }

    public User findOne(Integer id) {
        return repository.findOne(id);
    }*/

}
