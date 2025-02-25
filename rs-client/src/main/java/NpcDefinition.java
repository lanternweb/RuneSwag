import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("NpcDefinition")
public class NpcDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("NpcDefinition_indexCache")
   static AbstractIndexCache NpcDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static AbstractIndexCache NpcDefinition_modelIndexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("NpcDefinition_cached")
   static EvictingDualNodeHashTable NpcDefinition_cached;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("NpcDefinition_cachedModels")
   static EvictingDualNodeHashTable NpcDefinition_cachedModels;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1937346627
   )
   @Export("id")
   public int id;
   @ObfuscatedName("u")
   @Export("name")
   public String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1541308911
   )
   @Export("size")
   public int size;
   @ObfuscatedName("l")
   @Export("archives")
   int[] archives;
   @ObfuscatedName("e")
   @Export("__e")
   int[] __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 275200787
   )
   @Export("idleSequence")
   public int idleSequence;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 819690597
   )
   @Export("turnLeftSequence")
   public int turnLeftSequence;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1311553413
   )
   @Export("turnRightSequence")
   public int turnRightSequence;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -284110917
   )
   @Export("walkSequence")
   public int walkSequence;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1952230339
   )
   @Export("walkTurnSequence")
   public int walkTurnSequence;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1213774321
   )
   @Export("walkTurnLeftSequence")
   public int walkTurnLeftSequence;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -96930503
   )
   @Export("walkTurnRightSequence")
   public int walkTurnRightSequence;
   @ObfuscatedName("j")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("s")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("t")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("y")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("h")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("b")
   @Export("drawMapDot")
   public boolean drawMapDot;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1192179847
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1469219067
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1390683537
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("v")
   @Export("__v")
   public boolean __v;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1235927151
   )
   @Export("__ag")
   int __ag;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1962875903
   )
   @Export("__aq")
   int __aq;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 235824283
   )
   @Export("headIconPrayer")
   public int headIconPrayer;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -506638747
   )
   @Export("__av")
   public int __av;
   @ObfuscatedName("ar")
   @Export("transforms")
   public int[] transforms;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1011388197
   )
   @Export("transformVarbit")
   int transformVarbit;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1631362233
   )
   @Export("transformVarp")
   int transformVarp;
   @ObfuscatedName("ah")
   @Export("isInteractable")
   public boolean isInteractable;
   @ObfuscatedName("ak")
   @Export("__ak")
   public boolean __ak;
   @ObfuscatedName("aw")
   @Export("isFollower")
   public boolean isFollower;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("params")
   IterableNodeHashTable params;

   static {
      NpcDefinition_cached = new EvictingDualNodeHashTable(64);
      NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   }

   NpcDefinition() {
      this.name = "null";
      this.size = 1;
      this.idleSequence = -1;
      this.turnLeftSequence = -1;
      this.turnRightSequence = -1;
      this.walkSequence = -1;
      this.walkTurnSequence = -1;
      this.walkTurnLeftSequence = -1;
      this.walkTurnRightSequence = -1;
      this.actions = new String[5];
      this.drawMapDot = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.__v = false;
      this.__ag = 0;
      this.__aq = 0;
      this.headIconPrayer = -1;
      this.__av = 32;
      this.transformVarbit = -1;
      this.transformVarp = -1;
      this.isInteractable = true;
      this.__ak = true;
      this.isFollower = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "482179419"
   )
   @Export("init")
   void init() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-893102766"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;IB)V",
      garbageValue = "-98"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.archives = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.archives[var4] = var1.__ag_302();
         }
      } else if(var2 == 2) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if(var2 == 12) {
         this.size = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.idleSequence = var1.__ag_302();
      } else if(var2 == 14) {
         this.walkSequence = var1.__ag_302();
      } else if(var2 == 15) {
         this.turnLeftSequence = var1.__ag_302();
      } else if(var2 == 16) {
         this.turnRightSequence = var1.__ag_302();
      } else if(var2 == 17) {
         this.walkSequence = var1.__ag_302();
         this.walkTurnSequence = var1.__ag_302();
         this.walkTurnLeftSequence = var1.__ag_302();
         this.walkTurnRightSequence = var1.__ag_302();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorFrom = new short[var3];
         this.recolorTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorFrom[var4] = (short)var1.__ag_302();
            this.recolorTo[var4] = (short)var1.__ag_302();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.retextureFrom = new short[var3];
         this.retextureTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.retextureFrom[var4] = (short)var1.__ag_302();
            this.retextureTo[var4] = (short)var1.__ag_302();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.__e = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.__e[var4] = var1.__ag_302();
         }
      } else if(var2 == 93) {
         this.drawMapDot = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.__ag_302();
      } else if(var2 == 97) {
         this.widthScale = var1.__ag_302();
      } else if(var2 == 98) {
         this.heightScale = var1.__ag_302();
      } else if(var2 == 99) {
         this.__v = true;
      } else if(var2 == 100) {
         this.__ag = var1.readByte();
      } else if(var2 == 101) {
         this.__aq = var1.readByte();
      } else if(var2 == 102) {
         this.headIconPrayer = var1.__ag_302();
      } else if(var2 == 103) {
         this.__av = var1.__ag_302();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.isInteractable = false;
         } else if(var2 == 109) {
            this.__ak = false;
         } else if(var2 == 111) {
            this.isFollower = true;
         } else if(var2 == 249) {
            this.params = AbstractIndexCache.readStringIntParameters(var1, this.params);
         }
      } else {
         this.transformVarbit = var1.__ag_302();
         if(this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.__ag_302();
         if(this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.__ag_302();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.__ag_302();
            if(this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;II)Ldu;",
      garbageValue = "1205135740"
   )
   @Export("getModel")
   public final Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if(this.transforms != null) {
         NpcDefinition var12 = this.transform();
         return var12 == null?null:var12.getModel(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)NpcDefinition_cachedModels.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.archives.length; ++var7) {
               if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.archives[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.archives.length];

            int var9;
            for(var9 = 0; var9 < this.archives.length; ++var9) {
               var8[var9] = ModelData.method2788(NpcDefinition_modelIndexCache, this.archives[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.recolorFrom != null) {
               for(var9 = 0; var9 < this.recolorFrom.length; ++var9) {
                  var11.recolor(this.recolorFrom[var9], this.recolorTo[var9]);
               }
            }

            if(this.retextureFrom != null) {
               for(var9 = 0; var9 < this.retextureFrom.length; ++var9) {
                  var11.retexture(this.retextureFrom[var9], this.retextureTo[var9]);
               }
            }

            var5 = var11.toModel(this.__ag + 64, this.__aq * 5 + 850, -30, -50, -30);
            NpcDefinition_cachedModels.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.animateSequence2(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.animateSequence(var5, var2);
         } else if(var3 != null) {
            var10 = var3.animateSequence(var5, var4);
         } else {
            var10 = var5.toSharedSequenceModel(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "-682265638"
   )
   @Export("getModelData")
   public final ModelData getModelData() {
      if(this.transforms != null) {
         NpcDefinition var1 = this.transform();
         return var1 == null?null:var1.getModelData();
      } else if(this.__e == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.__e.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.__e[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.__e.length];

            for(int var3 = 0; var3 < this.__e.length; ++var3) {
               var6[var3] = ModelData.method2788(NpcDefinition_modelIndexCache, this.__e[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.recolorFrom != null) {
               for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                  var7.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
               }
            }

            if(this.retextureFrom != null) {
               for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                  var7.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Ljz;",
      garbageValue = "-113"
   )
   @Export("transform")
   public final NpcDefinition transform() {
      int var1 = -1;
      if(this.transformVarbit != -1) {
         var1 = WorldMapSection2.getVarbit(this.transformVarbit);
      } else if(this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if(var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1?ObjectDefinition.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "853540088"
   )
   @Export("__e_435")
   public boolean __e_435() {
      if(this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.transformVarbit != -1) {
            var1 = WorldMapSection2.getVarbit(this.transformVarbit);
         } else if(this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
         }

         return var1 >= 0 && var1 < this.transforms.length?this.transforms[var1] != -1:this.transforms[this.transforms.length - 1] != -1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "256516117"
   )
   @Export("getIntParam")
   public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-245239968"
   )
   @Export("getStringParam")
   public String getStringParam(int var1, String var2) {
      return Frames.method3238(this.params, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2130256963"
   )
   @Export("sendStackTrace")
   public static void sendStackTrace(String var0, Throwable var1) {
      if(var1 != null) {
         var1.printStackTrace();
      } else {
         try {
            String var2 = "";
            if(var1 != null) {
               var2 = Canvas.method860(var1);
            }

            if(var0 != null) {
               if(var1 != null) {
                  var2 = var2 + " | ";
               }

               var2 = var2 + var0;
            }

            System.out.println("Error: " + var2);
            var2 = var2.replace(':', '.');
            var2 = var2.replace('@', '_');
            var2 = var2.replace('&', '_');
            var2 = var2.replace('#', '_');
            if(RunException.applet == null) {
               return;
            }

            URL var3 = new URL(RunException.applet.getCodeBase(), "clienterror.ws?c=" + RunException.revision + "&u=" + RunException.localPlayerName + "&v1=" + TaskHandler.javaVendor + "&v2=" + TaskHandler.javaVersion + "&ct=" + RunException.__fx_w + "&e=" + var2);
            DataInputStream var4 = new DataInputStream(var3.openStream());
            var4.read();
            var4.close();
         } catch (Exception var5) {
            ;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)Z",
      garbageValue = "-6579"
   )
   static final boolean method5164(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = ViewportMouse.ViewportMouse_y + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = ViewportMouse.ViewportMouse_y - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = ViewportMouse.ViewportMouse_x + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = ViewportMouse.ViewportMouse_x - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "330235566"
   )
   static void method5162() {
      Login.Login_username = Login.Login_username.trim();
      if(Login.Login_username.length() == 0) {
         class54.method1089("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(Message.method1227("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            Buffer var7 = new Buffer(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.array, var7.index, 1000 - var7.index);
               if(var8 == -1) {
                  var7.index = 0;
                  long var10 = var7.readLong();
                  var1 = var10;
                  break;
               }

               var7.index += var8;
               if(var7.index >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var14) {
            var1 = 0L;
         }

         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = class72.method1778(var1, Login.Login_username);
         }

         switch(var0) {
         case 2:
            class54.method1089(Strings.__id_jr, Strings.__id_jv, Strings.__id_ju);
            Login.__cu_aw = 6;
            break;
         case 3:
            class54.method1089("", "Error connecting to server.", "");
            break;
         case 4:
            class54.method1089("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class54.method1089("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class54.method1089("", "Error connecting to server.", "");
            break;
         case 7:
            class54.method1089("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1100306484"
   )
   static String method5161(String var0) {
      PlayerType[] var1 = class48.method865();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         PlayerType var3 = var1[var2];
         if(var3.modIcon != -1 && var0.startsWith(ItemContainer.method1170(var3.modIcon))) {
            var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
            break;
         }
      }

      return var0;
   }
}
