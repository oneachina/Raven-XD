package cn.onea.keystrokesmod.module;

import java.util.ArrayList;
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
}
