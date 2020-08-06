package com.bkunzh.webtest.controller;


/**
 * @author bingkun_zhang
 * @date 2020/7/3
 */
public class ListQueryRequest {
    private String pmCode;
    private String status;
    private String searchKey;
    private int agentType;

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "ListQueryRequest{" +
                "pmCode='" + pmCode + '\'' +
                ", status='" + status + '\'' +
                ", searchKey='" + searchKey + '\'' +
                ", agentType=" + agentType +
                '}';
    }
}
