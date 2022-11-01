package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<E, D> {

    /**
     * @param dto
     * @return
     */
    E toEntity(D dto);

    /**
     * @param entity
     * @return
     */
    D toDTO(E entity);

    /**
     * @param list
     * @return
     */
    default List<E> toEntity(List<D> list) {
        return list.stream().map(this::toEntity).collect(Collectors.toList());
    }

    /**
     * @param list
     * @return
     */
    default List<D> toDTO(List<E> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
