package cn.onea.keystrokesmod.module;

import cn.onea.keystrokesmod.module.impl.render.HUD;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModuleManager {
    static List<Module> modules = new ArrayList<>();
    public static List<Module> organizedModules = new ArrayList<>();

    public void addModule(Module m) {
        modules.add(m);
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> inCategory(Module.category category) {
        ArrayList<Module> categoryML = new ArrayList<>();

        for (Module mod : this.getModules()) {
            if (mod.moduleCategory().equals(category)) {
                categoryML.add(mod);
            }
        }

        return categoryML;
    }

    public Module getModule(String moduleName) {
        for (Module module : modules) {
            if (module.getName().equals(moduleName)) {
                return module;
            }
        }
        return null;
    }

    private static double getWidth(@NotNull Module module) {
        String text = module.getPrettyName()
                + ((HUD.showInfo.isToggled() && !module.getPrettyInfo().isEmpty()) ? " " + module.getPrettyInfo() : "");
        //return HUD.getFontRenderer().width(HUD.lowercase.isToggled() ? text.toLowerCase() : text);
    }

    public static void sort() {
        if (HUD.alphabeticalSort.isToggled()) {
            organizedModules.sort(Comparator.comparing(Module::getPrettyName));
        } else {
            organizedModules.sort((c1, c2) -> Double.compare(getWidth(c2), getWidth(c1)));
        }
    }
}
