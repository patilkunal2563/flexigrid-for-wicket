function toButtons(buttonDefinitions) {
    jQuery.each(buttonDefinitions, function (index, value) {
        value.onpress = eval(value.onpress);
    });

    return buttonDefinitions;
}

function toColumns(columnDefinitions) {
    var columns = columnDefinitions.length != 0 ? new Array() : null;
    jQuery.each(columnDefinitions, function (index, value) {
        var column = new Object();
        column.display = value.name;
        column.name = value.id;
        column.sortable = value.isSortable;
        column.width = value.width;

        columns[index] = column;
    });

    return columns;
}

function toSearchItems(searchItemDefinitions) {
    var searchItems = searchItemDefinitions.length != 0 ? new Array() : null;
    jQuery.each(searchItemDefinitions, function (index, value) {
        var searchItem = new Object();
        searchItem.display = value.name;
        searchItem.name = value.id;

        searchItems[index] = searchItem;
    });

    return searchItems;
}