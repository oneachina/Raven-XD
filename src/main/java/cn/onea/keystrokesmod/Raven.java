package cn.onea.keystrokesmod;

import cn.onea.keystrokesmod.keystroke.KeySrokeRenderer;
import cn.onea.keystrokesmod.module.Module;
import cn.onea.keystrokesmod.module.ModuleManager;
import cn.onea.keystrokesmod.utility.i18n.I18nManager;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.ClientCommandHandler;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Mod(value = "KeystrokesMod", dist = Dist.CLIENT)
public class Raven{
    public static boolean debugger = false;
    public static Minecraft mc = Minecraft.getInstance();
    private static KeySrokeRenderer keySrokeRenderer;
    private static boolean isKeyStrokeConfigGuiToggled;
    private static final ScheduledExecutorService ex = Executors.newScheduledThreadPool(4);
    @Getter
    private static ModuleManager moduleManager;
    //public static ClickGui clickGui;
    //public static ProfileManager profileManager;
    //public static ScriptManager scriptManager;
    //public static Profile currentProfile;
    //public static BadPacketsHandler badPacketsHandler;
    //public static ProgressManager progressManager;
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
    private boolean loaded = false;
    public static int moduleCounter;
    public static int settingCounter;

    public Raven() {
        moduleManager = new ModuleManager();
    }

    public void init()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(ex::shutdown));
        ClientCommandHandler.init();
        NeoForge.EVENT_BUS.register(this);
        I18nManager.init();
    }

    public static ScheduledExecutorService getExecutor() {
        return ex;
    }

    public static KeySrokeRenderer getKeyStrokeRenderer() {
        return keySrokeRenderer;
    }

    public static void toggleKeyStrokeConfigGui() {
        isKeyStrokeConfigGuiToggled = true;
    }
}