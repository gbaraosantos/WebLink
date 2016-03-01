package com.weblink.core.dao.verification_token_dao;


import com.weblink.core.models.relational.User;
import com.weblink.core.models.relational.VerificationToken;

import java.util.List;

public interface VerificationTokenDao {
    List<VerificationToken> getVerificationToken(User user);
    List<VerificationToken> getVerificationToken(String string);
    void addVerificationToken(VerificationToken token);
}
