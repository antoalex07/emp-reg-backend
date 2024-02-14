package dev.antoalex.empregbackend.repository;

import dev.antoalex.empregbackend.model.Attendance;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttendanceRepository extends MongoRepository<Attendance, ObjectId> {
}
