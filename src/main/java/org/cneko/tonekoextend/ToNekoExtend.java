package org.cneko.tonekoextend;

import org.bukkit.plugin.java.JavaPlugin;
import org.cneko.ctlib.common.file.AssetsFile;
import org.cneko.ctlib.common.file.Resources;
import org.cneko.tonekoextend.events.NekoChatEvent;

import java.io.IOException;
import java.net.URISyntaxException;

public final class ToNekoExtend extends JavaPlugin {
    public static ToNekoExtend instance;
    public static AssetsFile.LanguageAssets lang;
    @Override
    public void onEnable() {
        instance = this;
        try {
            Resources resources = new Resources(this.getClass());
            lang = new AssetsFile(resources,"lang.yml").getLanguageAssets();
            lang.setDefaultLanguage("zh_cn");
        } catch (URISyntaxException | IOException e) {
            this.getLogger().warning("Can not load resource:"+e.getMessage());
        }
        NekoChatEvent.init();
    }

    @Override
    public void onDisable() {
    }

    public static String getMessage(String key){
        return lang.get(key);
    }
}
