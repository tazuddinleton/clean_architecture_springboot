package com.example.movie_rental.domain;

import java.util.Date;

public abstract class BaseEntity {
    private Long id;
    private Date CreatedAt;
    private Date UpdatedAt;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }


    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }
}
