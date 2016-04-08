package com.weblink.core.common.other;

import com.weblink.core.models.ModulePerAction;

import java.util.Comparator;


public class ModuleDateComparator implements Comparator<ModulePerAction> {
    @Override
    public int compare(ModulePerAction o1, ModulePerAction o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
