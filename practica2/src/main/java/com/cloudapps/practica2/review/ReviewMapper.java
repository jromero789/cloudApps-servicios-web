package com.cloudapps.practica2.review;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDTO(Review review);

    List<ReviewDTO> toDTOs(Collection<Review> reviews);

    Review toDomain(ReviewDTO reviewDTO);
}
