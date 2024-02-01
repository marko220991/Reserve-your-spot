package com.marko.reservations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "office_spaces")
public class OfficeSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Office Space must have a value!")
    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "officeSpace", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OfficeRoom> rooms;

    public OfficeSpace(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
