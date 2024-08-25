package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.Mechtatel;
import com.github.maeda6uiui.mechtatel.core.MttSettings;
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
                        () -> {
                            logger.warn("Fall back to default settings because setting file was not found");
                            new Main(new MttSettings());
                        }
                );
    }
}
