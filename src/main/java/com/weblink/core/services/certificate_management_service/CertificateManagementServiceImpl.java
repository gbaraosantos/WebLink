package com.weblink.core.services.certificate_management_service;

import com.weblink.core.dao.certificate_management_dao.CertificateManagementDao;
import com.weblink.core.models.CertificateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("certificateRequestManagementService")
public class CertificateManagementServiceImpl implements CertificateManagementService{
    @Autowired CertificateManagementDao certificateManagementDao;

    @Override
    public void addCertificateRequest(CertificateRequest certificateRequest) {
        certificateManagementDao.addCertificateRequest(certificateRequest);
    }

    @Override
    public List<CertificateRequest> getCertificates() {
        return certificateManagementDao.getCertificateRequests();
    }

    @Override
    public void removeCertificate(CertificateRequest certificateRequest) {
        certificateManagementDao.removeCertificateRequest(certificateRequest);
    }

    @Override
    public CertificateRequest getCertificate(int id) {
        List<CertificateRequest> list = certificateManagementDao.getCertificateRequest(id);
        if(list==null || list.size() <= 0) return null;
        return list.get(0);
    }
}
