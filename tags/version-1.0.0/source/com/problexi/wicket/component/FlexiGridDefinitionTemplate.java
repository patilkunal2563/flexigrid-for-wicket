package com.problexi.wicket.component;

import org.apache.wicket.util.template.PackageTextTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Flexigrid Definition Template.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
final class FlexiGridDefinitionTemplate extends PackageTextTemplate {
    /**
     * Grid's Definition.
     *
     * @since 1.0.0
     */
    private final FlexiGridDefinitionJavaScriptAdapter gridDefinition;

    /**
     * Default Constructor.
     *
     * @param gridDefinition A grid's definition.
     * @since 1.0.0
     */
    public FlexiGridDefinitionTemplate(FlexiGridDefinitionJavaScriptAdapter gridDefinition) {
        // Invoke Parent Constructor.
        //
        // Respects Apache Wicket's API recommendation.
        super(FlexiGridDefinitionTemplate.class, "FlexiGridDefinition.js", "text/javascript");

        this.gridDefinition = gridDefinition;
    }

    /**
     * Get Template's String Representation.
     *
     * @return The template's string representation.
     * @since 1.0.0
     */
    @Override
    public String asString() {
        Map<String, CharSequence> templateVariables = this.helpCreateTemplateVariables();
        return super.asString(templateVariables);
    }

    /**
     * Help Create Template's Variables.
     *
     * @return A map of the template's variables.
     * @since 1.0.0
     */
    private Map<String, CharSequence> helpCreateTemplateVariables() {
        Map<String, CharSequence> templateVariables = new HashMap<String, CharSequence>(1);
        String gridDefinitionJson = this.gridDefinition.toJSON();

        templateVariables.put("GridDefinition", gridDefinitionJson);
        return templateVariables;
    }
}