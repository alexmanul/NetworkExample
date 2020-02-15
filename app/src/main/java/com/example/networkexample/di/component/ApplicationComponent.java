package com.example.networkexample.di.component;

import android.app.Application;

import com.example.networkexample.application.MyApplication;
import com.example.networkexample.di.builder.ActivityBuilder;
import com.example.networkexample.di.module.RecyclerViewModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        RecyclerViewModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
