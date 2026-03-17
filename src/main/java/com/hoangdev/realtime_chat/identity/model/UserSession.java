package com.hoangdev.realtime_chat.identity.model;

import com.hoangdev.realtime_chat.comon.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Table(name = "user_sessions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserSession extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @Column(name = "refresh_token",nullable = false,length = 500)
    private String refreshToken;
    @Column(name = "device_info",length = 255)
    private String deviceInfo;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(name = "revoked_at")
    private Instant revokedAt ;

}
