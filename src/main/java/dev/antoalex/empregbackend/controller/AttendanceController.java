package dev.antoalex.empregbackend.controller;

import dev.antoalex.empregbackend.dto.AttendanceDto;
import dev.antoalex.empregbackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{date}")
    public ResponseEntity<List<AttendanceDto>> fetchAttendance(@PathVariable String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date day = format.parse(date);
        return new ResponseEntity<List<AttendanceDto>>(
                attendanceService.fetchAttendance(day), HttpStatus.OK
        );
    }
}
