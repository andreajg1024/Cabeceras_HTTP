package com.example.cabeceras_http.service;

import com.example.cabeceras_http.mapping.StudentsDto;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<StudentsDto> listar() {

        List<StudentsDto> students = new ArrayList<>();

        students.add(new StudentsDto(1, "Estudiante 1", "estudiante1@example.com", 1));
        students.add(new StudentsDto(2, "Estudiante 2", "estudiante2@example.com", 2));
        students.add(new StudentsDto(3, "Estudiante 3", "estudiante3@example.com", 3));
        return students;
    }
}
