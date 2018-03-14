package com.example.mvp_practice02.service;

/**
 * Created by Talha Hasan Zia on 14-Mar-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class Service {
    private Worker worker;

    public Service() {

    }

    public String doLocalBusiness() {

        Worker worker = new Worker();
        return worker.sendResult();
    }


    public String doExecutiveBusiness() {
        return worker.sendResult();
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }


}
