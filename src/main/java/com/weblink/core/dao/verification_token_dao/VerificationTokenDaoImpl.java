package com.weblink.core.dao.verification_token_dao;

import com.weblink.core.dao.AbstractDao;
import com.weblink.core.models.User;
import com.weblink.core.models.UserProfile;
import com.weblink.core.models.VerificationToken;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("verificationTokenDao")
public class VerificationTokenDaoImpl extends AbstractDao<Integer, VerificationToken> implements VerificationTokenDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<VerificationToken> getVerificationToken(User user) {
        Query query = getSession().createQuery("FROM VerificationTokens AS v WHERE v.user = :user");
        query.setParameter("user", user);
        return (List<VerificationToken>)query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VerificationToken> getVerificationToken(String string) {
        Query query = getSession().createQuery("FROM VerificationTokens AS v WHERE v.token = :token");
        query.setParameter("token", string);
        return (List<VerificationToken>)query.list();
    }

    @Override
    public void addVerificationToken(VerificationToken token) {
        persist(token);
    }
}
