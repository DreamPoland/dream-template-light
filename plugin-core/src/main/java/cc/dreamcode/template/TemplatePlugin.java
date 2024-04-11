package cc.dreamcode.template;

import cc.dreamcode.platform.DreamVersion;
import cc.dreamcode.platform.bukkit.DreamBukkitPlatform;
import cc.dreamcode.platform.bukkit.component.ListenerResolver;
import cc.dreamcode.platform.bukkit.component.RunnableResolver;
import cc.dreamcode.platform.component.ComponentManager;
import lombok.Getter;
import lombok.NonNull;

public final class TemplatePlugin extends DreamBukkitPlatform {

    @Getter private static TemplatePlugin templatePlugin;

    @Override
    public void load(@NonNull ComponentManager componentManager) {
        templatePlugin = this;
    }

    @Override
    public void enable(@NonNull ComponentManager componentManager) {
        componentManager.registerResolver(ListenerResolver.class);
        componentManager.registerResolver(RunnableResolver.class);
    }

    @Override
    public void disable() {
        // features need to be call when server is stopping
    }

    @Override
    public @NonNull DreamVersion getDreamVersion() {
        return DreamVersion.create("Dream-Template", "1.0-InDEV", "author");
    }
}
