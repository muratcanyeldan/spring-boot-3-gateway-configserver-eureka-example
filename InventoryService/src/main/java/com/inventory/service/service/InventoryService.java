package com.inventory.service.service;

import com.inventory.service.entity.Inventory;
import com.inventory.service.entity.Item;
import com.inventory.service.model.InventoryRequest;
import com.inventory.service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemService itemService;

    public ResponseEntity<String> addItemToInventory(InventoryRequest inventoryRequest) {
        Item item = itemService.getItemByName(inventoryRequest.itemName());
        if (item != null) {
            Inventory currentInventoryObject = inventoryRepository.findByItemId(item.getId());
            if (currentInventoryObject != null) {
                currentInventoryObject.setQuantity(currentInventoryObject.getQuantity() + inventoryRequest.quantity());
                inventoryRepository.save(currentInventoryObject);
                return ResponseEntity.ok().body("Item added to inventory");
            }
            inventoryRepository.save(Inventory.builder()
                    .itemId(item.getId())
                    .quantity(inventoryRequest.quantity())
                    .build());
            return ResponseEntity.ok().body("Item added to inventory");
        } else {
            return ResponseEntity.badRequest().body("Item not found");
        }
    }

    public List<Inventory> getCurrentInventory() {
        return inventoryRepository.findAll();
    }
}
