package com.weblink.core.services.module_action_management_service;

import com.weblink.core.models.Action;
import com.weblink.core.models.Module;
import com.weblink.core.models.ModulePerAction;
import com.weblink.core.models.Teacher;

import java.util.List;

public interface ModuleActionManagementService {
    void addModulePerAction(Module module, Action action);
    void addModulePerAction(ModulePerAction modulePerAction);
    void updateModulePerAction(ModulePerAction modulePerAction);
    List<ModulePerAction> getMpa(Action action);
    List<Teacher> getTeacherList(Action a);
}
