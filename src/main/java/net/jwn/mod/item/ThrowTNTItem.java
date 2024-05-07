package net.jwn.mod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class ThrowTNTItem extends Item {
    public ThrowTNTItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        PrimedTnt primedtnt = new PrimedTnt(pPlayer.level(), pPlayer.position().x + 0.5D, pPlayer.position().y, pPlayer.position().z + 0.5D, pPlayer);
        pPlayer.level().addFreshEntity(primedtnt);
        pPlayer.level().playSound(null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
        pPlayer.level().gameEvent(pPlayer, GameEvent.PRIME_FUSE, pPlayer.position());
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
