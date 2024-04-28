package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @JsonProperty("id")
    @NotEmpty
    @Size(min = 1)
    private int id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @JsonProperty("phone")
    private int phone;
    @JsonProperty("address")
    private String address;
    private String customerId;


}
