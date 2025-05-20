package com.example.roleplaymenu;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class RoleplayEventHandler {
    private boolean hasOpenedMenu = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (!hasOpenedMenu && Minecraft.getInstance().player != null && Minecraft.getInstance().screen == null) {
            hasOpenedMenu = true;
            Minecraft.getInstance().setScreen(new RoleplayMenuScreen());
        }
    }
}