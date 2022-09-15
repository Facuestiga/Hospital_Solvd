package com.solvd.hospital.model;

public class Room {
    private long id;
    private String description;
    private long areaId;

    public Room(){}

    public Room(long id, String description, long areaId) {
        this.id = id;
        this.description = description;
        this.areaId = areaId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getAreaId() {
        return areaId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}
