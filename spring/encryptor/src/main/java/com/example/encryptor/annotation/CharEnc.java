package com.example.encryptor.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.TYPE})
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface CharEnc {
}
