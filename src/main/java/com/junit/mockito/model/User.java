package com.junit.mockito.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "document_type", nullable = false)
    @JsonProperty("tipoDocumento")
    private String documentType;

    @Column(name = "document_number", nullable = false)
    @JsonProperty("numeroDocumento")
    private Integer documentNumber;

    @Column(name = "status")
    @JsonProperty("estado")
    private Boolean status;

    @Column(name = "name")
    @JsonProperty("nombres")
    private String name;

    @Column(name = "last_name")
    @JsonProperty("apellidos")
    private String lastName;

}
