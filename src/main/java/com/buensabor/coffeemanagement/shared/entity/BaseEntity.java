<<<<<<< HEAD:src/main/java/com/buensabor/coffeemanagement/shared/Entity/BaseEntity.java
package com.buensabor.coffeemanagement.shared.Entity; 
=======
package com.buensabor.coffeemanagement.shared.entity;
>>>>>>> sprint3:src/main/java/com/buensabor/coffeemanagement/shared/entity/BaseEntity.java

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD:src/main/java/com/buensabor/coffeemanagement/shared/Entity/BaseEntity.java
    @Column(updatable = false, nullable = false)
=======
    @Column(nullable = false, updatable = false)
>>>>>>> sprint3:src/main/java/com/buensabor/coffeemanagement/shared/entity/BaseEntity.java
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

<<<<<<< HEAD:src/main/java/com/buensabor/coffeemanagement/shared/Entity/BaseEntity.java
    // Métodos automáticos para que Spring Data Auditing maneje las fechas solo
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
=======
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
>>>>>>> sprint3:src/main/java/com/buensabor/coffeemanagement/shared/entity/BaseEntity.java
    }

    @PreUpdate
    protected void onUpdate() {
<<<<<<< HEAD:src/main/java/com/buensabor/coffeemanagement/shared/Entity/BaseEntity.java
        this.updatedAt = LocalDateTime.now();
=======
        updatedAt = LocalDateTime.now();
>>>>>>> sprint3:src/main/java/com/buensabor/coffeemanagement/shared/entity/BaseEntity.java
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}