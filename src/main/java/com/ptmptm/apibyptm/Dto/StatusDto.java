package com.ptmptm.apibyptm.Dto;

public class StatusDto {

    private Long id;

    private int status;

    public StatusDto() {
    }

    public StatusDto(Long id, int status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusDto [id=" + id + ", status=" + status + "]";
    }
    
}
