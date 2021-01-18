package com.xietian.graduated.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlaneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaneExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPEcoIsNull() {
            addCriterion("p_eco is null");
            return (Criteria) this;
        }

        public Criteria andPEcoIsNotNull() {
            addCriterion("p_eco is not null");
            return (Criteria) this;
        }

        public Criteria andPEcoEqualTo(Integer value) {
            addCriterion("p_eco =", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoNotEqualTo(Integer value) {
            addCriterion("p_eco <>", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoGreaterThan(Integer value) {
            addCriterion("p_eco >", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_eco >=", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoLessThan(Integer value) {
            addCriterion("p_eco <", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoLessThanOrEqualTo(Integer value) {
            addCriterion("p_eco <=", value, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoIn(List<Integer> values) {
            addCriterion("p_eco in", values, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoNotIn(List<Integer> values) {
            addCriterion("p_eco not in", values, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoBetween(Integer value1, Integer value2) {
            addCriterion("p_eco between", value1, value2, "pEco");
            return (Criteria) this;
        }

        public Criteria andPEcoNotBetween(Integer value1, Integer value2) {
            addCriterion("p_eco not between", value1, value2, "pEco");
            return (Criteria) this;
        }

        public Criteria andPBusIsNull() {
            addCriterion("p_bus is null");
            return (Criteria) this;
        }

        public Criteria andPBusIsNotNull() {
            addCriterion("p_bus is not null");
            return (Criteria) this;
        }

        public Criteria andPBusEqualTo(Integer value) {
            addCriterion("p_bus =", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusNotEqualTo(Integer value) {
            addCriterion("p_bus <>", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusGreaterThan(Integer value) {
            addCriterion("p_bus >", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_bus >=", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusLessThan(Integer value) {
            addCriterion("p_bus <", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusLessThanOrEqualTo(Integer value) {
            addCriterion("p_bus <=", value, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusIn(List<Integer> values) {
            addCriterion("p_bus in", values, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusNotIn(List<Integer> values) {
            addCriterion("p_bus not in", values, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusBetween(Integer value1, Integer value2) {
            addCriterion("p_bus between", value1, value2, "pBus");
            return (Criteria) this;
        }

        public Criteria andPBusNotBetween(Integer value1, Integer value2) {
            addCriterion("p_bus not between", value1, value2, "pBus");
            return (Criteria) this;
        }

        public Criteria andPFcIsNull() {
            addCriterion("p_fc is null");
            return (Criteria) this;
        }

        public Criteria andPFcIsNotNull() {
            addCriterion("p_fc is not null");
            return (Criteria) this;
        }

        public Criteria andPFcEqualTo(Integer value) {
            addCriterion("p_fc =", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcNotEqualTo(Integer value) {
            addCriterion("p_fc <>", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcGreaterThan(Integer value) {
            addCriterion("p_fc >", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_fc >=", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcLessThan(Integer value) {
            addCriterion("p_fc <", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcLessThanOrEqualTo(Integer value) {
            addCriterion("p_fc <=", value, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcIn(List<Integer> values) {
            addCriterion("p_fc in", values, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcNotIn(List<Integer> values) {
            addCriterion("p_fc not in", values, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcBetween(Integer value1, Integer value2) {
            addCriterion("p_fc between", value1, value2, "pFc");
            return (Criteria) this;
        }

        public Criteria andPFcNotBetween(Integer value1, Integer value2) {
            addCriterion("p_fc not between", value1, value2, "pFc");
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