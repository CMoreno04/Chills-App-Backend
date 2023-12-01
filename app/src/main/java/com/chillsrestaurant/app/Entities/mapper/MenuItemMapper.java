package com.chillsrestaurant.app.entities.mapper;

import java.io.IOException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.AfterMapping;
import org.springframework.web.multipart.MultipartFile;

import com.chillsrestaurant.app.entities.MenuItem;
import com.chillsrestaurant.app.entities.dto.NewMenuItemDTO;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    @Mapping(target = "imageBlob", ignore = true) // Ignore automatic mapping for imageBlob
    @Mapping(target = "id", ignore = true) // Ignore automatic mapping for id
    MenuItem newMenuItemDtoToMenuItem(NewMenuItemDTO menuItemDto);

    @AfterMapping
    default void handleImageMapping(NewMenuItemDTO menuItemDto, @MappingTarget MenuItem menuItem) {
        MultipartFile imageFile = menuItemDto.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                menuItem.setImageBlob(imageBytes);
            } catch (IOException e) {
                // Handle IOException (e.g., log the error or rethrow as a runtime exception)
                throw new RuntimeException("Failed to read image file", e);
            }
        }
    }
}
