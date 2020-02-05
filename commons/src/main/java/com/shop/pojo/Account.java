package com.shop.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Account {
    private String username;
    private String password;
    private String type;
}
