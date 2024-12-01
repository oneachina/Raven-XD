package cn.onea.keystrokesmod.utility.font.impl;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.io.InputStream;
import java.util.Arrays;

import static cn.onea.keystrokesmod.Raven.mc;
import static net.minecraft.resources.ResourceLocation.isValidNamespace;
import static net.minecraft.resources.ResourceLocation.isValidPath;

public class FontUtil {

    private static final IResourceManager RESOURCE_MANAGER = mc.getResourceManager();

    public FontUtil(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public static Font getResource(String location, int size) {
        Font font;

        ScaledResolution sr = new ScaledResolution(mc);

        size = (int) (size * ((double) sr.getScaleFactor() / 2));

        try {
            InputStream is = mc.getResourceManager().getResource(new ResourceLocation("keystrokesmod:fonts/" + location)).getInputStream();
            font = Font.createFont(0, is).deriveFont(Font.PLAIN, size);
        } catch (Exception exception) {
            Utils.sendMessage(Arrays.toString(exception.getStackTrace()));
            font = new Font("default", Font.PLAIN, size);
        }
        return font;
    }

    private String namespace;
    private String path;
    private void ResourceLocation(String pNamespace, String pPath) {
        assert isValidNamespace(pNamespace);

        assert isValidPath(pPath);

        this.namespace = pNamespace;
        this.path = pPath;
    }
}
