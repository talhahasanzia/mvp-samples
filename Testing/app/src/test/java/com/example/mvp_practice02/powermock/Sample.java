package com.example.mvp_practice02.powermock;

/**
 * Created by Talha Hasan Zia on 19-Mar-18.
 * <p></p><b>Description:</b><p></p> Why class was created?
 * <p></p>
 * <b>Public Methods:</b><p></p> Only listing to public methods usage.
 */
public class Sample {

    private int level;


    public void setLevel(int level) {
        this.level = level;
    }

    public String showData()
    {
        return trashTalk(level) + ", 2ez";
    }


    // private method, cant be tested.
    private String trashTalk(int level) {
        if (level == 0)
            return "noob";
        else
            return Helper.help();
    }
}
