package com.chillsrestaurant.app.entities.mapper;

import java.nio.charset.StandardCharsets;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    @Mapping(target = "imageBlob", ignore = true) // Ignore automatic mapping
    @Mapping(target = "id", ignore = true)
    MenuItem newMenuItemDtoToMenuItem(NewMenuItemDTO menuItemDto);

    @AfterMapping
    default void handleImageMapping(NewMenuItemDTO menuItemDto, @MappingTarget MenuItem menuItem) {
        String imageBinaryString = menuItemDto.getImage();
        if (imageBinaryString != null && !imageBinaryString.isEmpty()) {
            byte[] decodedBytes = imageBinaryString.getBytes(StandardCharsets.ISO_8859_1);
            menuItem.setImageBlob(decodedBytes);
        }
    }
    
}
