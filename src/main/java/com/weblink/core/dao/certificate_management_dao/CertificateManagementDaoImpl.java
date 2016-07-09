package com.weblink.core.dao.certificate_management_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.CertificateRequest;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("certificateRequestManagementDao")
public class CertificateManagementDaoImpl extends AbstractDao<Integer, CertificateRequest> implements CertificateManagementDao {

    @Override
    public void addCertificateRequest(CertificateRequest certificateRequest) {
        persist(certificateRequest);
    }

    @Override
    public void removeCertificateRequest(CertificateRequest certificateRequest) {
        delete(certificateRequest);
    }

    @Override
    public List<CertificateRequest> getCertificateRequest(int id) {
        Query query = getSession().createQuery("FROM CertificateRequest AS c WHERE c.id = :id");
        query.setParameter("id", id);
        return (List<CertificateRequest>)query.list();
    }

    @Override
    public List<CertificateRequest> getCertificateRequests() {
        Query query = getSession().createQuery("FROM CertificateRequest AS c");
        return (List<CertificateRequest>)query.list();
    }
}
