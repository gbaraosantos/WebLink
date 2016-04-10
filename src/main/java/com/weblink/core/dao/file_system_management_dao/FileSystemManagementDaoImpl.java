package com.weblink.core.dao.file_system_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.Action;
import com.weblink.core.models.Material;
import com.weblink.core.models.Module;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("fileSystemManagementDao")
public class FileSystemManagementDaoImpl extends AbstractDao<Integer,Material> implements FileSystemManagementDao{

    @Override
    public int addFile(Material material) {
        save(material);
        return material.getId();
    }

    @Override
    public void removeFile(Material material) {
        delete(material);
    }

    @Override
    public List<Material> getFile(int id) {
        Query query = getSession().createQuery("FROM Material AS m WHERE m.id = :id");
        query.setParameter("id", id);
        return (List<Material>)query.list();

    }

    @Override
    public List<Material> getFileList(Module module) {
        Query query = getSession().createQuery("FROM Material AS m WHERE m.module = :module");
        query.setParameter("module", module);
        return (List<Material>)query.list();

    }

    @Override
    public void updateMaterial(Material material) {
        update(material);
    }
}
