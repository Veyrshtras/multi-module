package org.example.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class AbstractAuditingEntity implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    String id;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    boolean deleted = false;

    @CreatedBy
    @Column(name = "creator_id")
    String creatorId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", updatable = false, insertable = false)
    @Where(clause = "deleted = 'false'")
    User creator;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "updater_id")
    String updaterId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "updater_id", updatable = false, insertable = false)
    User updater;

    @LastModifiedDate
    @Column(name = "updated_date")
    LocalDateTime updatedDate = LocalDateTime.now();

}
