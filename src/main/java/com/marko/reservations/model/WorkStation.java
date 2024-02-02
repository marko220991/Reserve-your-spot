package com.marko.reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_stations")
public class WorkStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Each workStation must have unique code!")
    private String uniqueCode;

    @NotNull
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("workStations")
    @JoinColumn(name = "office_room_id")
    private OfficeRoom officeRoom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "workStation")
    @JsonIgnore
    private List<Reservation> reservations;

    public WorkStation(long id, String uniqueCode, String description, OfficeRoom officeRoom) {
        this.id = id;
        this.uniqueCode = uniqueCode;
        this.description = description;
        this.officeRoom = officeRoom;
    }

    public WorkStation(long id, String uniqueCode, String description) {
        this.id = id;
        this.uniqueCode = uniqueCode;
        this.description = description;
    }
}
