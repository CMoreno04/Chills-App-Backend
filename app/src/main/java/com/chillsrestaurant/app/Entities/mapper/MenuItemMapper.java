package com.chillsrestaurant.app.entities.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.web.multipart.MultipartFile;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    @Mapping(target = "imageBlob", ignore = true) // Ignore automatic mapping
    @Mapping(target = "id", ignore = true)
    MenuItem newMenuItemDtoToMenuItem(NewMenuItemDTO menuItemDto);

    @AfterMapping
    default void handleImageMapping(NewMenuItemDTO menuItemDto, @MappingTarget MenuItem menuItem) {
        MultipartFile file = menuItemDto.getImage();
        if (file != null) {
            try {
                menuItem.setImageBlob(file.getBytes());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}