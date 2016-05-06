package net.eithon.plugin.bungeefixes;

import net.eithon.plugin.bungeefixes.logic.Controller;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class EithonBungeeFixes extends Plugin {
	Controller _controller;
	public void onEnable(){
        ProxyServer proxy = getProxy();
		PluginManager pluginManager = proxy.getPluginManager();
		this._controller = new Controller();
		pluginManager.registerListener(this, new EventListener(proxy, this._controller));
    }
}