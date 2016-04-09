package com.weblink.core.services.teacher_management_service;

import com.weblink.core.dao.user_management_dao.TeacherManagementDao;
import com.weblink.core.dao.user_management_dao.UserManagementDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Teacher;
import com.weblink.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teacherManagementService")
@Transactional
public class TeacherManagementServiceImpl implements TeacherManagementService{
    @Autowired TeacherManagementDao teacherManagementDao;


    @Override
    public void addTeacher(Teacher teacher) {
        teacherManagementDao.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacher(int id) {
        List<Teacher> teacherList = teacherManagementDao.getTeacher(id);
        if(teacherList==null || teacherList.size() <= 0) return null;
        return teacherList.get(0);
    }

    @Override
    public void deleteTeacher(Teacher teach) {
        teacherManagementDao.deleteTeacher(teach);
    }

    @Override
    public List<Action> getTeaching(User user) {
        List<Action> list = teacherManagementDao.getTeaching(user);
        if(list==null || list.size() <= 0) return null;
        return list;
    }
}
