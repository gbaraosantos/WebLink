package com.weblink.core.services.certificate_management_service;

import com.weblink.core.models.CertificateRequest;

import java.util.List;


public interface CertificateManagementService {
    void addCertificateRequest(CertificateRequest certificateRequest);
    List<CertificateRequest> getCertificates();
    void removeCertificate(CertificateRequest certificateRequest);
    CertificateRequest getCertificate(int id);

}
