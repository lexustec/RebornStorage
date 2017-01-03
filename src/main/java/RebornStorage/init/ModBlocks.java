package RebornStorage.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Gigabit101 on 03/01/2017.
 */
public class ModBlocks
{
    public static void init()
    {

    }

    public static void registerBlock(Block block, String name)
    {
        block.setRegistryName(name);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name)
    {
        block.setRegistryName(name);
        GameRegistry.register(block);
        try
        {
            ItemBlock itemBlock = itemclass.getConstructor(Block.class).newInstance(block);
            itemBlock.setRegistryName(name);
            GameRegistry.register(itemBlock);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}