package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Setter
@Entity
@Table(
        name = "users",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "login", "application_type", "deleted" }) },
        indexes = {
                @Index(columnList = "login", name = "users_login_idx"),
                @Index(columnList = "application_type", name = "users_application_type_idx"),
        }
)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends AbstractAuditingEntity{

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    String login;

    @Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    String password;

    @Column(name = "application_type")
    String applicationType;
}
