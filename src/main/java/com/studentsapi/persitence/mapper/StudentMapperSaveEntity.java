

package com.studentsapi.persitence.mapper;

import com.studentsapi.persitence.dto.StudentSaveDto;
import com.studentsapi.persitence.entity.Student;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperSaveEntity {
    
    public Student toEntity(StudentSaveDto studentSaveDto) {
        if ( studentSaveDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( studentSaveDto.getName() );
        student.setLastName( studentSaveDto.getLastName() );
        student.setEmail( studentSaveDto.getEmail() );
        student.setLastModifiedBy( studentSaveDto.getLastModifiedBy() );
        student.setVersion( studentSaveDto.getVersion() );
        student.setCreatedBy(studentSaveDto.getCratedBy());
        student.setCreateDate(LocalDateTime.now());
        student.setLastModifiedDate(LocalDateTime.now());

        return student;
    }

}
