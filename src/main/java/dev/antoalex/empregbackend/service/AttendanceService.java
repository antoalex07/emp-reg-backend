package dev.antoalex.empregbackend.service;

import dev.antoalex.empregbackend.dto.AttendanceDto;
import dev.antoalex.empregbackend.model.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    public List<AttendanceDto> fetchAttendance(Date date);

    public Attendance createAttendance(Attendance attendance);

    public List<Integer> getEmployeeIds(Date day);
}
