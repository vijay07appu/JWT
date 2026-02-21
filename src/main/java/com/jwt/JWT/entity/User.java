package com.jwt.JWT.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

@Entity
@Table(
        name="users",
        uniqueConstraints = {
                @UniqueConstraint(name="uk_userName",columnNames = "userName"),
                @UniqueConstraint(name="uk_email",columnNames = "email")
        }
)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable=false)
    private String password;
}
