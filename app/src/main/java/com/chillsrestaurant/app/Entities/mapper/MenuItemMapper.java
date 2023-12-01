package com.chillsrestaurant.app.entities.mapper;

import java.util.Base64;

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
        String imageBase64 = menuItemDto.getImage();
        if (imageBase64 != null && !imageBase64.isEmpty()) {
            menuItem.setImageBlob(Base64.getDecoder().decode(imageBase64.split(",")[1]));
        }
    }
}
