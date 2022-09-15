package com.solvd.hospital.model;

public class Bed {
    private long id;
    private long roomId;
    private long patientId;

    public Bed(){}

    public Bed(long id, long roomId, long patientId) {
        this.id = id;
        this.roomId = roomId;
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", patientId=" + patientId +
                '}';
    }
}
