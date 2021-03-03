package com.gunnarsson.smartlighter.io.repositories;

import com.gunnarsson.smartlighter.io.entity.SiteEntity;
import org.springframework.data.repository.CrudRepository;

public interface SiteRepository extends CrudRepository<SiteEntity, Long> {
}
