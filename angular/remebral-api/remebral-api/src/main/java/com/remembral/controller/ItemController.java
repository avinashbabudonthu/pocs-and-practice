package com.remembral.controller;

import com.remembral.model.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ItemController {

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Item> getItems();

}
