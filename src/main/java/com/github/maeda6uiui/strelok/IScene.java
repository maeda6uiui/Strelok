package com.github.maeda6uiui.strelok;

import com.github.maeda6uiui.mechtatel.core.MttWindow;

import java.io.IOException;

/**
 * Interface to scenes
 *
 * @author maeda6uiui
 */
public interface IScene {
    void init(MttWindow window) throws IOException;

    void update(MttWindow window);
}
