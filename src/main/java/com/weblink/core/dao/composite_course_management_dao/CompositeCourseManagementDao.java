package com.weblink.core.dao.composite_course_management_dao;


import com.weblink.core.models.Action;
import com.weblink.core.models.Module;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.User;

import java.util.List;

public interface CompositeCourseManagementDao {
    void addModulePerAction(ModulePerAction modulePerAction);
    void updateModulePerAction(ModulePerAction modulePerAction);
    List<ModulePerAction> getMpas(Action action);
    List<ModulePerAction> getMpas(Module module);
    void deleteModulePerAction(ModulePerAction modulePerAction);
    List<ModulePerAction> getMpa(int mpaId);

}
