package com.example.locationtrackingapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Bir bağımlılığın ömrünün bir Activityninkiyle aynı olduğunu belirten özel scope.
 * <p>
 * Bu scope bir Uygulama yerine Activity, Fragment and child Fragments ların kullanım süresi boyunca
 * bir singleton gibi davranan bağımlılığı belirtmek için kullanılır.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
