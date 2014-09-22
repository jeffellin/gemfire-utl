package com.ellin.gemfire.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;


@Component
public class CacheFactory {

    @Autowired
    private ReflectionBasedAutoSerializer pdxAutoSerializer;

    private ClientCache cache;

    public void stop(){
        if(cache!=null){
            cache.close();
            cache = null;
        }

    }



    public void startLocator(String host, int port){
        System.out.println("Connecting to Locator: "+host+"["+port+"]");

        cache = new ClientCacheFactory().setPdxReadSerialized(true)
                .setPdxSerializer(pdxAutoSerializer).addPoolLocator(host, port)
                .create();
    }


    public void startServer(String host, int port){
        System.out.println("Connecting to Server: "+host+"["+port+"]");

        cache = new ClientCacheFactory().setPdxReadSerialized(true)
                .setPdxSerializer(pdxAutoSerializer).addPoolServer(host, port)
                .create();
    }

    public ClientCache getCache() {
        if(cache==null){
            throw new RuntimeException("Cache Must be initialized before use");
        }
        return cache;
    }

}