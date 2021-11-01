/*    */ package es.endydev;
/*    */ import es.endydev.commands.DirectoAdminCommand;
/*    */ import es.endydev.config.ConfigFile;
/*    */ import es.endydev.utils.Utils;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.plugin.Command;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.api.plugin.PluginManager;
/*    */ 
/*    */ public class Live extends Plugin {
/*    */   private static Live instance;
/*    */   private ConfigFile configFile;
/*    */   
/*    */   public static Live getInstance() {
/* 15 */     return instance;
/*    */   }
/*    */   
/* 18 */   public ConfigFile getConfigFile() { return this.configFile; } public void setConfigFile(ConfigFile configFile) { this.configFile = configFile; }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 22 */     instance = this;
/*    */     
/* 24 */     this.configFile = new ConfigFile("config.yml");
/*    */     
/* 26 */     registerCommands();
/* 27 */     Utils.log("&aPlugin inciado correctamente.");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {}
/*    */ 
/*    */   
/*    */   private void registerCommands() {
/* 36 */     PluginManager pm = ProxyServer.getInstance().getPluginManager();
/* 37 */     pm.registerCommand(this, (Command)new DirectoCommand("directo"));
/* 38 */     pm.registerCommand(this, (Command)new DirectoAdminCommand("directoadmin"));
/*    */   }
/*    */ }


/* Location:              C:\User\\usuario 1\Desktop\VictuzMc\Directo (7).jar!\es\endydev\Live.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */