package com.studentsapi.persitence.mapper;

import com.studentsapi.persitence.entity.Student;
import com.studentsapi.persitence.dto.StudentGetDto;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentGetDto toDto(Student entity);

    List<StudentGetDto> toDtoList(List<Student> entity);

}
