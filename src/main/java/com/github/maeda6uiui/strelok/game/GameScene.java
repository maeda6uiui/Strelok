package com.github.maeda6uiui.strelok.game;

import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.mechtatel.core.camera.FreeCamera;
import com.github.maeda6uiui.mechtatel.core.input.keyboard.KeyCode;
import com.github.maeda6uiui.mechtatel.core.screen.MttScreen;
import com.github.maeda6uiui.mechtatel.core.screen.component.MttModel;
import com.github.maeda6uiui.strelok.IScene;
import com.github.maeda6uiui.strelok.ISceneEventReceiver;
import com.github.maeda6uiui.strelok.SceneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Game scene
 *
 * @author maeda6uiui
 */
public class GameScene implements IScene {
    private static final Logger logger = LoggerFactory.getLogger(GameScene.class);

    private ISceneEventReceiver parent;

    private MttScreen mainScreen;
    private MttModel level;
    private FreeCamera camera;

    public GameScene(ISceneEventReceiver parent) {
        this.parent = parent;

        logger.info("scene = game");
    }

    @Override
    public void init(MttWindow window) throws IOException {
        mainScreen = window.createScreen(
                new MttScreen.MttScreenCreateInfo()
        );
        level = mainScreen.createModel(Paths.get("./Data/Level/Playground/playground.bd1"));
        camera = new FreeCamera(mainScreen.getCamera());
    }

    @Override
    public void update(MttWindow window) {
        camera.translate(
                window.getKeyboardPressingCount(KeyCode.W),
                window.getKeyboardPressingCount(KeyCode.S),
                window.getKeyboardPressingCount(KeyCode.A),
                window.getKeyboardPressingCount(KeyCode.D)
        );
        camera.rotate(
                window.getKeyboardPressingCount(KeyCode.UP),
                window.getKeyboardPressingCount(KeyCode.DOWN),
                window.getKeyboardPressingCount(KeyCode.LEFT),
                window.getKeyboardPressingCount(KeyCode.RIGHT)
        );

        mainScreen.draw();
        window.present(mainScreen);

        if (window.getKeyboardPressingCount(KeyCode.ESCAPE) == 1) {
            this.cleanup();
            parent.sceneClosed(SceneType.TITLE);
        }
    }

    private void cleanup() {
        level.cleanup();
        mainScreen.cleanup();
    }
}
