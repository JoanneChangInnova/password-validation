package com.joanne.validation.common.model;

import com.joanne.validation.common.enums.InputType;

/**
 *
 * A class encapsulates the data required for validation
 *
 */
public class Input {

    public Input(InputType type, String value) {
        this.type = type;
        this.value = value;
    }

    private InputType type;

    private String value;

    public InputType getType() {
        return type;
    }

    public void setType(InputType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
