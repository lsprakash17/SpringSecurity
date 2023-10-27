package org.jsp.bootcrudrest.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Component
@Data
public class Student
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private long mobile;
private int physics;
private int mathematics;
private int computerscience;
private int total;
private double percentage;
private String result;
}
