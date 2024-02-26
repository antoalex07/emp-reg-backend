package dev.antoalex.empregbackend.service.Implement;

import dev.antoalex.empregbackend.dto.AttendanceDto;
import dev.antoalex.empregbackend.model.Attendance;
import dev.antoalex.empregbackend.repository.AttendanceRepository;
import dev.antoalex.empregbackend.repository.EmployeeRepository;
import dev.antoalex.empregbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<AttendanceDto> fetchAttendance(Date date) {
        List<Attendance> attendances = attendanceRepository.findAllByDate(date);
        return mapToDto(attendances);
    }

    private List<AttendanceDto> mapToDto(List<Attendance> attendances){

        List<AttendanceDto> attendanceDtos = new ArrayList<>();

        for (Attendance attendance : attendances) {

            AttendanceDto attendanceDto = new AttendanceDto();

            Integer empId = attendance.getEmpId();
            attendanceDto.setId(empId);

            String name = employeeRepository.findNameByEmpId(empId);
            attendanceDto.setName(name);

            attendanceDto.setWork(attendance.getWork());
            attendanceDto.setOvertime(attendance.getOvertime());
            attendanceDto.setAdvance(attendance.getAdvance());

            attendanceDtos.add(attendanceDto);
        }
        return attendanceDtos;
    }
}
