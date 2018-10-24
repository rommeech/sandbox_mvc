package org.rp.sandboxmvc.helper;

public interface JspListCompatibleItem<V, L> {
    V getItemValue();
    L getItemLabel();
}
