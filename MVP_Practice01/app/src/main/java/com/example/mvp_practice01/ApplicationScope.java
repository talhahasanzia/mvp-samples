package com.example.mvp_practice01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by tzia on 17-May-17.
 *
 * Application scope is same as Singleton, but for 1 builder instance
 *
 * Dont use Singleton with application scope
 *
 */

@Scope
@Retention(RetentionPolicy.CLASS )
public @interface ApplicationScope
{



}
