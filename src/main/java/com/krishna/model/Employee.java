package com.krishna.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String name;
}
