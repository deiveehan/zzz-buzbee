package com.cv.tech.framework.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cv.tech.framework.document.AppRole;

@Repository
public interface AppRoleRepository extends MongoRepository<AppRole, String> {

	public AppRole findByName(String name);

}