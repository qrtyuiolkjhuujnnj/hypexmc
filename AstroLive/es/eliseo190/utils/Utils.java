/*    */ package es.endydev.utils;
/*    */ 
/*    */ import es.endydev.Live;
/*    */ import es.endydev.config.ConfigFile;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ 
/*    */ public final class Utils {
/*    */   private Utils() {
/*  9 */     throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
/*    */   } public static void log(String message) {
/* 11 */     Live.getInstance().getLogger().info(colorize(message));
/*    */   }
/*    */   
/*    */   public static String colorize(String message) {
/* 15 */     return ChatColor.translateAlternateColorCodes('&', message);
/*    */   }
/*    */   
/*    */   public static String getFormatedServer(String serverName) {
/* 19 */     ConfigFile configFile = Live.getInstance().getConfigFile();
/* 20 */     return configFile.getString("servers." + serverName);
/*    */   }
/*    */ }


/* Location:              C:\User\\usuario 1\Desktop\VictuzMc\Directo (7).jar!\es\endyde\\utils\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */