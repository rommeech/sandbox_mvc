package org.rp.sandboxmvc.model;

import org.rp.sandboxmvc.helper.JspListPompatibleItem;

public enum Status implements JspListPompatibleItem<String, String> {
    NEW, ACTIVE, DISABLED;

    @Override
    public String getItemValue() {
        return name();
    }

    @Override
    public String getItemLabel() {
        return name();
    }
}
