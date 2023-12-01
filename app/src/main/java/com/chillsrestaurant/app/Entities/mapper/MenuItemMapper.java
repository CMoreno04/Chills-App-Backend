package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.AfterMapping;
import java.util.Base64;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    @Mapping(target = "imageBlob", ignore = true) // Ignore automatic mapping for imageBlob
    @Mapping(target = "id", ignore = true) // Ignore automatic mapping for id
    MenuItem newMenuItemDtoToMenuItem(NewMenuItemDTO menuItemDto);

    @AfterMapping
    default void handleImageMapping(NewMenuItemDTO menuItemDto, @MappingTarget MenuItem menuItem) {
        String imageBase64 = menuItemDto.getImage();
        if (imageBase64 != null && !imageBase64.isEmpty()) {
            // Convert Base64 string to a byte array
            byte[] imageBytes = Base64.getDecoder().decode(imageBase64);
            menuItem.setImageBlob(imageBytes);
        }
    }
}
