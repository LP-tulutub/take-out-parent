package com.shop.pojo;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LayUIDataGrid {
    private int code;
    private  String msg;
    private int count;
    private List<?> data;

}
