package com.cloudapps.practica2.review;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDTO(Review review);

    ReviewDTO toDTOs(Review review);

    default Page<ReviewDTO> toDTOs(Page<Review> page) {
        return page.map(this::toDTOs);
    }

    Review toDomain(ReviewDTO reviewDTO);
}
