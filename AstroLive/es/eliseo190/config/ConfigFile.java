/*    */ package es.endydev.config;
/*    */ 
/*    */ import es.endydev.Live;
/*    */ import es.endydev.utils.Utils;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.file.Files;
/*    */ import java.util.List;
/*    */ import java.util.stream.Stream;
/*    */ import net.md_5.bungee.config.Configuration;
/*    */ import net.md_5.bungee.config.ConfigurationProvider;
/*    */ import net.md_5.bungee.config.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigFile
/*    */ {
/*    */   private File file;
/*    */   private Configuration configuration;
/*    */   
/*    */   public ConfigFile(String name) {
/* 23 */     if (!Live.getInstance().getDataFolder().exists()) Live.getInstance().getDataFolder().mkdir();
/*    */     
/* 25 */     this.file = new File(Live.getInstance().getDataFolder(), name);
/* 26 */     if (!this.file.exists()) {
/* 27 */       try (InputStream in = Live.getInstance().getResourceAsStream("config.yml")) {
/* 28 */         Files.copy(in, this.file.toPath(), new java.nio.file.CopyOption[0]);
/* 29 */       } catch (IOException e) {
/* 30 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/*    */     try {
/* 35 */       this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
/* 36 */     } catch (IOException e) {
/* 37 */       Stream.<String>of(e.getMessage().split("\n")).forEach(Utils::log);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void save() {
/*    */     try {
/* 43 */       ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.configuration, this.file);
/* 44 */     } catch (IOException e) {
/* 45 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void load() {
/*    */     try {
/* 51 */       this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
/* 52 */     } catch (IOException e) {
/* 53 */       Stream.<String>of(e.getMessage().split("\n")).forEach(Utils::log);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getString(String path) {
/* 58 */     return this.configuration.getString(path);
/*    */   }
/*    */   
/*    */   public boolean getBoolean(String path) {
/* 62 */     return this.configuration.getBoolean(path);
/*    */   }
/*    */   
/*    */   public List<String> getStringList(String path) {
/* 66 */     return this.configuration.getStringList(path);
/*    */   }
/*    */ }


/* Location:              C:\User\\usuario 1\Desktop\VictuzMc\Directo (7).jar!\es\endydev\config\ConfigFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */