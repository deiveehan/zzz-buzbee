package com.cv.tech.framework.mongorepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cv.tech.framework.document.Widget;

@Repository
public interface WidgetRepository extends MongoRepository<Widget, String> {

	public List<Widget> findByUserPID(String userPID);

}
