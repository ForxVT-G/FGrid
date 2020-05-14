package com.forx.grid;

import com.forx.grid.command.GridCommand;
import com.forx.grid.handlers.FileHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModInfo.MODID_LOWER)
public class FGrid
{
    public static final Logger LOGGER = LogManager.getLogger();

    public FGrid() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        FileHandler.initFolder();
    }

    @SubscribeEvent
    public void serverStarting(final FMLServerStartingEvent event) {
        GridCommand.register(event.getCommandDispatcher());
    }
}
