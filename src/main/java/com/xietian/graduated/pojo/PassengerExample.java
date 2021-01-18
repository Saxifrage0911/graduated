package com.xietian.graduated.pojo;

import java.util.ArrayList;
import java.util.List;

public class PassengerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PassengerExample() {
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

        public Criteria andPassIdIsNull() {
            addCriterion("pass_id is null");
            return (Criteria) this;
        }

        public Criteria andPassIdIsNotNull() {
            addCriterion("pass_id is not null");
            return (Criteria) this;
        }

        public Criteria andPassIdEqualTo(Integer value) {
            addCriterion("pass_id =", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdNotEqualTo(Integer value) {
            addCriterion("pass_id <>", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdGreaterThan(Integer value) {
            addCriterion("pass_id >", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_id >=", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdLessThan(Integer value) {
            addCriterion("pass_id <", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdLessThanOrEqualTo(Integer value) {
            addCriterion("pass_id <=", value, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdIn(List<Integer> values) {
            addCriterion("pass_id in", values, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdNotIn(List<Integer> values) {
            addCriterion("pass_id not in", values, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdBetween(Integer value1, Integer value2) {
            addCriterion("pass_id between", value1, value2, "passId");
            return (Criteria) this;
        }

        public Criteria andPassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_id not between", value1, value2, "passId");
            return (Criteria) this;
        }

        public Criteria andPIdnumIsNull() {
            addCriterion("p_IDNUM is null");
            return (Criteria) this;
        }

        public Criteria andPIdnumIsNotNull() {
            addCriterion("p_IDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andPIdnumEqualTo(String value) {
            addCriterion("p_IDNUM =", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumNotEqualTo(String value) {
            addCriterion("p_IDNUM <>", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumGreaterThan(String value) {
            addCriterion("p_IDNUM >", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("p_IDNUM >=", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumLessThan(String value) {
            addCriterion("p_IDNUM <", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumLessThanOrEqualTo(String value) {
            addCriterion("p_IDNUM <=", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumLike(String value) {
            addCriterion("p_IDNUM like", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumNotLike(String value) {
            addCriterion("p_IDNUM not like", value, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumIn(List<String> values) {
            addCriterion("p_IDNUM in", values, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumNotIn(List<String> values) {
            addCriterion("p_IDNUM not in", values, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumBetween(String value1, String value2) {
            addCriterion("p_IDNUM between", value1, value2, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPIdnumNotBetween(String value1, String value2) {
            addCriterion("p_IDNUM not between", value1, value2, "pIdnum");
            return (Criteria) this;
        }

        public Criteria andPRealnameIsNull() {
            addCriterion("p_realName is null");
            return (Criteria) this;
        }

        public Criteria andPRealnameIsNotNull() {
            addCriterion("p_realName is not null");
            return (Criteria) this;
        }

        public Criteria andPRealnameEqualTo(String value) {
            addCriterion("p_realName =", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameNotEqualTo(String value) {
            addCriterion("p_realName <>", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameGreaterThan(String value) {
            addCriterion("p_realName >", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("p_realName >=", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameLessThan(String value) {
            addCriterion("p_realName <", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameLessThanOrEqualTo(String value) {
            addCriterion("p_realName <=", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameLike(String value) {
            addCriterion("p_realName like", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameNotLike(String value) {
            addCriterion("p_realName not like", value, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameIn(List<String> values) {
            addCriterion("p_realName in", values, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameNotIn(List<String> values) {
            addCriterion("p_realName not in", values, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameBetween(String value1, String value2) {
            addCriterion("p_realName between", value1, value2, "pRealname");
            return (Criteria) this;
        }

        public Criteria andPRealnameNotBetween(String value1, String value2) {
            addCriterion("p_realName not between", value1, value2, "pRealname");
            return (Criteria) this;
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