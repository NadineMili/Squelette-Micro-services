package com.nadine.school;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String username;
    private String lastname;
    private String email;
}
