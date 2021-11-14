package com.wolfpack.vision.persistance.repository;

import com.wolfpack.vision.persistance.document.VisionUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VisionUserRepo extends MongoRepository<VisionUser, String> {
    List<VisionUser> findAll();
}
