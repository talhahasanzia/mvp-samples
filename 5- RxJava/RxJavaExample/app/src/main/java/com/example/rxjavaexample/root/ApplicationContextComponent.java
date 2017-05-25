
package com.example.rxjavaexample.root;


import com.example.retrofit.root.ApplicationContextModule;
import com.example.rxjavaexample.MainActivity;
import com.example.rxjavaexample.http.ApiModule;

import dagger.Component;

/**
 * Created by tzia on 17-May-17.
 */


@Component(modules = {ApplicationContextModule.class, ApiModule.class})
// Search for dependencies in these listed modules or components in some cases
public interface ApplicationContextComponent
{


    void inject(MainActivity target);
}
