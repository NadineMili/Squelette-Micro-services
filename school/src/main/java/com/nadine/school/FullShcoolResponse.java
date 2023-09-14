package com.nadine.school;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullShcoolResponse {

    private String name;
    private String email;

    List<Student> students;

}
