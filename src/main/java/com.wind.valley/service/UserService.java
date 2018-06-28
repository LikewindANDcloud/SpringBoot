package application.service;

import application.entity.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
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
    }

}
