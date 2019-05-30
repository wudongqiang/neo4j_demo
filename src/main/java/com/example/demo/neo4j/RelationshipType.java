package com.example.demo.neo4j;

/**
 * @Auther: wdq
 * @Date: 19-5-27 15:57
 **/
public enum RelationshipType {

    COMPANY_INVEST_TO_COMPANY("CompanyInvestToCompany", "企业对外投资相关"),
    PERSON_INVEST_TO_COMPANY("PersonInvestToCompany", "股东相关"),
    PERSON_LEGAL("PersonLegal", "法人代表相关"),
    PERSON_POSITION("PersonPosition", "高管相关");

    private String code;
    private String name;

    RelationshipType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static RelationshipType parse(String code) {
        for (RelationshipType type : RelationshipType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
