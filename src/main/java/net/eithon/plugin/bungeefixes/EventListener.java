package net.eithon.plugin.bungeefixes;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {

    public EventListener(ProxyServer proxy) {
		super();
	}

	@EventHandler
    public void onPostLogin(PostLoginEvent event) {
    }

}
