package com.github.maeda6uiui.strelok.game;

import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.mechtatel.core.camera.FreeCamera;
import com.github.maeda6uiui.mechtatel.core.input.keyboard.KeyCode;
import com.github.maeda6uiui.mechtatel.core.screen.MttScreen;
import com.github.maeda6uiui.mechtatel.core.screen.component.MttModel;
import com.github.maeda6uiui.strelok.IScene;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Game scene
 *
 * @author maeda6uiui
 */
public class GameScene implements IScene {
    private MttScreen mainScreen;
    private MttModel level;
    private FreeCamera camera;

    public GameScene(MttWindow window) throws IOException {
        mainScreen = window.createScreen(
                new MttScreen.MttScreenCreateInfo()
        );
        level = mainScreen.createModel(Paths.get("./Data/Level/Playground/playground.bd1"));
        camera = new FreeCamera(mainScreen.getCamera());
    }

    @Override
    public void onUpdate(MttWindow window) {
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
    }
}
