package com.problexi.wicket.component;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Flexigrid Behavior.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
final class FlexiGridBehavior extends AbstractAjaxBehavior {
    /**
     * Bind Event Handler.
     *
     * @throws WicketRuntimeException Thrown if the bound component is not a flexigrid component.
     * @since 1.0.0
     */
    @Override
    protected void onBind() {
        Component component = this.getComponent();
        if (!(component instanceof FlexiGrid)) {
            String detailMessgae = "Behavior should be bound to a flexigrid component.";
            throw new WicketRuntimeException(detailMessgae);
        }
    }

    /**
     * Get Grid.
     *
     * @return The grid.
     * @since 1.0.0
     */
    public FlexiGrid getGrid() {
        // Typecast Bound Component.
        //
        // The bound component is ensured to be a flexigrid component when the behavior is bound to it so this
        // is a safe operation.
        return (FlexiGrid) this.getComponent();
    }

    /**
     * Request Event Handler.
     *
     * @since 1.0.0
     */
    @Override
    public void onRequest() {
        FlexiGridRequest request = FlexiGridRequestBuilder.newInstance().getRequest();
        FlexiGridRow[] rows = this.getGrid().onLoadRows(request);
        int totalRows = this.getGrid().onLoadRowCount(request);

        int pageNumber = request.getPageNumber();
        FlexiGridDataJavaScriptAdapter gridData = new FlexiGridDataJavaScriptAdapter(pageNumber, totalRows, rows);

        FlexiGridRequestHandler requestHandler = new FlexiGridRequestHandler(gridData);
        RequestCycle.get().scheduleRequestHandlerAfterCurrent(requestHandler);
    }

    /**
     * Render Header Event Handler.
     *
     * @param component      A component.
     * @param headerResponse A header response.
     * @since 1.0.0
     */
    @Override
    public void renderHead(Component component, IHeaderResponse headerResponse) {
        // Invoke Parent Method.
        //
        // Respects Apache Wicket's API recommendation.
        super.renderHead(component, headerResponse);

        // Render Definition Utilities.
        ResourceReference definitionUtilities = FlexiGridResource.getDefinitionUtilities();
        headerResponse.renderJavaScriptReference(definitionUtilities);

        // Render Definition Template.
        String componentId = component.getId();
        FlexiGridDefinitionJavaScriptAdapter gridDefinition = new FlexiGridDefinitionJavaScriptAdapter(this);
        FlexiGridDefinitionTemplate definitionTemplate = new FlexiGridDefinitionTemplate(gridDefinition);
        String definitionTemplateString = definitionTemplate.asString();
        headerResponse.renderJavaScript(definitionTemplateString, componentId);
    }
}