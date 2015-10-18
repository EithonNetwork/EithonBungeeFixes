package net.eithon.plugin.bungeefixes;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class EithonBungeeFixes extends Plugin {
	public void onEnable(){
        ProxyServer proxy = getProxy();
		PluginManager pluginManager = proxy.getPluginManager();
		pluginManager.registerListener(this, new EventListener(proxy));
        //pluginManager.registerCommand(this, new ServerCommand());
    }
}