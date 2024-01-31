package com.marko.reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.jdbc.Work;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "office_rooms")
public class OfficeRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Office room must have a value!")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "office_space_id")
    @JsonIgnore
    private OfficeSpace officeSpace;

    @OneToMany(mappedBy = "officeRoom", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("officeRoom")
    List<WorkStation> workStations;

    public OfficeRoom(Long id, String name, String description, OfficeSpace officeSpace) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.officeSpace = officeSpace;
    }
}
