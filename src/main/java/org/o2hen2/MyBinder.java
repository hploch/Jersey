package org.o2hen2;

import javax.inject.Singleton;

import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(MyInjectionResolver.class)
                .to(new TypeLiteral<InjectionResolver<MyAnnotation>>() {})
                .in(Singleton.class);
    }
}
