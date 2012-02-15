package com.problexi.wicket.component;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Flexigrid Row.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public final class FlexiGridRow implements Serializable {
    /**
     * Row's Column Values.
     */
    @SerializedName("cell")
    private final Object[] columnValues;
    /**
     * Row's Unique Identifier.
     */
    @SerializedName("id")
    private final Object id;

    /**
     * Default Constructor.
     *
     * @param id           A unique identifier.
     * @param columnValues A collection of column values.
     * @since 1.0.0
     */
    public FlexiGridRow(Object id, Object... columnValues) {
        this.id = id;
        this.columnValues = columnValues;
    }

    /**
     * Get Row's Column Values.
     *
     * @return A collection of the row's column values.
     * @since 1.0.0
     */
    public Object[] getColumnValues() {
        return this.columnValues;
    }

    /**
     * Get Row's Unique Identifier.
     *
     * @return The row's unique identifier.
     * @since 1.0.0
     */
    public Object getId() {
        return this.id;
    }
}