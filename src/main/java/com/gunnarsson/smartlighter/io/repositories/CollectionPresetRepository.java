package com.gunnarsson.smartlighter.io.repositories;

import com.gunnarsson.smartlighter.io.entity.CollectionPresetEntity;
import com.gunnarsson.smartlighter.io.entity.PresetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollectionPresetRepository extends CrudRepository<CollectionPresetEntity,Long> {
     CollectionPresetEntity findPresetBycollectionPresetId (String collectionPresetId);
}
