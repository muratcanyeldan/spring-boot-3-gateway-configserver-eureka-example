package com.inventory.service.controller;

import com.inventory.service.entity.Item;
import com.inventory.service.model.ItemRequest;
import com.inventory.service.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createItem(final HttpServletRequest request, @RequestBody ItemRequest itemRequest) {
        return itemService.createItem(itemRequest);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Item>> getAllItems(final HttpServletRequest request) {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }
}
