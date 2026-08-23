package uk.co.extraspecialstudio.dead_air_broken_youth_radio;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(Dead_air_broken_youth_radio.MODID)
public class Dead_air_broken_youth_radio {
    public static final String MODID = "dead_air_broken_youth_radio";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> TRACK_SLUGS = List.of(
        "basement_dash",
        "boardwalk_reprise",
        "broken_bow",
        "cheap_thrills_chainmail",
        "crash_the_server",
        "crown_riot",
        "emerald_economy",
        "end_without_return",
        "flicker_before_the_fall",
        "gift_receipt",
        "glitchgate_catastrophe",
        "hearts_at_half_durability",
        "home_is_just_a_chest",
        "mallcore_apocalypse",
        "motel_window",
        "need_coal",
        "nethercore_meltdown",
        "no_fair_fight",
        "redstone_heartbeat_overclock",
        "respawn_like_nothing_happened",
        "rustjaw_transmission",
        "skating_on_the_witches_hut",
        "something_in_the_walls",
        "spawnpoint_argument",
        "string_burst",
        "underpass_echo",
        "velvet_parade",
        "wasting_all_my_time",
        "we_left_the_lights_on",
        "world_record_don_t_blink"
    );

    public Dead_air_broken_youth_radio() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(ForgeRegistries.Keys.SOUND_EVENTS)) {
            return;
        }
        for (String slug : TRACK_SLUGS) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
            event.register(ForgeRegistries.Keys.SOUND_EVENTS, id, () -> SoundEvent.createVariableRangeEvent(id));
        }
        LOGGER.info("[Broken Youth Radio] Registered {} music tracks.", TRACK_SLUGS.size());
    }
}
