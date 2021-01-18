package com.xietian.graduated.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNull() {
            addCriterion("u_realName is null");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNotNull() {
            addCriterion("u_realName is not null");
            return (Criteria) this;
        }

        public Criteria andURealnameEqualTo(String value) {
            addCriterion("u_realName =", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotEqualTo(String value) {
            addCriterion("u_realName <>", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThan(String value) {
            addCriterion("u_realName >", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThanOrEqualTo(String value) {
            addCriterion("u_realName >=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThan(String value) {
            addCriterion("u_realName <", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThanOrEqualTo(String value) {
            addCriterion("u_realName <=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLike(String value) {
            addCriterion("u_realName like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotLike(String value) {
            addCriterion("u_realName not like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameIn(List<String> values) {
            addCriterion("u_realName in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotIn(List<String> values) {
            addCriterion("u_realName not in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameBetween(String value1, String value2) {
            addCriterion("u_realName between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotBetween(String value1, String value2) {
            addCriterion("u_realName not between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andUIdnumIsNull() {
            addCriterion("u_IDNUM is null");
            return (Criteria) this;
        }

        public Criteria andUIdnumIsNotNull() {
            addCriterion("u_IDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andUIdnumEqualTo(String value) {
            addCriterion("u_IDNUM =", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumNotEqualTo(String value) {
            addCriterion("u_IDNUM <>", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumGreaterThan(String value) {
            addCriterion("u_IDNUM >", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("u_IDNUM >=", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumLessThan(String value) {
            addCriterion("u_IDNUM <", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumLessThanOrEqualTo(String value) {
            addCriterion("u_IDNUM <=", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumLike(String value) {
            addCriterion("u_IDNUM like", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumNotLike(String value) {
            addCriterion("u_IDNUM not like", value, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumIn(List<String> values) {
            addCriterion("u_IDNUM in", values, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumNotIn(List<String> values) {
            addCriterion("u_IDNUM not in", values, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumBetween(String value1, String value2) {
            addCriterion("u_IDNUM between", value1, value2, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUIdnumNotBetween(String value1, String value2) {
            addCriterion("u_IDNUM not between", value1, value2, "uIdnum");
            return (Criteria) this;
        }

        public Criteria andUAccountIsNull() {
            addCriterion("u_account is null");
            return (Criteria) this;
        }

        public Criteria andUAccountIsNotNull() {
            addCriterion("u_account is not null");
            return (Criteria) this;
        }

        public Criteria andUAccountEqualTo(String value) {
            addCriterion("u_account =", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotEqualTo(String value) {
            addCriterion("u_account <>", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThan(String value) {
            addCriterion("u_account >", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountGreaterThanOrEqualTo(String value) {
            addCriterion("u_account >=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThan(String value) {
            addCriterion("u_account <", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLessThanOrEqualTo(String value) {
            addCriterion("u_account <=", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountLike(String value) {
            addCriterion("u_account like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotLike(String value) {
            addCriterion("u_account not like", value, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountIn(List<String> values) {
            addCriterion("u_account in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotIn(List<String> values) {
            addCriterion("u_account not in", values, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountBetween(String value1, String value2) {
            addCriterion("u_account between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUAccountNotBetween(String value1, String value2) {
            addCriterion("u_account not between", value1, value2, "uAccount");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("u_password is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("u_password is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("u_password =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("u_password <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("u_password >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("u_password >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("u_password <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("u_password <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("u_password like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("u_password not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("u_password in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("u_password not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("u_password between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("u_password not between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUSaltIsNull() {
            addCriterion("u_salt is null");
            return (Criteria) this;
        }

        public Criteria andUSaltIsNotNull() {
            addCriterion("u_salt is not null");
            return (Criteria) this;
        }

        public Criteria andUSaltEqualTo(String value) {
            addCriterion("u_salt =", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltNotEqualTo(String value) {
            addCriterion("u_salt <>", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltGreaterThan(String value) {
            addCriterion("u_salt >", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltGreaterThanOrEqualTo(String value) {
            addCriterion("u_salt >=", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltLessThan(String value) {
            addCriterion("u_salt <", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltLessThanOrEqualTo(String value) {
            addCriterion("u_salt <=", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltLike(String value) {
            addCriterion("u_salt like", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltNotLike(String value) {
            addCriterion("u_salt not like", value, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltIn(List<String> values) {
            addCriterion("u_salt in", values, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltNotIn(List<String> values) {
            addCriterion("u_salt not in", values, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltBetween(String value1, String value2) {
            addCriterion("u_salt between", value1, value2, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSaltNotBetween(String value1, String value2) {
            addCriterion("u_salt not between", value1, value2, "uSalt");
            return (Criteria) this;
        }

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(Byte value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(Byte value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(Byte value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(Byte value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(Byte value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<Byte> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<Byte> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(Byte value1, Byte value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(Byte value1, Byte value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(String value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(String value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(String value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(String value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(String value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLike(String value) {
            addCriterion("u_phone like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotLike(String value) {
            addCriterion("u_phone not like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<String> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<String> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(String value1, String value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(String value1, String value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNull() {
            addCriterion("u_email is null");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNotNull() {
            addCriterion("u_email is not null");
            return (Criteria) this;
        }

        public Criteria andUEmailEqualTo(String value) {
            addCriterion("u_email =", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotEqualTo(String value) {
            addCriterion("u_email <>", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThan(String value) {
            addCriterion("u_email >", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThanOrEqualTo(String value) {
            addCriterion("u_email >=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThan(String value) {
            addCriterion("u_email <", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThanOrEqualTo(String value) {
            addCriterion("u_email <=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLike(String value) {
            addCriterion("u_email like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotLike(String value) {
            addCriterion("u_email not like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailIn(List<String> values) {
            addCriterion("u_email in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotIn(List<String> values) {
            addCriterion("u_email not in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailBetween(String value1, String value2) {
            addCriterion("u_email between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotBetween(String value1, String value2) {
            addCriterion("u_email not between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUStateIsNull() {
            addCriterion("u_state is null");
            return (Criteria) this;
        }

        public Criteria andUStateIsNotNull() {
            addCriterion("u_state is not null");
            return (Criteria) this;
        }

        public Criteria andUStateEqualTo(Byte value) {
            addCriterion("u_state =", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateNotEqualTo(Byte value) {
            addCriterion("u_state <>", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateGreaterThan(Byte value) {
            addCriterion("u_state >", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("u_state >=", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateLessThan(Byte value) {
            addCriterion("u_state <", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateLessThanOrEqualTo(Byte value) {
            addCriterion("u_state <=", value, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateIn(List<Byte> values) {
            addCriterion("u_state in", values, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateNotIn(List<Byte> values) {
            addCriterion("u_state not in", values, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateBetween(Byte value1, Byte value2) {
            addCriterion("u_state between", value1, value2, "uState");
            return (Criteria) this;
        }

        public Criteria andUStateNotBetween(Byte value1, Byte value2) {
            addCriterion("u_state not between", value1, value2, "uState");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}