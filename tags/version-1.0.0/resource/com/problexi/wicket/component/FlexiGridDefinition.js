$(document).ready(function () {
    var gridDefinitionJson = '${GridDefinition}';
    var gridDefinition = jQuery.parseJSON(gridDefinitionJson);
    var gridId = "#" + gridDefinition.id;
    $(gridId).flexigrid({
        buttons:gridDefinition.buttons.length != 0 ? toButtons(gridDefinition.buttons) : null,
        colModel:gridDefinition.columns.length != 0 ? gridDefinition.columns : null,
        dataType:gridDefinition.dataType,
        searchitems:gridDefinition.searchItems.length != 0 ? gridDefinition.searchItems : null,
        title:gridDefinition.title,
        url:gridDefinition.callbackUrl,
        resizable:false,
        usepager:true
    });
});