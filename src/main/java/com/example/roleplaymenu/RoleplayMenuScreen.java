package com.example.roleplaymenu;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class RoleplayMenuScreen extends Screen {
    protected RoleplayMenuScreen() {
        super(new StringTextComponent("Alege Rolul"));
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 - 30, 200, 20, new StringTextComponent("Polițist"), b -> selectRole("Polițist")));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2, 200, 20, new StringTextComponent("Doctor"), b -> selectRole("Doctor")));
        this.addButton(new Button(this.width / 2 - 100, this.height / 2 + 30, 200, 20, new StringTextComponent("Civil"), b -> selectRole("Civil")));
    }

    private void selectRole(String role) {
        this.minecraft.player.sendChatMessage("Ai ales rolul: " + role);
        this.minecraft.setScreen(null); // închide meniul
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.font, this.title.getString(), this.width / 2, 20, 0xFFFFFF);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}