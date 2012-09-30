package com.cv.tech.framework.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cv.tech.framework.document.AppUser;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, String> {

	public AppUser findByUserId(String userId);

}