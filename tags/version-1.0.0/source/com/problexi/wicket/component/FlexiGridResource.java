package com.problexi.wicket.component;

import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Flexigrid Resource.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
final class FlexiGridResource {
    /**
     * Definition Utilities Resource.
     *
     * @since 1.0.0
     */
    private static ResourceReference definitionUtilities;

    /**
     * Get Definition Utilities Resource.
     *
     * @return A initialization utilities resource.
     * @since 1.0.0
     */
    public static synchronized ResourceReference getDefinitionUtilities() {
        if (FlexiGridResource.definitionUtilities == null) {
            Class<FlexiGridResource> clazz = FlexiGridResource.class;
            String name = "FlexiGridDefinitionUtilities.js";

            FlexiGridResource.definitionUtilities = new JavaScriptResourceReference(clazz, name);
        }

        return FlexiGridResource.definitionUtilities;
    }
}