package com.weblink.core.dao.certificate_management_dao;

import com.weblink.core.models.CertificateRequest;
import com.weblink.core.models.ModulePerAction;

import java.util.List;


public interface CertificateManagementDao {
    void addCertificateRequest(CertificateRequest certificateRequest);
    void removeCertificateRequest(CertificateRequest certificateRequest);
    List<CertificateRequest> getCertificateRequest(int id);
    List<CertificateRequest> getCertificateRequests();
}
