package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.Mechtatel;
import com.github.maeda6uiui.mechtatel.core.MttSettings;
import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.strelok.game.GameScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main extends Mechtatel {
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

    @Override
    public void onCreate(MttWindow window) {
        try {
            scene = new GameScene(window);
        } catch (IOException e) {
            logger.error("Error", e);
            window.close();
        }
    }

    @Override
    public void onUpdate(MttWindow window) {
        scene.update(window);
    }
}
