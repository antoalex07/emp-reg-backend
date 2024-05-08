package dev.antoalex.empregbackend.repository;

import dev.antoalex.empregbackend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, Integer> {

    public Optional<Role> findByName(String name);

}
