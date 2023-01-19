package com.junit.mockito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty("tipoDocumento")
    private String documentType;

    @JsonProperty("numeroDocumento")
    private Integer documentNumber;

    @JsonProperty("estado")
    private Boolean status;

    @JsonProperty("nombres")
    private String name;

    @JsonProperty("apellidos")
    private String lastName;

}
