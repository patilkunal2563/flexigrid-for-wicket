package com.problexi.wicket.component;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Flexigrid Column.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public final class FlexiGridColumn implements Serializable {
    /**
     * Column's Alignment.
     *
     * @since 1.0.0
     */
    @SerializedName("align")
    private String alignment;
    /**
     * Column's Unique Identifier.
     *
     * @since 1.0.0
     */
    @SerializedName("name")
    private String id;
    /**
     * Column Sortable Flag.
     *
     * @since 1.0.0
     */
    @SerializedName("sortable")
    private boolean isSortable;
    /**
     * Column's Name.
     *
     * @since 1.0.0
     */
    @SerializedName("display")
    private String name;
    /**
     * Column's Width.
     *
     * @since 1.0.0
     */
    @SerializedName("width")
    private int width;

    /**
     * Get Column's Alignment.
     *
     * @return The column's alignment.
     * @since 1.0.0
     */
    public final String getAlignment() {
        return this.alignment;
    }

    /**
     * Get Column's Unique Identifier.
     *
     * @return The column's unique identifier.
     * @since 1.0.0
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Get Column's Name.
     *
     * @return The column's name.
     * @since 1.0.0
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Get Column's Width.
     *
     * @return The column's width.
     * @since 1.0.0
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * Determine if Column is Sortable.
     *
     * @return A boolean true if the the column is sortable. A boolean false otherwise.
     * @since 1.0.0
     */
    public final boolean isSortable() {
        return this.isSortable;
    }

    /**
     * Set Column's Alignment.
     *
     * @param alignment An alignment.
     * @return The column.
     * @since 1.0.0
     */
    public final FlexiGridColumn setAlignment(String alignment) {
        this.alignment = alignment;
        return this;
    }

    /**
     * Set Column's Unique Identifier..
     *
     * @param id A unique identifier.
     * @return The column.
     * @since 1.0.0
     */
    public final FlexiGridColumn setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Set Column's Name.
     *
     * @param name A name.
     * @return The column.
     * @since 1.0.0
     */
    public final FlexiGridColumn setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Set Column's Sortable Flag.
     *
     * @param flag A flag.
     * @return The column.
     * @since 1.0.0
     */
    public final FlexiGridColumn setSortable(boolean flag) {
        this.isSortable = flag;
        return this;
    }

    /**
     * Set Column's Width.
     *
     * @param width A width.
     * @return The column.
     * @since 1.0.0
     */
    public final FlexiGridColumn setWidth(int width) {
        this.width = width;
        return this;
    }
}