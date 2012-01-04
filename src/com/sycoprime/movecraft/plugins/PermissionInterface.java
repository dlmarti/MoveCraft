package com.sycoprime.movecraft.plugins;

import com.sycoprime.movecraft.MoveCraft;

import org.bukkit.entity.Player;

/**
 * Permissions support file to interface Nijikokun's Permissions plugin to MoveCraft
*/

public class PermissionInterface {
	
	public static boolean CheckPermission(Player player, String command) {		
		command = command.replace(" ", ".");
		MoveCraft.instance.DebugMessage("Checking if " + player.getName() + " can " + command, 3);
		
		if(MoveCraft.instance.ConfigSetting("RequireOp").equalsIgnoreCase("true") && !player.isOp()) {
				MoveCraft.instance.DebugMessage("Op is required, and " + player.getDisplayName() + " doesn't have it.", 4);
				return false;
		}
				
		else if(player.hasPermission(command) || player.isOp()) {
			MoveCraft.instance.DebugMessage("Player has permissions: " + 
					player.hasPermission(command), 3);
	    	MoveCraft.instance.DebugMessage("Player isop: " + 
		    			player.isOp(), 3);
		    	return true;
		    }
		
		player.sendMessage("You do not have permission to preform " + command);
		return false;
		}
}
