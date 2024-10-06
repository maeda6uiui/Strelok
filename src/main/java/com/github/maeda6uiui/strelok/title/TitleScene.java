package com.github.maeda6uiui.strelok.title;

import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.mechtatel.core.input.keyboard.KeyCode;
import com.github.maeda6uiui.strelok.IScene;
import com.github.maeda6uiui.strelok.ISceneEventReceiver;
import com.github.maeda6uiui.strelok.SceneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title scene
 *
 * @author maeda6uiui
 */
public class TitleScene implements IScene {
    private static final Logger logger = LoggerFactory.getLogger(TitleScene.class);

    private ISceneEventReceiver parent;

    public TitleScene(ISceneEventReceiver parent) {
        this.parent = parent;

        logger.info("scene = title");
    }

    @Override
    public void init(MttWindow window) {

    }

    @Override
    public void update(MttWindow window) {
        if (window.getKeyboardPressingCount(KeyCode.ENTER) == 1) {
            parent.sceneClosed(SceneType.GAME);
        }
    }
}
