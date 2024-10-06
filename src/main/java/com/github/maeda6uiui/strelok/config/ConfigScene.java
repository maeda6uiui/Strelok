package com.github.maeda6uiui.strelok.config;

import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.mechtatel.core.input.keyboard.KeyCode;
import com.github.maeda6uiui.strelok.IScene;
import com.github.maeda6uiui.strelok.ISceneEventReceiver;
import com.github.maeda6uiui.strelok.SceneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Config scene
 *
 * @author maeda6uiui
 */
public class ConfigScene implements IScene {
    private static final Logger logger = LoggerFactory.getLogger(ConfigScene.class);

    private ISceneEventReceiver parent;

    public ConfigScene(ISceneEventReceiver parent) {
        this.parent = parent;

        logger.info("scene = config");
    }

    @Override
    public void init(MttWindow window) {

    }

    @Override
    public void update(MttWindow window) {
        if (window.getKeyboardPressingCount(KeyCode.ESCAPE) == 1) {
            parent.sceneClosed(SceneType.TITLE);
        }

        window.present(window.getDefaultScreen());
    }
}
