package com.notifier.mailNotifier.repo;

import com.notifier.mailNotifier.entity.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepo extends MongoRepository<UserRequest, Integer> {
}
