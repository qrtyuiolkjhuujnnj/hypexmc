/*    */ package es.endydev.commands;
/*    */ 
/*    */ import es.endydev.Live;
/*    */ import es.endydev.config.ConfigFile;
/*    */ import es.endydev.utils.Utils;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.List;
/*    */ import net.md_5.bungee.BungeeCord;
/*    */ import net.md_5.bungee.api.CommandSender;
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.ClickEvent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DirectoCommand
/*    */   extends Command
/*    */ {
/*    */   public DirectoCommand(String name) {
/* 23 */     super(name, "", new String[] { "live", "stream" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute(CommandSender sender, String[] args) {
/* 28 */     ProxiedPlayer player = (ProxiedPlayer)sender;
/* 29 */     ConfigFile configFile = Live.getInstance().getConfigFile();
/*    */ 
/*    */     
/* 32 */     if (!player.hasPermission("reed.directo")) {
/* 33 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-permission"))));
/*    */       
/*    */       return;
/*    */     } 
/* 37 */     if (args.length == 0) {
/* 38 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-args"))));
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 43 */       new URL(args[0]);
/* 44 */     } catch (MalformedURLException e) {
/* 45 */       player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.invalid-url"))));
/*    */       
/*    */       return;
/*    */     } 
/* 49 */     TextComponent textComponent = new TextComponent("");
/* 50 */     String server = configFile.getString("servers." + player.getServer().getInfo().getName());
/* 51 */     if (server.equals("")) {
/* 52 */       List<String> live = configFile.getStringList("messages.live");
/* 53 */       for (int i = 0; i < live.size(); i++) {
/* 54 */         String x = live.get(i);
/* 55 */         if (x.contains("%live%")) {
/* 56 */           TextComponent message = new TextComponent(Utils.colorize(x.replace("%live%", configFile.getString("messages.click"))));
/* 57 */           message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, args[0]));
/* 58 */           textComponent.addExtra((BaseComponent)message);
/* 59 */           textComponent.addExtra((i < live.size()) ? "\n" : "");
/*    */         } else {
/*    */           
/* 62 */           textComponent.addExtra(Utils.colorize(x.replace("%player_name%", player.getDisplayName()).replace("%server_name%", server) + ((i < live.size()) ? "\n" : "")));
/*    */         } 
/*    */       } 
/*    */     } else {
/* 66 */       List<String> livePlaying = configFile.getStringList("messages.liveplaying");
/* 67 */       for (int i = 0; i < livePlaying.size(); i++) {
/* 68 */         String x = livePlaying.get(i);
/* 69 */         if (x.contains("%live%")) {
/* 70 */           TextComponent message = new TextComponent(Utils.colorize(x.replace("%live%", configFile.getString("messages.click"))));
/* 71 */           message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, args[0]));
/* 72 */           textComponent.addExtra((BaseComponent)message);
/* 73 */           textComponent.addExtra((i < livePlaying.size()) ? "\n" : "");
/*    */         } else {
/*    */           
/* 76 */           textComponent.addExtra(Utils.colorize(x.replace("%player_name%", player.getDisplayName()).replace("%server_name%", server) + ((i < livePlaying.size()) ? "\n" : "")));
/*    */         } 
/*    */       } 
/*    */     } 
/* 80 */     for (ProxiedPlayer players : BungeeCord.getInstance().getPlayers())
/* 81 */       players.sendMessage((BaseComponent)textComponent); 
/*    */   }
/*    */ }


/* Location:              C:\User\\usuario 1\Desktop\VictuzMc\Directo (7).jar!\es\endydev\commands\DirectoCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */