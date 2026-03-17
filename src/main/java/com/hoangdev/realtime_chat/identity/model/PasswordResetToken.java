package com.hoangdev.realtime_chat.identity.model;

import com.hoangdev.realtime_chat.comon.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
@Entity
@Table(name = "password_reset_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PasswordResetToken extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @Column(name = "token_hash",nullable = false)
    private String tokenHash;
    @Column(name = "expires_at",nullable = false)
    private Instant expiresAt;
    @Column(name = "used_at")
    private Instant usedAt;
}
