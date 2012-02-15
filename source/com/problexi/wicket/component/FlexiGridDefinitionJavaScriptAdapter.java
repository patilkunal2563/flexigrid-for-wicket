package com.problexi.wicket.component;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Flexigrid Definition JavaScript Adapter.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
final class FlexiGridDefinitionJavaScriptAdapter implements Serializable {
    /**
     * Grid's Button Definitions.
     *
     * @since 1.0.0
     */
    private final FlexiGridButton[] buttons;
    /**
     * Grid's Callback URL.
     *
     * @since 1.0.0
     */
    private final CharSequence callbackUrl;
    /**
     * Grid's Column Definitions.
     *
     * @since 1.0.0
     */
    private final FlexiGridColumn[] columns;
    /**
     * Grid's Data Type.
     *
     * @since 1.0.0
     */
    private final String dataType;
    /**
     * Grid's Height.
     *
     * @since 1.0.0
     */
    private final int height;
    /**
     * Grid's Unique Identifier.
     *
     * @since 1.0.0
     */
    private final String id;
    /**
     * Grid's Search Item Definitions.
     *
     * @since 1.0.0
     */
    private final FlexiGridSearchItem[] searchItems;
    /**
     * Grid's Title.
     *
     * @since 1.0.0
     */
    private final String title;
    /**
     * Grid's Width.
     *
     * @since 1.0.0
     */
    private final int width;

    /**
     * Default Constructor.
     *
     * @param gridBehavior A flexigrid behavior.
     * @since 1.0.0
     */
    public FlexiGridDefinitionJavaScriptAdapter(FlexiGridBehavior gridBehavior) {
        // Developer Note.
        //
        // January 19, 2012.
        //
        // Developers might wonder why on God's earth are the given grid behavior's properties being referenced
        // again here as properties, as opposed to referencing the given grid behavior directly.
        //
        // Short and dirty answer is because we do not want to serialize the given grid behavior along with its entire
        // object graph.

        this.buttons = gridBehavior.getGrid().getButtons();
        this.callbackUrl = gridBehavior.getCallbackUrl();
        this.columns = gridBehavior.getGrid().getColumns();
        this.dataType = "json";
        this.height = gridBehavior.getGrid().getHeight();
        this.id = gridBehavior.getGrid().getId();
        this.searchItems = gridBehavior.getGrid().getSearchItems();
        this.title = gridBehavior.getGrid().getTitle();
        this.width = gridBehavior.getGrid().getWidth();
    }

    /**
     * Serialize Grid Definition to JSON.
     *
     * @return The grid's definition serialized to JSON.
     * @since 1.0.0
     */
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
