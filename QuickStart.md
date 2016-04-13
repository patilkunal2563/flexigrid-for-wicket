# Quick Start #


---


## Overview ##
Creating a Flexigrid from an Apache Wicket application is extremely easy using Flexigrid for Wicket. There is no need
to extend the Wicket application from a custom class or configure any run-time parameters. Furthermore, familiarity
with Flexigrid's Javascript API is not necessary since Flexigrid for Wicket takes care of reading requests and writing
responses to and from Flexigrid under the hood.

A grid is defined by the abstract **FlexiGrid** class, which itself is a standard Wicket component. To create a grid,
**FlexiGrid** has to be extended and the 2 abstract methods it defines must be implemented by the child class.
Developers experienced with Wicket will note that this approach is not unlike regular everyday Wicket development.

In addition, **FlexiGrid** also defines several methods to configure a grid. These methods can be invoked at any time
during the lifetime of the component but it is recommended that they are invoked when Wicket initializes the
component, quite preferably in the **Component.onInitialize()** or **Component.onConfigure()** methods.

## Referencing Flexigrid and jQuery JavaScript Files ##
Even though the distributable of Flexigrid for Wicket includes the JavaScript for both Flexigrid and jQuery, they
are not loaded automatically when the component is added to a Wicket page! This is to prevent possible conflicts in
cases where either of them, particularly jQuery, are already used by a Wicket application.

Be sure to reference both of these JavaScript files, as well as any needed CSS files, in all Wicket pages that the
component will be added to.

## Creating a Grid ##
To create a grid, extend **FlexiGrid**, configure the columns that make it up, and implement the 2 abstract methods it
defines, **FlexiGrid.onLoadRowCount(FlexiGridRequest) and**onLoadRows(FlexiGridRequest)**. A note of the component's ID
is important to allow the grid to be created on the client side.**

### Taking Note of a Grid's Wicket ID ###
A component's Wicket ID is used to by Wicket to match/associate Java code to HTML markup. Flexigrid for Wicket passes
that same ID to Flexigrid on the client side to create the grid.

The consequence of this is that the component, when defined in the HTML markup, must have an _id_ attribute set with
the same value as the component's Wicket ID. Here is an example:

```
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns:wicket="http://www.w3.org/1999/xhtml">
    <table wicket:id="WICKET_COMPONENT_ID" id="WICKET_COMPONENT_ID"></table>
</html>
```

In the above example, a grid is defined in HTML markup as a _table_ element. Notice that both its Wicket ID and HTML
_id_ attribute match. This is important otherwise the grid will never be rendered!

### Adding Columns to a Grid ###
A grid's column is defined by the **FlexiGridColumn** class. **FlexiGrid** defines the **addColumn** and **setColumns**
methods, which can be used to add **FlexiGridColumn** objects for each column that will make up the grid. These methods
need be invoked when Wicket initializes the component, quite preferably in the **Component.onInitialize()** or
**Component.onConfigure()** methods. Here is an example:

```
@Override
protected void onInitialize() {
    // Invoke Parent Method.
    //
    // Respects Apache Wicket's API recommendation.
    super.onInitialize();

    // Set Grid's Columns.
    //
    // At the very least, a grid's columns must be set. These are the columns that will make up the grid when it
    // is rendered. Columns need to be added in the same order they will be rendered!
    this.setColumns(
        new FlexiGridColumn()
            .setId("COUNTRY") // Column's ID. Sent in the request when sorting/ordering is specified.
            .setName("Country Name") // Column's display name.
            .setSortable(true), // Indicates column can be sorted on
        new FlexiGridColumn()
            .setId("Region")
            .setName("Region Name")
            .setSortable(false)
    );
}
```

### Implementing the FlexiGrid.onLoadRowCount(FlexiGridRequest) Method ###
The **FlexiGrid.onLoadRowCount(FlexiGridRequest)** method is invoked automatically when Flexigrid sends a request to
determine the total number of records a grid will display. Typically this is used by Flexigrid to help set up a grid's
pagination. The **FlexiGridRequest** object passed as a parameter encapsulates Flexigrid's request.

Returning _0_ to indicate that there are no records is acceptable. But returning a value less than _0_ might result in
incorrect or undefined behavior. Here is an example, which assumes an injected service is used. Actual mileage may
vary:

```
@Override
public int onLoadRowCount(FlexiGridRequest gridRequest) {
    // Request Has a Filter Set
    //
    // This means a search was requested!
    if(gridRequest.isFilterSet()) {
        IFilter filter = gridRequest.getFilter();
        filter.getOperator(); // "=", "LIKE", "<", etc
        filter.getValue(); // Search Value
        filter.getIdentifier(); // Search Item's ID

        // .. Do Something with Filter!
    }

    // Request Has an Order Set
    //
    // This means a sort on a column was requested!
    if(gridRequest.isOrderSet()) {
        IOrder order = gridRequest.getOrder();
        order.getDirection(); // Ascending or Descending
        order.getIdentifier() // Columns' ID

        // .. Do Something with Order!
    }

    int pageNumber = gridRequest.getPageNumber(); // Requested Page
    ILimit limit = gridRequest.getLimit();
    limit.getLowerBound(); // Number of Rows To Skip For Requested Page
    limit.getUpperBound(); // Number of Rows to Pull For Requested Page

    // .. Do Something with Page Number and/or Limit!

    // ... Dummy Service!
    List<Location> locations = this.systemService.getAllLocations();
    int nLocations = locations.size();

    return nLocations;
}
```

### Implementing the FlexiGrid.onLoadRows(FlexiGridRequest) Method ###
The **FlexiGrid.onLoadRows(FlexiGridRequest)** method is invoked automatically when Flexigrid sends a request to load
data. The **FlexiGridRequest** object passed as a parameter encapsulates Flexigrid's request.

Returning an empty collection to indicate that there are no records is acceptable. But returning a Null Reference
might result in incorrect or undefined behavior. Here is an example, which assumes an injected service is used. Actual
mileage may vary:

```
@Override
public FlexiGridRow[] onLoadRows(FlexiGridRequest request) {
    // ... Do Something With Given Request!

    // ... Dummy Service!
    List<Location> locations = this.systemService.getAllLocations();
    int nLocations = locations.size();

    FlexiGridRow[] gridRows = new FlexiGridRow[nLocations];
    for (int i = 0; i < nLocations; i++) {
        Location location = locations.get(i);

        // ... Dummy Model Calls!
        String locationId = location.getId();
        String countryName = location.getCountryName();
        String regionName = location.getRegionName();

        // Create Row.
        //
        // First argument is the row's ID. Remaining arguments are the row's column values, 1 argument for
        // each column. So in this example, the row has 2 column values!
        gridRows[i] = new FlexiGridRow(locationId, countryName, regionName);
    }

    return gridRows;
}
```

### Configuring a Grid ###
**FlexiGrid** defines several methods to configure a grid. These methods can be invoked at any time during the lifetime
of the component but it is recommended that they are invoked when Wicket initializes the component, quite preferably
in the **Component.onInitialize()** or **Component.onConfigure()** methods. Here is an example:

```
@Override
protected void onInitialize() {
    // Invoke Parent Method.
    //
    // Respects Apache Wicket's API recommendation.
    super.onInitialize();

    // ... Set Grid's Columns!

    // Add a Delete Row Button.
    this.addButton(
        new FlexiGridButton()
            .setCallbackFunction("deleteRow") // JavaScript callback function to invoke when button is clicked.
            .setName("Delete Selected Record") // Button's display name.
    );

    // Add a Search Item.
    this.addSearchItem(
        new FlexiGridSearchItem()
            .setId("COUNTRY")  // Search item's ID. Sent in the request when searching/filtering is specified.
            .setName("Search by Country") // Search item's display name.
    );

    this.setTitle("Locations Grid"); // Grid's display title.
}
```

## Further Reading ##
  * Explore the [API Documentation](http://flexigrid-for-wicket.googlecode.com/svn/documentation/index.html)
  * Check out [Flexigrid](http://code.google.com/p/flexigrid)
  * Check out [Apache Wicket](http://wicket.apache.org/)
  * Check out the [Problexi Common DAO Library](https://code.google.com/p/problexi-common-dao-library)