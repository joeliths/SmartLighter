package com.gunnarsson.smartlighter.io.repositories;

import com.gunnarsson.smartlighter.io.entity.LightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends CrudRepository<LightEntity,Long> {
    LightEntity findLightByLightId(String lightId);
}
