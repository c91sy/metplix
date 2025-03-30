package com.metplix.entity.user;

import com.metplix.audit.MutableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends MutableBaseEntity {
    @Id
    @Column(name = "USER_ID")
    private String  userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    public UserEntity (String userId, String password, String userName, String email, String phone) {
        this.userId = UUID.randomUUID().toString(); // 랜덤 UUID 생성
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
