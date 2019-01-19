package org.rp.sandboxmvc.helper;

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
