package com.wtoip.analysis.core.framwork.spring.aspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtoip.analysis.core.framwork.cache.LocalCache;
import com.wtoip.analysis.core.framwork.spring.annotation.ParameterValueKey;

/** 
 *  @Description:
 *	@author wanghongwei
 *  @date:  2017年3月24日
 */
public abstract class AbstrackCacheAspect {
	
	protected Logger log = LoggerFactory.getLogger(AbstrackCacheAspect.class);
	
	private static final Comparator<ParameterValueKey> COMPARATOR = new ParameterValueKeyComparator();
	
	protected LocalCache localCache;
	
	protected String namespace;
	
	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	/**
	 * @return the localCache
	 */
	public LocalCache getLocalCache() {
		return localCache;
	}

	/**
	 * @param localCache the localCache to set
	 */
	public void setLocalCache(LocalCache localCache) {
		this.localCache = localCache;
	}

	/**
	 *  获取存储key
	 * @param pjp
	 * @param key
	 * @return
	 */
	protected String getKey(ProceedingJoinPoint pjp,String key){
        try {
            Object args[] = pjp.getArgs();
            if(args!=null && args.length>0){
            	Collection<Integer> keyIndexes = getKeyIndexes(pjp);
            	if(keyIndexes!=null && keyIndexes.size()>0){
	            	for(Iterator<Integer> iter = keyIndexes.iterator(); iter.hasNext();){
	            		Integer i = iter.next();
	            		key += "_" + args[i];
	            	}
            	}
            }
			return key;
		} catch (Exception e) {
			log.error("get key faild:",e);
		} 
		return null;
	}
	
	/**
	 * 获取keys 根据order排序
	 * @param targetMethod
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private Collection<Integer> getKeyIndexes(ProceedingJoinPoint pjp) throws NoSuchMethodException, SecurityException{
		Object target = pjp.getTarget();
		Class<?> cls = target.getClass();
		
		MethodSignature msig = (MethodSignature)pjp.getSignature();
		
        Method targetMethod = cls.getMethod(msig.getName(), msig.getParameterTypes());
		
        Annotation[][] paramAnnotationArrays = targetMethod.getParameterAnnotations();
        SortedMap<ParameterValueKey, Integer> keyProviders = new TreeMap<ParameterValueKey, Integer>(COMPARATOR);
        Set<Integer> order = new HashSet<Integer>();

        if (paramAnnotationArrays == null || paramAnnotationArrays.length < 1) {
            return Collections.emptyList();
        }

        for (int ix = 0; ix < paramAnnotationArrays.length; ix++) {
            final ParameterValueKey keyProviderAnnotation = getAnnotation(ParameterValueKey.class,
                    paramAnnotationArrays[ix]);
            if (keyProviderAnnotation == null) {
                continue;
            }

            // throw if order below 0
            if (keyProviderAnnotation.value() < 0) {
                throw new InvalidParameterException(String.format(
                        "invalid order [%d] defined in annotation [%s] on method [%s]",
                        keyProviderAnnotation.value(), ParameterValueKey.class.getName(), targetMethod.getName()));
            }
            // throw exception if there are two annotations with the same value of order
            if (!order.add(keyProviderAnnotation.value())) {
            	throw new InvalidParameterException(String.format(
                        "invalid orderdefined in annotation [%s] on method [%s]",
                        ParameterValueKey.class.getName(), targetMethod.getName()));
            }

            keyProviders.put(keyProviderAnnotation, ix);
        }
        Collection<Integer> keys = keyProviders.values();
        return keys;
    }
	
	@SuppressWarnings("unchecked")
	private <T extends Annotation> T getAnnotation(final Class<T> annotationClass, final Annotation[] annotations) {
        if (annotations != null && annotations.length > 0) {
            for (final Annotation annotation : annotations) {
                if (annotationClass.equals(annotation.annotationType())) {
                    return (T) annotation;
                }
            }
        }
        return null;
    }

    private static class ParameterValueKeyComparator implements Comparator<ParameterValueKey>, Serializable {

        private static final long serialVersionUID = 2791887056140560908L;

        @Override
        public int compare(final ParameterValueKey o1, final ParameterValueKey o2) {
            return o1.value() - o2.value();
        }

    }
}
