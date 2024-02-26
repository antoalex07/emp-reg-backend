package dev.antoalex.empregbackend.service;

import dev.antoalex.empregbackend.dto.AttendanceDto;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    public List<AttendanceDto> fetchAttendance(Date date);
}
