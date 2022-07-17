package com.project.Library.Service.Mapper;


public interface iMapper<T,U> {

    T toDTO(U entity);

    U toEntity(T DTO);
}
