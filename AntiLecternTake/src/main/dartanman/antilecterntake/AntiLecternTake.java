package main.dartanman.antilecterntake;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

/**
 * AntiLecternTake - The Main (and only) class of the AntiLecternTake plugin.
 * @author Austin Dart (Dartanman)
 *
 */
public class AntiLecternTake extends JavaPlugin implements Listener{
	
	private String ALLOW_TAKE_PERMISSION = "antilecterntake.bypass";
	
	/**
	 * Registers the only event listener in this plugin
	 */
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	/**
	 * Listens to the given event, in this case, the PlayerTakeLecternBookEvent
	 * @param event
	 *   The PlayerTakeLecternBookEvent
	 */
	@EventHandler
	public void onTake(PlayerTakeLecternBookEvent event) {
		Player player = event.getPlayer();
		if(!player.hasPermission(ALLOW_TAKE_PERMISSION)) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You can't take that!");
		}
	}

}
