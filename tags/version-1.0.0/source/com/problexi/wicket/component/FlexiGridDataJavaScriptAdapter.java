package com.problexi.wicket.component;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Flexigrid Data JavaScript Adapter.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
final class FlexiGridDataJavaScriptAdapter implements Serializable {
    /**
     * Data's Page Number.
     *
     * @since 1.0.0
     */
    @SerializedName("page")
    private final int pageNumber;
    /**
     * Data's Rows.
     *
     * @since 1.0.0
     */
    @SerializedName("rows")
    private final FlexiGridRow[] gridRows;
    /**
     * Data's Total Rows.
     *
     * @since 1.0.0
     */
    @SerializedName("total")
    private final int totalRows;

    /**
     * Default Constructor.
     *
     * @param pageNumber A page number.
     * @param totalRows  A total number of rows.
     * @param gridRows   A collection of rows.
     * @since 1.0.0
     */
    public FlexiGridDataJavaScriptAdapter(int pageNumber, int totalRows, FlexiGridRow[] gridRows) {
        this.pageNumber = pageNumber;
        this.totalRows = totalRows;
        this.gridRows = gridRows;
    }

    /**
     * Serialize Grid Data to JSON.
     *
     * @return The grid's data serialized to JSON.
     * @since 1.0.0
     */
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}