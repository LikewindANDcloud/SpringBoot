package com.wind.valley.common.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface UserService<T> {
    public T getUser();
}
