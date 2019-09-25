package com.lance.dotaalarmclock.domain.interactors;

import com.lance.dotaalarmclock.domain.interactors.base.Interactor;
import com.lance.dotaalarmclock.domain.model.entity.Artifact;
import com.lance.dotaalarmclock.domain.model.entity.Item;

import java.util.List;

/**
 * Created by Corwin on 18.12.2017.
 */

public interface PuzzleInteractor extends Interactor {
    interface Callback {
        public static final String NUMBER_OF_VARIANT_ITEMS = "Number of variant items";

        void onLoading();

        void onListsReceived(Artifact taskArtifact, List<Item> variantItems, List<Item> solutionItems);
    }
}
