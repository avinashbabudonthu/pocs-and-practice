package com.remembral.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private String id;
    private String name;
    private String email;

}
