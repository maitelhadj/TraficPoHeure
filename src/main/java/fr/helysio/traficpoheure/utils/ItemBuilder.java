package fr.helysio.traficpoheure.utils;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemBuilder {
    private ItemStack item;
    private ItemMeta meta;
    private Material material = Material.STONE;
    private int amount = 1;
    private MaterialData data;
    private short damage = 0;
    private Map<Enchantment, Integer> enchantments = new HashMap<>();
    private String displayname;
    private List<String> lore = new ArrayList<>();
    private List<ItemFlag> flags;

    private boolean andSymbol = true;
    private boolean unsafeStackSize = false;

    public ItemBuilder(Material material) {
        if (material == null)
            material = Material.AIR;
        item = new ItemStack(material);
        this.material = material;
        this.flags = new ArrayList<ItemFlag>();
    }

    public ItemBuilder(Material material, int amount) {
        if (material == null)
            material = Material.AIR;
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize))
            amount = 1;
        this.amount = amount;
        item = new ItemStack(material, amount);
        this.material = material;
        this.flags = new ArrayList<ItemFlag>();
    }

    public ItemBuilder(Material material, int amount, String displayname, List<String> Lore) {
        if (material == null)
            material = Material.AIR;
//        Validate.notNull(displayname, "The Displayname is null.");
        item = new ItemStack(material, amount);
        this.material = material;
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize))
            amount = 1;
        this.amount = amount;
        this.displayname = displayname;
        this.lore = Lore;
        this.flags = new ArrayList<ItemFlag>();
    }

    public ItemBuilder(Material material, String displayname) {
        if (material == null)
            material = Material.AIR;
//        Validate.notNull(displayname, "The Displayname is null.");
        item = new ItemStack(material);
        this.material = material;
        this.displayname = displayname;
        this.flags = new ArrayList<ItemFlag>();
    }

    public ItemBuilder glow() {
        this.enchant((this.material != Material.BOW) ? Enchantment.ARROW_INFINITE : Enchantment.LUCK, 10);
        this.flag(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemBuilder(ItemStack item) {
//        Validate.notNull(item, "The Item is null.");
        this.item = new ItemStack(item.getType());
        meta = this.item.getItemMeta();
        material = item.getType();
        amount = item.getAmount();
        data = item.getData();
        damage = item.getDurability();
        enchantments = item.getEnchantments();
        this.flags = new ArrayList<ItemFlag>();

        if (item.hasItemMeta())
            displayname = item.getItemMeta().getDisplayName();

        if (item.hasItemMeta()) {
            for (final ItemFlag f : item.getItemMeta().getItemFlags()) {
                this.flags.add(f);
            }
        }

        lore = item.getItemMeta().getLore();
//        if (item.getType() == Material.ENCHANTED_BOOK) {
//            EnchantmentStorageMeta enchantMeta = (EnchantmentStorageMeta) item.getItemMeta();
//            enchantments = enchantMeta.getStoredEnchants();
//        }
    }

    public ItemBuilder amount(int amount) {
        if (((amount > material.getMaxStackSize()) || (amount <= 0)) && (!unsafeStackSize))
            amount = 1;
        this.amount = amount;
        return this;
    }

    public ItemBuilder data(MaterialData data) {
//        Validate.notNull(data, "The Data is null.");
        this.data = data;
        return this;
    }

    @Deprecated
    public ItemBuilder damage(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder durability(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder flag(final ItemFlag flag) {
//        Validate.notNull((Object) flag, "The Flag is null.");
        this.flags.add(flag);
        return this;
    }

    public ItemBuilder flag(final List<ItemFlag> flags) {
//        Validate.notNull((Object) flags, "The Flags are null.");
        this.flags = flags;
        return this;
    }

    public ItemBuilder enchant(Enchantment enchant, int level) {
//        Validate.notNull(enchant, "The Enchantment is null.");
        enchantments.put(enchant, Integer.valueOf(level));
        return this;
    }

    public ItemBuilder enchant(Map<Enchantment, Integer> enchantments) {
//        Validate.notNull(enchantments, "The Enchantments are null.");
        this.enchantments = enchantments;
        return this;
    }

    public ItemStack build() {
        item.setType(material);
        item.setAmount(amount);
        item.setDurability(damage);
        meta = item.getItemMeta();

        if (data != null) {
            item.setData(data);
        }
        if (displayname != null) {
            meta.setDisplayName(displayname);
        }
        if ((lore != null) && (lore.size() > 0)) {
            meta.setLore(lore);
        }

        if (this.flags.size() > 0) {
            for (final ItemFlag f : this.flags) {
                this.meta.addItemFlags(new ItemFlag[]{f});
            }
        }

        item.setItemMeta(meta);
//        if (enchantments.size() > 0) {
//            if (material == Material.ENCHANTED_BOOK) {
//                meta = item.getItemMeta();
//                EnchantmentStorageMeta enchantMeta = (EnchantmentStorageMeta) meta;
//                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
//                    enchantMeta.addStoredEnchant(entry.getKey(), entry.getValue().intValue(),
//                            true);
//                }
//                item.setItemMeta(enchantMeta);
//            } else {
//                item.addUnsafeEnchantments(enchantments);
//            }
//        }
        return item;
    }
    @SuppressWarnings("deprecation")
    public ItemBuilder dye(DyeColor color) {
        damage = color.getDyeData();
        return this;
    }

    public ItemBuilder material(Material material) {
//        Validate.notNull(material, "The Material is null.");
        this.material = material;
        return this;
    }

    public ItemBuilder meta(ItemMeta meta) {
        if (meta == null)
            return this;
        this.meta = meta;
        return this;
    }

    public ItemBuilder displayname(String displayname) {
//        Validate.notNull(displayname, "The Displayname is null.");
        this.displayname = (andSymbol ? ChatColor.translateAlternateColorCodes('&', displayname) : displayname);
        return this;
    }

    public ItemBuilder lore(String line) {
//        Validate.notNull(line, "The Line is null.");

        if (lore == null) {
            lore = Lists.newArrayList();
        }

        lore.add(andSymbol ? ChatColor.translateAlternateColorCodes('&', line) : line);
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
//        Validate.notNull(lore, "The Lores are null.");
        this.lore = lore;
        return this;
    }

    @Deprecated
    public ItemBuilder lores(String... lines) {
//        Validate.notNull(lines, "The Lines are null.");
        for (String line : lines) {
            lore(andSymbol ? ChatColor.translateAlternateColorCodes('&', line) : line);
        }
        return this;
    }

    public ItemBuilder lore(String... lines) {
//        Validate.notNull(lines, "The Lines are null.");
        for (String line : lines) {
            lore(andSymbol ? ChatColor.translateAlternateColorCodes('&', line) : line);
        }
        return this;
    }

    public ItemBuilder lore(String line, int index) {
//        Validate.notNull(line, "The Line is null.");
        lore.set(index, andSymbol ? ChatColor.translateAlternateColorCodes('&', line) : line);
        return this;
    }

    @Deprecated
    public ItemBuilder replaceAndSymbol() {
        replaceAndSymbol(!andSymbol);
        return this;
    }

    public ItemBuilder replaceAndSymbol(boolean replace) {
        andSymbol = replace;
        return this;
    }

    public ItemBuilder toggleReplaceAndSymbol() {
        replaceAndSymbol(!andSymbol);
        return this;
    }

//    public ItemBuilder setPotionType(final PotionType potionType) {
//        final PotionMeta meta = (PotionMeta) this.item.getItemMeta();
//        final PotionData potionData = new PotionData(potionType, true, false);
//        meta.setBasePotionData(potionData);
//        this.meta(meta);
//        return this;
//    }

    public ItemBuilder unsafeStackSize(boolean allow) {
        unsafeStackSize = allow;
        return this;
    }

    public ItemBuilder toggleUnsafeStackSize() {
        unsafeStackSize(!unsafeStackSize);
        return this;
    }

    public String getDisplayname() {
        return displayname;
    }

    public int getAmount() {
        return amount;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    @Deprecated
    public short getDamage() {
        return damage;
    }

    public short getDurability() {
        return damage;
    }

    public List<String> getLores() {
        return lore;
    }

    public boolean getAndSymbol() {
        return andSymbol;
    }

    public Material getMaterial() {
        return material;
    }

//    public ItemBuilder getTag(Consumer<NBTTagCompound> consumer) {
//        net.minecraft.server.v1_12_R1.ItemStack itemStackNMS = CraftItemStack.asNMSCopy(this.item);
//        NBTTagCompound nbtTagCompound = itemStackNMS.hasTag() ? itemStackNMS.getTag() : new NBTTagCompound();
//        consumer.accept(nbtTagCompound);
//        itemStackNMS.setTag(nbtTagCompound);
//        this.item = CraftItemStack.asBukkitCopy(itemStackNMS);
//        return this;
//    }

    public ItemMeta getMeta() {
        return meta;
    }

    public MaterialData getData() {
        return data;
    }

    @Deprecated
    public List<String> getLore() {
        return lore;
    }
}
