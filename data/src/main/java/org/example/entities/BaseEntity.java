package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected String id; // we can do it as Long type

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = false;
}
