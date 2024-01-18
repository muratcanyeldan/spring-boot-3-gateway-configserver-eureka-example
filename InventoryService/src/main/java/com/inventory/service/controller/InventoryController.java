package com.inventory.service.controller;

import com.inventory.service.entity.Inventory;
import com.inventory.service.model.InventoryRequest;
import com.inventory.service.service.InventoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Inventory>> getCurrentInventory(final HttpServletRequest request) {
        List<Inventory> currentInventoryList = inventoryService.getCurrentInventory();
        return ResponseEntity.ok().body(currentInventoryList);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addItemToInventory(final HttpServletRequest request, @RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.addItemToInventory(inventoryRequest);
    }
}
