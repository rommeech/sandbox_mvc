package org.rp.sandboxmvc.model;

import org.rp.sandboxmvc.helper.JspListCompatibleItem;

public enum Status implements JspListCompatibleItem<String, String> {
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
