package com.crudsa.entity;

public class ApiResponseF<T> {
    private String isSuccess;
    private ApiError successMessage;
    private T data;
    private String pagination;
    private ApiError apiError;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ApiError getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(ApiError successMessage) {
        this.successMessage = successMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPagination() {
        return pagination;
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }    

    public ApiResponseF(String isSuccess, ApiError successMessage, T data, String pagination, ApiError apiError) {
        this.isSuccess = isSuccess;
        this.successMessage = successMessage;
        this.data = data;
        this.pagination = pagination;
        this.apiError = apiError;
    }

    public ApiResponseF() {
    }   
    
}
