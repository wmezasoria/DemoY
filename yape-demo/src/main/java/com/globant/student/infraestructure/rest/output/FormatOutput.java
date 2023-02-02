package com.globant.student.infraestructure.rest.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormatOutput<T> {
    List<T> data;
    List<FormatMessage> messages;
}
