package com.problexi.wicket.component;

import org.apache.wicket.markup.html.WebComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Flexigrid.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public abstract class FlexiGrid extends WebComponent {
    /**
     * Grid's Buttons.
     *
     * @since 1.0.0
     */
    private List<FlexiGridButton> buttons = new ArrayList<FlexiGridButton>(0);
    /**
     * Grid's Columns.
     *
     * @since 1.0.0
     */
    private List<FlexiGridColumn> columns = new ArrayList<FlexiGridColumn>(0);
    /**
     * Grid's Height.
     *
     * @since 1.0.0
     */
    private int height;
    /**
     * Grid's Search Items.
     *
     * @since 1.0.0
     */
    private List<FlexiGridSearchItem> searchItems = new ArrayList<FlexiGridSearchItem>(0);
    /**
     * Grid's Title.
     *
     * @since 1.0.0
     */
    private String title;
    /**
     * Grid's Width.
     *
     * @since 1.0.0
     */
    private int width;

    /**
     * Default Constructor.
     *
     * @param id A unique identifier.
     * @since 1.0.0
     */
    public FlexiGrid(String id) {
        // Invoke Parent Constructor.
        //
        // Respects Apache Wicket's API recommendation.
        super(id);
    }

    /**
     * Add a Button to Grid.
     *
     * @param button A button.
     * @see FlexiGridButton
     * @since 1.0.0
     */
    public final void addButton(FlexiGridButton button) {
        this.buttons.add(button);
    }

    /**
     * Add a Column to Grid.
     *
     * @param column A column.
     * @see FlexiGridColumn
     * @since 1.0.0
     */
    public final void addColumn(FlexiGridColumn column) {
        this.columns.add(column);
    }

    /**
     * Add a Search Item to Grid.
     *
     * @param searchItem A search item.
     * @see FlexiGridSearchItem
     * @since 1.0.0
     */
    public final void addSearchItem(FlexiGridSearchItem searchItem) {
        this.searchItems.add(searchItem);
    }

    /**
     * Get Grid's Button Definitions.
     *
     * @return The grid's collection of buttons.
     * @see FlexiGridButton
     * @since 1.0.0
     */
    public final FlexiGridButton[] getButtons() {
        int nButtonDefinitions = this.buttons.size();
        FlexiGridButton[] buttonsArray = new FlexiGridButton[nButtonDefinitions];

        return this.buttons.toArray(buttonsArray);
    }

    /**
     * Get Grid's Column Definitions.
     *
     * @return The grid's collection of columns.
     * @see FlexiGridColumn
     * @since 1.0.0
     */
    public final FlexiGridColumn[] getColumns() {
        int nColumnDefinitions = this.columns.size();
        FlexiGridColumn[] columnsArray = new FlexiGridColumn[nColumnDefinitions];

        return this.columns.toArray(columnsArray);
    }

    /**
     * Get Grid's Height.
     *
     * @return The grid's height.
     * @since 1.0.0
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * Get Grid's Search Item Definitions.
     *
     * @return The grid's collection of search items.
     * @see FlexiGridSearchItem
     * @since 1.0.0
     */
    public final FlexiGridSearchItem[] getSearchItems() {
        int nSearchItemDefinitions = this.searchItems.size();
        FlexiGridSearchItem[] searchItemsArray = new FlexiGridSearchItem[nSearchItemDefinitions];

        return this.searchItems.toArray(searchItemsArray);
    }

    /**
     * Get Grid's Title.
     *
     * @return The grid's title.
     * @since 1.0.0
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Get Grid's Width.
     *
     * @return The grid's width.
     * @since 1.0.0
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * Load Row Count Event Handler.
     *
     * @param gridRequest A request.
     * @return A total number of rows.
     * @since 1.0.0
     */
    public abstract int onLoadRowCount(FlexiGridRequest gridRequest);

    /**
     * Load Rows Event Handler.
     *
     * @param gridRequest A request.
     * @return A collection of rows.
     * @since 1.0.0
     */
    public abstract FlexiGridRow[] onLoadRows(FlexiGridRequest gridRequest);

    /**
     * Set Grid's Buttons.
     *
     * @param buttons A collection of buttons.
     * @see FlexiGridButton
     * @since 1.0.0
     */
    public final void setButtons(FlexiGridButton... buttons) {
        this.buttons = Arrays.asList(buttons);
    }

    /**
     * Set Grid's Columns.
     *
     * @param columns A collection of column.
     * @see FlexiGridColumn
     * @since 1.0.0
     */
    public final void setColumns(FlexiGridColumn... columns) {
        this.columns = Arrays.asList(columns);
    }

    /**
     * Set Grid's Height.
     *
     * @param height A height.
     * @since 1.0.0
     */
    public final void setHeight(int height) {
        this.height = height;
    }

    /**
     * Set Grid's Search Items.
     *
     * @param searchItems A collection of search items.
     * @see FlexiGridSearchItem
     * @since 1.0.0
     */
    public final void setSearchItems(FlexiGridSearchItem... searchItems) {
        this.searchItems = Arrays.asList(searchItems);
    }

    /**
     * Set Grid's Title.
     *
     * @param title A title.
     * @since 1.0.0
     */
    public final void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set Grid's Width.
     *
     * @param width A width.
     * @since 1.0.0
     */
    public final void setWidth(int width) {
        this.width = width;
    }

    /**
     * Initialization Event Handler.
     *
     * @since 1.0.0
     */
    @Override
    protected void onInitialize() {
        // Invoke Parent Method.
        //
        // Respects Apache Wicket's API recommendation.
        super.onInitialize();

        this.helpAddBehaviors();
    }

    /**
     * Help Add Behaviors.
     *
     * @since 1.0.0
     */
    private void helpAddBehaviors() {
        FlexiGridBehavior flexiGridBehavior = new FlexiGridBehavior();
        this.add(flexiGridBehavior);
    }
}