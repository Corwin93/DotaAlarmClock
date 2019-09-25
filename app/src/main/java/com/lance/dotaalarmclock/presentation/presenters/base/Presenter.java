package com.lance.dotaalarmclock.presentation.presenters.base;

/**
 * Created by Corwin on 18.12.2017.
 */

public interface Presenter<T> {

    public void bindView(T view);

    public void unbindView();

    public boolean isBinded();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onStop() method.
     */
    void stop();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();


    /**
     * Method that should signal the appropriate view to show the appropriate error with the provided message.
     */
    void onError(String message);
}
