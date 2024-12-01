package cn.onea.keystrokesmod.module.impl.client;

import cn.onea.keystrokesmod.module.Module;
import cn.onea.keystrokesmod.module.setting.impl.ButtonSetting;
import cn.onea.keystrokesmod.module.setting.impl.DescriptionSetting;
import cn.onea.keystrokesmod.module.setting.impl.ModeSetting;
import cn.onea.keystrokesmod.module.setting.impl.SliderSetting;
import net.minecraft.sounds.SoundEvent;

public class Settings extends Module {
    public static ButtonSetting weaponSword;
    public static ButtonSetting weaponAxe;
    public static ButtonSetting weaponRod;
    public static ButtonSetting weaponStick;
    public static SliderSetting offset;
    public static SliderSetting timeMultiplier;
    public static ModeSetting toggleSound;
    public static ButtonSetting sendMessage;

    public Settings() {
        super("Settings", Module.category.client, 0);
        this.registerSetting(new DescriptionSetting("General"));
        this.registerSetting(weaponSword = new ButtonSetting("Set sword as weapon", true));
        this.registerSetting(weaponAxe = new ButtonSetting("Set axe as weapon", false));
        this.registerSetting(weaponRod = new ButtonSetting("Set rod as weapon", false));
        this.registerSetting(weaponStick = new ButtonSetting("Set stick as weapon", false));
        this.registerSetting(new DescriptionSetting("Profiles"));
        this.registerSetting(sendMessage = new ButtonSetting("Send message on enable", true));
        this.registerSetting(new DescriptionSetting("Theme colors"));
        this.registerSetting(offset = new SliderSetting("Offset", 0.5, -3.0, 3.0, 0.1));
        this.registerSetting(timeMultiplier = new SliderSetting("Time multiplier", 0.5, 0.1, 4.0, 0.1));
        this.registerSetting(toggleSound = new ModeSetting("Toggle sound", new String[]{"None", "Rise", "Sigma", "QuickMacro"}, 1));
        this.canBeEnabled = false;
    }

    public static SoundEvent getToggleSound(boolean enable) {
        final String startSuffix = "keystrokesmod:toggle.";
        final String endSuffix = enable ? ".enable" : ".disable";

        final String middleSuffix;
        switch ((int) toggleSound.getInput()) {
            default:
            case 0:
                return "";
            case 1:
                middleSuffix = "rise";
                break;
            case 2:
                middleSuffix = "sigma";
                break;
            case 3:
                middleSuffix = "quickmacro";
                break;
        }
        return startSuffix + middleSuffix + endSuffix;
    }

    @Override
    public void register() {}
}