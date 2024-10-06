package com.github.maeda6uiui.strelok;

/**
 * Interface to receive events dispatched from a subordinate scene
 *
 * @author maeda6uiui
 */
public interface ISceneEventReceiver {
    void changeScene(SceneType nextScene);
}
