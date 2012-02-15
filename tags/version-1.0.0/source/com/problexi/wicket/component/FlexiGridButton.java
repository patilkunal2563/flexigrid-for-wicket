package com.problexi.wicket.component;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Flexigrid Button.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public final class FlexiGridButton implements Serializable {
    /**
     * Button's JavaScript Callback Function.
     *
     * @since 1.0.0
     */
    @SerializedName("onpress")
    private String callbackFunction;
    /**
     * Button Item's Name.
     *
     * @since 1.0.0
     */
    @SerializedName("name")
    private String name;

    /**
     * Get Button's JavaScript Callback Function.
     *
     * @return The button's JavaScript callback function.
     * @since 1.0.0
     */
    public final String getCallbackFunction() {
        return this.callbackFunction;
    }

    /**
     * Get Button's Name.
     *
     * @return The button's name.
     * @since 1.0.0
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Determine if Button's JavaScript Callback Function is Set.
     *
     * @return A boolean true if the button's javascript callback function is set. A boolean false otherwise.
     * @since 1.0.0
     */
    public final boolean isCallbackFunctionSet() {
        return this.callbackFunction != null;
    }

    /**
     * Set Button's JavaScript Callback Function.
     *
     * @param callbackFunction A JavaScript callback function.
     * @return The button.
     * @since 1.0.0
     */
    public final FlexiGridButton setCallbackFunction(String callbackFunction) {
        this.callbackFunction = callbackFunction;
        return this;
    }

    /**
     * Set Button's Name.
     *
     * @param name A name.
     * @return The button.
     * @since 1.0.0
     */
    public final FlexiGridButton setName(String name) {
        this.name = name;
        return this;
    }
}