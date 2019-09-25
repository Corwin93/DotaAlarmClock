package com.lance.dotaalarmclock.domain.repository.utils;

import com.lance.dotaalarmclock.domain.model.entity.Artifact;
import com.lance.dotaalarmclock.domain.model.entity.Item;
import com.lance.dotaalarmclock.domain.repository.ArtifactRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Corwin on 27.11.2017.
 */

public class ArtifactRepositoryUtils {
    public ArtifactRepository mArtifactRepository;

    public ArtifactRepositoryUtils(ArtifactRepository artifactRepository) {
        mArtifactRepository = artifactRepository;
        List<Item> itemList = artifactRepository.getItemList();
    }

    public Artifact getRandomArtifact() {
        List<Artifact> artifactList = mArtifactRepository.getArtifactList();
        return artifactList.get(new Random().nextInt(artifactList.size()));
    }

    public Item getRandomItem() {
        List<Item> itemList = mArtifactRepository.getItemList();
        return itemList.get(new Random().nextInt(itemList.size()));
    }

    public List<Item> getRandomItemList(int size) {
        List<Item> randomItemList = new LinkedList<>();
        for(int i = 0; i < size; i++) {
            randomItemList.add(getRandomItem());
        }
        return randomItemList;
    }
}
