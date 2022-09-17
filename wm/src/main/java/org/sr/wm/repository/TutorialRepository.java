package org.sr.wm.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.sr.wm.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean published);
}
