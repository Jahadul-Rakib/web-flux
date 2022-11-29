package com.rakib.officemanagement.model_repository;

import com.rakib.officemanagement.model.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserInfoRepository extends ReactiveMongoRepository<UserInfo, ObjectId> {
    Mono<UserInfo> findByEmail(String email);
}
