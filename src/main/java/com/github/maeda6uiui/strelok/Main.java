package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.Mechtatel;
import com.github.maeda6uiui.mechtatel.core.MttSettings;
import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.strelok.config.ConfigScene;
import com.github.maeda6uiui.strelok.game.GameScene;
import com.github.maeda6uiui.strelok.title.TitleScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main extends Mechtatel implements ISceneEventReceiver {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public Main(MttSettings settings) {
        super(settings);
        this.run();
    }

    public static void main(String[] args) {
        MttSettings
                .load("./settings.json")
                .ifPresentOrElse(
                        Main::new,
                        () -> logger.error("Setting file not found")
                );
    }

    private IScene scene;
    private boolean mustInitScene;

    @Override
    public void onCreate(MttWindow window) {
        scene = new TitleScene(this);
        mustInitScene = true;
    }

    @Override
    public void onUpdate(MttWindow window) {
        if (mustInitScene) {
            try {
                scene.init(window);
            } catch (IOException e) {
                logger.error("Error", e);
                scene = new ExitScene();
            }

            mustInitScene = false;
        }

        scene.update(window);
    }

    @Override
    public void changeScene(SceneType nextScene) {
        switch (nextScene) {
            case TITLE -> scene = new TitleScene(this);
            case GAME -> scene = new GameScene(this);
            case CONFIG -> scene = new ConfigScene(this);
            case EXIT -> scene = new ExitScene();
        }

        mustInitScene = true;
    }
}
