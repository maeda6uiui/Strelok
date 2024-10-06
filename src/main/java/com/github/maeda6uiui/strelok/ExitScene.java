package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.MttWindow;

/**
 * Scene to exit the game
 *
 * @author maeda6uiui
 */
public class ExitScene implements IScene {
    @Override
    public void init(MttWindow window) {

    }

    @Override
    public void update(MttWindow window) {
        window.close();
    }
}
