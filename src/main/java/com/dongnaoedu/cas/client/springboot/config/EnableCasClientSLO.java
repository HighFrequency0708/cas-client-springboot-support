package com.dongnaoedu.cas.client.springboot.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * enable CAS Single Logout (SLO)
 * 
 * @author dongnaoedu.tony
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(CasClientSLOConfiguration.class)
public @interface EnableCasClientSLO {
}