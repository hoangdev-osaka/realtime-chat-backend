package com.hoangdev.realtime_chat.identity.model;

import com.hoangdev.realtime_chat.comon.BaseEntity;
import com.hoangdev.realtime_chat.comon.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique= true, length = 50)
    private String username;
    @Column(nullable = false, length = 255)
    private String passwordHash;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false)
    private Role role = Role.USER;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserSession> userSessions = new ArrayList<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<PasswordResetToken> passwordResetTokens = new ArrayList<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<LoginAudit> loginAudits = new ArrayList<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<EmailVerificationToken> emailVerificationTokens = new ArrayList<>();
}
