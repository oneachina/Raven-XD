package cn.onea.keystrokesmod.module.setting.impl;

import cn.onea.keystrokesmod.module.Module;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public class LiteralSubMode extends SubMode<Module> {
    public LiteralSubMode(String name, @NotNull Module parent) {
        super(name, parent);
    }

    @Override
    public <T extends Annotation> T getAnnotation(@NotNull Class<T> annotationClass) {
        return null;
    }

    @Override
    public Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }
}
