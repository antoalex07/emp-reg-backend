package dev.antoalex.empregbackend.repository;

import dev.antoalex.empregbackend.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByUserName(String userName);

    public Boolean existsByUserName(String userName);
}
