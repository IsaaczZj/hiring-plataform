package com.isaac.hiring_platform.domain.company;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(nullable = false, length = 120, unique = true)
    private String slug;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String websiteUrl;
    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
