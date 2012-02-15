package com.problexi.wicket.component;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Flexigrid Search Item.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public final class FlexiGridSearchItem implements Serializable {
    /**
     * Search Item's Unique Identifier.
     *
     * @since 1.0.0
     */
    @SerializedName("name")
    private String id;
    /**
     * Search Item's Default Flag.
     *
     * @since 1.0.0
     */
    @SerializedName("isdefault")
    private boolean isDefault;
    /**
     * Search Item's Name.
     *
     * @since 1.0.0
     */
    @SerializedName("display")
    private String name;

    /**
     * Get Search Item's Unique Identifier.
     *
     * @return The search item's unique identifier.
     * @since 1.0.0
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Get Search Item's Name.
     *
     * @return The search item's name.
     * @since 1.0.0
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Determine if Search Item is Default.
     *
     * @return A boolean true if the search item is default. A boolean false otherwise.
     * @since 1.0.0
     */
    public final boolean isDefault() {
        return this.isDefault;
    }

    /**
     * Set Search Item's Default Flag.
     *
     * @param flag A flag.
     * @return The search item.
     * @since 1.0.0
     */
    public final FlexiGridSearchItem setDefault(boolean flag) {
        this.isDefault = flag;
        return this;
    }

    /**
     * Set Column's Unique Identifier..
     *
     * @param id A unique identifier.
     * @return The search item.
     * @since 1.0.0
     */
    public final FlexiGridSearchItem setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Set Column's Name.
     *
     * @param name A name.
     * @return The search item.
     * @since 1.0.0
     */
    public final FlexiGridSearchItem setName(String name) {
        this.name = name;
        return this;
    }
}