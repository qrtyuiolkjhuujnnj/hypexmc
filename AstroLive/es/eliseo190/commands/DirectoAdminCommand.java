/*    */ package es.endydev.commands;
/*    */ import es.endydev.Live;
/*    */ import es.endydev.config.ConfigFile;
/*    */ import es.endydev.utils.Utils;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ public class DirectoAdminCommand extends Command {
/*    */   public DirectoAdminCommand(String name) {
/* 13 */     super(name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(CommandSender sender, String[] args) {
/* 18 */     ProxiedPlayer player = (ProxiedPlayer)sender;
/* 19 */     ConfigFile configFile = Live.getInstance().getConfigFile();
/*    */ 
/*    */     
/* 22 */     if (!player.hasPermission("reed.directoreload")) {
/* 23 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-permission"))));
/*    */       
/*    */       return;
/*    */     } 
/* 27 */     if (args.length == 0) {
/* 28 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-args"))));
/*    */       
/*    */       return;
/*    */     } 
/* 32 */     if (args[0].equalsIgnoreCase("reload")) {
/* 33 */       Live.getInstance().setConfigFile(new ConfigFile("config.yml"));
/* 34 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize("&aEl plugin fue recargado correctamente.")));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\User\\usuario 1\Desktop\VictuzMc\Directo (7).jar!\es\endydev\commands\DirectoAdminCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */