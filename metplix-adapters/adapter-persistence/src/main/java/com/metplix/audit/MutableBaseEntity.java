package com.metplix.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class MutableBaseEntity {
    @LastModifiedDate
    @Column(name = "MODIFIED_AT", updatable = false)
    private LocalDateTime modifiedAt;

    @LastModifiedDate
    @Column(name = "MODIFIED_BY", updatable = false)
    private String modifiedBy;
}
