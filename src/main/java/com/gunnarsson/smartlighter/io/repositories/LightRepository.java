package com.gunnarsson.smartlighter.io.repositories;

import com.gunnarsson.smartlighter.io.entity.LightEntity;
import org.springframework.data.repository.CrudRepository;

public interface LightRepository extends CrudRepository<LightEntity,Long> {
}
