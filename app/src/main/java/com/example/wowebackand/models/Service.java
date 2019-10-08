package com.example.wowebackand.models;

public class Service
{
    private int serviceId;

    private String serviceName;

    private int serviceImageId;

    private String linkImage;

    public Service() {

    }

    public Service(int serviceId, String serviceName, int serviceImageId, String linkImage) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceImageId = serviceImageId;
        this.linkImage = linkImage;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceImageId() {
        return serviceImageId;
    }

    public void setServiceImageId(int serviceImageId) {
        this.serviceImageId = serviceImageId;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
