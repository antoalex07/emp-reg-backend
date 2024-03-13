package dev.antoalex.empregbackend.repository;

import dev.antoalex.empregbackend.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

    public Optional<Employee> findByEmpId(Integer empId);

    public String findNameByEmpId(Integer empId);

    public Boolean existsByEmpId(Integer empId);

//    @Query("db.employee.find({ }, { empId: 1, _id: 0 })")
//    public List<Integer> findEmpId();
}
