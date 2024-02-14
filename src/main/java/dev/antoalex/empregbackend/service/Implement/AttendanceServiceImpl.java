package dev.antoalex.empregbackend.service.Implement;

import dev.antoalex.empregbackend.repository.AttendanceRepository;
import dev.antoalex.empregbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
}
