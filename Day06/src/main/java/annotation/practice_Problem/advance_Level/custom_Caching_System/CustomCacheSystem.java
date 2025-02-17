package annotation.practice_Problem.advance_Level.custom_Caching_System;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

// Step 2: Create the CacheManager to store the cache
class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object getFromCache(String key) {
        return cache.get(key);
    }

    public static void putInCache(String key, Object value) {
        cache.put(key, value);
    }

    public static boolean isInCache(String key) {
        return cache.containsKey(key);
    }
}

// Step 3: Create the CacheProxy (custom proxy for caching logic)
class CacheProxy implements InvocationHandler {
    private final Object target;

    public CacheProxy(Object target) {
        this.target = target;
    }

    public static Object newInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CacheProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = generateCacheKey(method, args);
            if (CacheManager.isInCache(cacheKey)) {
                System.out.println("Returning cached result for: " + cacheKey);
                return CacheManager.getFromCache(cacheKey);
            } else {
                Object result = method.invoke(target, args);
                CacheManager.putInCache(cacheKey, result);
                System.out.println("Storing result in cache for: " + cacheKey);
                return result;
            }
        }
        return method.invoke(target, args);
    }

    private String generateCacheKey(Method method, Object[] args) {
        StringBuilder key = new StringBuilder(method.getName());
        for (Object arg : args) {
            key.append(":").append(arg);
        }
        return key.toString();
    }
}

// Step 4: Create the ExpensiveService interface and its implementation
interface ExpensiveService {
    @CacheResult
    int expensiveComputation(int input);
}

class ExpensiveServiceImpl implements ExpensiveService {
    @Override
    public int expensiveComputation(int input) {
        try {
            Thread.sleep(2000);  // Simulate a delay for the expensive computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input * 2;  // Example computation
    }
}

// Step 5: Main class to run the example
public class CustomCacheSystem {
    public static void main(String[] args) {
        // Create the original service
        ExpensiveService expensiveService = new ExpensiveServiceImpl();

        // Wrap the service with the cache proxy
        ExpensiveService proxyService = (ExpensiveService) CacheProxy.newInstance(expensiveService);

        // Test the caching behavior
        System.out.println(proxyService.expensiveComputation(5));  // First call, computation happens
        System.out.println(proxyService.expensiveComputation(5));  // Second call, should return cached result
        System.out.println(proxyService.expensiveComputation(10)); // New input, computation happens
    }
}
