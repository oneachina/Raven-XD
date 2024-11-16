package cn.onea.keystrokesmod.module.setting.impl;

import cn.onea.keystrokesmod.Raven;
import cn.onea.keystrokesmod.module.Module;
import cn.onea.keystrokesmod.module.setting.Setting;
import org.jetbrains.annotations.NotNull;

public abstract class SubMode<T extends Module> extends Module{
    protected final String name;
    public final T parent;

    public SubMode(String name, @NotNull T parent) {
        super(parent.getName() + "$" + name, parent.moduleCategory());
        this.name = name;
        this.parent = parent;
    }

    @Override
    public void register() {
        Raven.getModuleManager().addModule(this);
    }

    @Override
    public String getInfo() {
        return getPrettyName();
    }

    @Override
    public String getPrettyName() {
        return getRawPrettyName();
    }

    @Override
    public String getRawPrettyName() {
        return name;
    }

    @Override
    public void registerSetting(Setting setting) {
        super.registerSetting(setting);
    }
}
