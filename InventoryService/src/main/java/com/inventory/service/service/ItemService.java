package com.inventory.service.service;

import com.inventory.service.entity.Item;
import com.inventory.service.model.ItemRequest;
import com.inventory.service.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public ResponseEntity<String> createItem(ItemRequest itemRequest) {
        try {
            itemRepository.save(Item.builder()
                    .itemName(itemRequest.itemName())
                    .description(itemRequest.description())
                    .build());
            return ResponseEntity.ok().body("Item created");
        } catch (Exception e) {
            return ResponseEntity.ok().body("Error while creating item: " + e.getMessage());
        }
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemByName(String itemName) {
        return itemRepository.findByItemName(itemName);
    }
}
