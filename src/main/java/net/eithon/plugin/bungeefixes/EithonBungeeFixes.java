package net.eithon.plugin.bungeefixes;

import net.md_5.bungee.api.plugin.Plugin;

public class EithonBungeeFixes extends Plugin {
	public void onEnable(){
        getProxy().getPluginManager().registerCommand(this, new ServerCommand());
    }
}