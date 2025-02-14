package com.remembral.controller.impl;

import com.remembral.controller.ItemController;
import com.remembral.model.Item;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemControllerImpl implements ItemController {

    @Override
    public List<Item> getItems() {
        return List.of(
                Item.builder().id("1").name("a").email("a@gmail.com").build(),
                Item.builder().id("2").name("b").email("b@gmail.com").build(),
                Item.builder().id("3").name("c").email("c@gmail.com").build()
        );
    }
}