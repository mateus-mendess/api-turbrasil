package com.br.turbrasil.mapper;

import com.br.turbrasil.dto.request.CategoryRequest;
import com.br.turbrasil.dto.response.CategoryResponse;
import com.br.turbrasil.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);

    CategoryResponse toResponse(Category category);
}
