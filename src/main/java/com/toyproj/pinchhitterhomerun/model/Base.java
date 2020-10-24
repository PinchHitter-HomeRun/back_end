package com.toyproj.pinchhitterhomerun.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
@Getter
public class Base {

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;

    protected void setCreatedDate() {
        this.createdDate = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    protected void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    protected void setDeletedDate() {
        this.deletedDate = LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}