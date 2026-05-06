package com.br.turbrasil.service;

import com.br.turbrasil.dto.request.CategoryRequest;
import com.br.turbrasil.dto.response.CategoryResponse;
import com.br.turbrasil.exception.CategoryAlreadyExistsException;
import com.br.turbrasil.mapper.CategoryMapper;
import com.br.turbrasil.model.entity.Category;
import com.br.turbrasil.model.entity.User;
import com.br.turbrasil.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse save(Jwt jwt, CategoryRequest request) {
        User user = userService.getAuthenticateUser(jwt);

        validate(request.name());

        Category category = categoryMapper.toCategory(request);
        category.setUser(user);

        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    private void validate(String name) {
        if (categoryRepository.existsByName(name)) {
            throw new CategoryAlreadyExistsException("Category already exists in system.");
        }

    }


}
