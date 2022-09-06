package com.project.Library.Mapper;


public interface iMapper<T,U> {

    T toDTO(U entity);

    U toEntity(T DTO);
}
