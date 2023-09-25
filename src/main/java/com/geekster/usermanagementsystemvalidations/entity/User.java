package com.geekster.usermanagementsystemvalidations.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @NotNull
    private Integer userId;
    @NotEmpty(message = "Username is required")
    private String userName;
   // @Pattern(regexp = "^\\d{4}-\\d{2}\\d{2}$",message="date-of-birth must be in yyyy-mm-dd formate")


    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Date of Birth must be in dd-MM-yyyy format")
    private String userDOB;
    @Email(message=" Invalid-Email-format,please enter the valid emailid")
    private String userEmail;
    @Size(min = 12, max = 12, message = "Phone Number must be 12 digits")
    @Pattern(regexp = "^91[0-9]+", message = "Phone Number must start with 91")

    private String userContactNo;


}
