package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.Mechtatel;
import com.github.maeda6uiui.mechtatel.core.MttSettings;
import com.github.maeda6uiui.mechtatel.core.MttWindow;
import com.github.maeda6uiui.mechtatel.core.screen.MttScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Override
    public void onCreate(MttWindow window) {
        MttScreen defaultScreen = window.getDefaultScreen();
        defaultScreen.createLineSet().addPositiveAxes(10.0f).createBuffer();
    }

    @Override
    public void onUpdate(MttWindow window) {
        MttScreen defaultScreen = window.getDefaultScreen();
        defaultScreen.draw();
        window.present(defaultScreen);
    }
}
